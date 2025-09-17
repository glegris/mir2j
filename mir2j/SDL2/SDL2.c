#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <SDL2/SDL.h>

/* ==== Backend primitives provided by Runtime.java ==== */
int  mir_sdl_create_window(const char *title, int w, int h, uint32_t flags);         /* returns winId>=0 or -errno */
int  mir_sdl_destroy_window(int winId);
int  mir_sdl_create_renderer(int winId, uint32_t flags);                             /* returns rendId>=0 or -errno */
int  mir_sdl_destroy_renderer(int rendId);
int  mir_sdl_create_texture(int rendId, uint32_t format, int access, int w, int h);  /* returns texId>=0 or -errno */
int  mir_sdl_destroy_texture(int texId);
int  mir_sdl_update_texture(int texId, long pixelsAddr, int pitch, int w, int h, uint32_t format);
int  mir_sdl_render_copy(int rendId, int texId);
int  mir_sdl_render_present(int rendId);
int  mir_sdl_poll_event(long eventAddr);                                             /* returns 1 if event, 0 otherwise */
int  mir_sdl_get_keyboard_state(long destAddr, int maxLen);                          /* writes up to maxLen bytes */

/* ==== Minimal opaque structures ==== */
struct SDL_Window   { int id; int w, h; char *title; };
struct SDL_Renderer { int id; SDL_Window *win; };
struct SDL_Texture  { int id; int w, h, access; uint32_t format; };
struct SDL_RWops    { FILE *fp; };

/* Keyboard state buffer (256 scancodes) */
static uint8_t g_key_state[256] = {0};

static uint32_t g_mouse_buttons_mask = 0;

/* ==== Implementation ==== */

int SDL_Init(uint32_t flags) {
  (void)flags;
  return 0;
}

SDL_Window* SDL_CreateWindow(const char *title, int x, int y, int w, int h, uint32_t flags) {
  (void)x; (void)y;
  SDL_Window *win = (SDL_Window*)calloc(1, sizeof(SDL_Window));
  if (!win) return NULL;
  int id = mir_sdl_create_window(title ? title : "SDL", w, h, flags);
  if (id < 0) { free(win); return NULL; }
  win->id = id; win->w = w; win->h = h;
  if (title) {
    size_t n = strlen(title);
    win->title = (char*)malloc(n + 1);
    if (win->title) memcpy(win->title, title, n + 1);
  }
  return win;
}

SDL_Renderer* SDL_CreateRenderer(SDL_Window *window, int index, uint32_t flags) {
  (void)index;
  if (!window) return NULL;
  SDL_Renderer *r = (SDL_Renderer*)calloc(1, sizeof(SDL_Renderer));
  if (!r) return NULL;
  int id = mir_sdl_create_renderer(window->id, flags);
  if (id < 0) { free(r); return NULL; }
  r->id = id; r->win = window;
  return r;
}

SDL_Texture* SDL_CreateTexture(SDL_Renderer *renderer, uint32_t format, int access, int w, int h) {
  if (!renderer) return NULL;
  SDL_Texture *t = (SDL_Texture*)calloc(1, sizeof(SDL_Texture));
  if (!t) return NULL;
  int id = mir_sdl_create_texture(renderer->id, format, access, w, h);
  if (id < 0) { free(t); return NULL; }
  t->id = id; t->w = w; t->h = h; t->access = access; t->format = format;
  return t;
}

int SDL_UpdateTexture(SDL_Texture *texture, const SDL_Rect *rect, const void *pixels, int pitch) {
  /* Nous ne gérons que la mise à jour complète (rect==NULL). */
  if (!texture || !pixels) return -1;
  if (rect != NULL) return 0; /* ou -1 si tu préfères forcer full-surface */
  return mir_sdl_update_texture(texture->id, (long)pixels, pitch, texture->w, texture->h, texture->format);
}

int SDL_RenderCopy(SDL_Renderer *renderer, SDL_Texture *texture, const SDL_Rect *srcrect, const SDL_Rect *dstrect) {
  (void)srcrect; (void)dstrect;
  if (!renderer || !texture) return -1;
  return mir_sdl_render_copy(renderer->id, texture->id);
}

void SDL_RenderPresent(SDL_Renderer *renderer) {
  if (!renderer) return;
  mir_sdl_render_present(renderer->id);
}

/* Apply one event to our snapshots (keyboard/mouse) */
static void sdl_apply_event_to_state(const SDL_Event *ev) {
  if (!ev) return;

  switch (ev->type) {
    case SDL_KEYDOWN: {
      /* Clamp scancode to 0..255 */
      int sc = ev->key.scancode;
      if ((unsigned)sc < 256u) g_key_state[sc] = SDL_PRESSED;
      break;
    }
    case SDL_KEYUP: {
      int sc = ev->key.scancode;
      if ((unsigned)sc < 256u) g_key_state[sc] = SDL_RELEASED;
      break;
    }
    case SDL_MOUSEMOTION: {
      /* Nothing to change for keyboard snapshot; keep mouse mask if needed */
      break;
    }
    case SDL_MOUSEBUTTONDOWN: {
      /* Maintain a mouse buttons bitmask if you later want SDL_GetMouseState */
      uint8_t b = ev->button.button;
      if (b >= 1 && b <= 32) g_mouse_buttons_mask |= SDL_BUTTON(b);
      break;
    }
    case SDL_MOUSEBUTTONUP: {
      uint8_t b = ev->button.button;
      if (b >= 1 && b <= 32) g_mouse_buttons_mask &= ~SDL_BUTTON(b);
      break;
    }
    default: break;
  }
}

/* DOES NOT dequeue events: just refresh the keyboard snapshot from backend */
void SDL_PumpEvents(void) {
  /* Backend writes *current* pressed/unpressed scancodes into our buffer.
     It MUST NOT touch the event queue. */
  (void) mir_sdl_get_keyboard_state((long)g_key_state, (int)sizeof(g_key_state));
}

/* Dequeue one event from Java backend and update snapshots */
int SDL_PollEvent(SDL_Event *event) {
  int got = mir_sdl_poll_event((long)event);
  if (got > 0 && event) {
    /* Update keystate/mousestate from this event as SDL would after Pump */
    sdl_apply_event_to_state(event);
  }
  return got;
}

const uint8_t* SDL_GetKeyboardState(int *numkeys) {
  if (numkeys) *numkeys = (int)sizeof(g_key_state);
  return g_key_state;
}

/* RWops : stdio direct */
SDL_RWops* SDL_RWFromFile(const char *file, const char *mode) {
  SDL_RWops *rw = (SDL_RWops*)calloc(1, sizeof(SDL_RWops));
  if (!rw) return NULL;
  rw->fp = fopen(file, mode);
  if (!rw->fp) { free(rw); return NULL; }
  return rw;
}

size_t SDL_RWread(SDL_RWops *context, void *ptr, size_t size, size_t maxnum) {
  if (!context || !context->fp || !ptr || size == 0 || maxnum == 0) return 0;
  return fread(ptr, size, maxnum, context->fp);
}

/* ==== Cleanup ==== */

void SDL_DestroyTexture(SDL_Texture *t) {
  if (!t) return;
  mir_sdl_destroy_texture(t->id);
  free(t);
}

void SDL_DestroyRenderer(SDL_Renderer *r) {
  if (!r) return;
  mir_sdl_destroy_renderer(r->id);
  free(r);
}

void SDL_DestroyWindow(SDL_Window *w) {
  if (!w) return;
  mir_sdl_destroy_window(w->id);
  free(w->title);
  free(w);
}
