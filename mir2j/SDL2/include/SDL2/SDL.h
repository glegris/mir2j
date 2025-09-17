#ifndef SDL2_STUBS_H
#define SDL2_STUBS_H

#include <stdint.h>
#include <stddef.h>  // size_t

/* Flags for SDL_Init */
#define SDL_INIT_VIDEO               0x00000020u

/* Flags for window / renderer / texture */
#define SDL_WINDOW_SHOWN             0x00000004u
#define SDL_RENDERER_PRESENTVSYNC    0x00000004u
#define SDL_TEXTUREACCESS_STREAMING  1

/* Pixel formats */
#define SDL_PIXELFORMAT_BGR565       0x00000000u

/* Events (subset) */
#define SDL_QUIT                     0x00000100u
#define SDL_KEYDOWN                  0x00000300u
#define SDL_KEYUP                    0x00000301u
#define SDL_MOUSEMOTION              0x00000400u
#define SDL_MOUSEBUTTONDOWN          0x00000401u
#define SDL_MOUSEBUTTONUP            0x00000402u
#define SDL_MOUSEWHEEL               0x00000403u

/* Key state */
#define SDL_PRESSED   1
#define SDL_RELEASED  0

/* Mouse buttons (SDL semantics) */
#define SDL_BUTTON_LEFT    1
#define SDL_BUTTON_MIDDLE  2
#define SDL_BUTTON_RIGHT   3
#define SDL_BUTTON(X)      (1u << ((X)-1))

/* Scancodes (TODO: to complete) */
enum {
  SDL_SCANCODE_A = 4,  /* A..Z => 4..29 */
  SDL_SCANCODE_B, SDL_SCANCODE_C, SDL_SCANCODE_D, SDL_SCANCODE_E, SDL_SCANCODE_F,
  SDL_SCANCODE_G, SDL_SCANCODE_H, SDL_SCANCODE_I, SDL_SCANCODE_J, SDL_SCANCODE_K,
  SDL_SCANCODE_L, SDL_SCANCODE_M, SDL_SCANCODE_N, SDL_SCANCODE_O, SDL_SCANCODE_P,
  SDL_SCANCODE_Q, SDL_SCANCODE_R, SDL_SCANCODE_S, SDL_SCANCODE_T, SDL_SCANCODE_U,
  SDL_SCANCODE_V, SDL_SCANCODE_W, SDL_SCANCODE_X, SDL_SCANCODE_Y, SDL_SCANCODE_Z,

  SDL_SCANCODE_1 = 30, /* 1..9 -> 30..38, 0 -> 39 */
  SDL_SCANCODE_2, SDL_SCANCODE_3, SDL_SCANCODE_4, SDL_SCANCODE_5,
  SDL_SCANCODE_6, SDL_SCANCODE_7, SDL_SCANCODE_8, SDL_SCANCODE_9,
  SDL_SCANCODE_0,

  SDL_SCANCODE_RETURN = 40,
  SDL_SCANCODE_ESCAPE = 41,
  SDL_SCANCODE_BACKSPACE = 42,
  SDL_SCANCODE_TAB = 43,
  SDL_SCANCODE_SPACE = 44,

  SDL_SCANCODE_LEFT = 80, SDL_SCANCODE_RIGHT = 79,
  SDL_SCANCODE_DOWN = 81, SDL_SCANCODE_UP = 82,
};

/* ==== Opaque types ==== */
typedef struct SDL_Window   SDL_Window;
typedef struct SDL_Renderer SDL_Renderer;
typedef struct SDL_Texture  SDL_Texture;
typedef struct SDL_RWops    SDL_RWops;

/* Minimal SDL_Rect replacement */
typedef struct SDL_Rect { int x, y, w, h; } SDL_Rect;

/* ==== Minimal events with layout EXACT to backend ==== */

/* Keyboard event
 * Offsets:
 *  +0 : u32 type
 *  +4 : s32 scancode
 *  +8 : s32 sym (keycode)
 * +12 : s32 mod (bitmask)
 * +16 : u8  state (1=down,0=up)
 * +17 : u8  repeat
 */
typedef struct SDL_KeyboardEvent {
  uint32_t type;
  int32_t  scancode;
  int32_t  sym;
  int32_t  mod;
  uint8_t  state;
  uint8_t  repeat;
  uint8_t  _pad[2];  /* keep 4-byte alignment */
} SDL_KeyboardEvent;

/* Mouse motion:
 * +0 : u32 type
 * +4 : s32 x
 * +8 : s32 y
 * +12: s32 xrel
 * +16: s32 yrel
 * +20: u32 state (buttons mask)
 */
typedef struct SDL_MouseMotionEvent {
  uint32_t type;
  int32_t  x, y;
  int32_t  xrel, yrel;
  uint32_t state;
} SDL_MouseMotionEvent;

/* Mouse button:
 * +0 : u32 type
 * +4 : u8  button (1=L,2=M,3=R)
 * +5 : u8  state  (1=down,0=up)
 * +6 : u8  clicks
 * +7 : u8  pad
 * +8 : s32 x
 * +12: s32 y
 */
typedef struct SDL_MouseButtonEvent {
  uint32_t type;
  uint8_t  button;
  uint8_t  state;
  uint8_t  clicks;
  uint8_t  _pad0;
  int32_t  x, y;
} SDL_MouseButtonEvent;

/* Mouse wheel:
 * +0 : u32 type
 * +4 : s32 x (horizontal)
 * +8 : s32 y (vertical)
 */
typedef struct SDL_MouseWheelEvent {
  uint32_t type;
  int32_t  x, y;
} SDL_MouseWheelEvent;

/* Unified event */
typedef union SDL_Event {
  uint32_t             type;   /* always first */
  SDL_KeyboardEvent    key;
  SDL_MouseMotionEvent motion;
  SDL_MouseButtonEvent button;
  SDL_MouseWheelEvent  wheel;
} SDL_Event;

/* ==== Function prototypes ==== */

/* Initialization */
int SDL_Init(uint32_t flags);

/* Window / renderer / texture */
SDL_Window*   SDL_CreateWindow(const char *title, int x, int y, int w, int h, uint32_t flags);
SDL_Renderer* SDL_CreateRenderer(SDL_Window *window, int index, uint32_t flags);
SDL_Texture*  SDL_CreateTexture(SDL_Renderer *renderer, uint32_t format, int access, int w, int h);

int  SDL_UpdateTexture(SDL_Texture *texture, const SDL_Rect *rect, const void *pixels, int pitch);
int  SDL_RenderCopy(SDL_Renderer *renderer, SDL_Texture *texture, const SDL_Rect *srcrect, const SDL_Rect *dstrect);
void SDL_RenderPresent(SDL_Renderer *renderer);

/* Events */
void SDL_PumpEvents(void);
int  SDL_PollEvent(SDL_Event *event);

/* Keyboard */
const uint8_t* SDL_GetKeyboardState(int *numkeys);

/* RWops (file I/O) */
SDL_RWops* SDL_RWFromFile(const char *file, const char *mode);
size_t     SDL_RWread(SDL_RWops *context, void *ptr, size_t size, size_t maxnum);

/* Cleanup functions */
void SDL_DestroyWindow(SDL_Window *window);
void SDL_DestroyRenderer(SDL_Renderer *renderer);
void SDL_DestroyTexture(SDL_Texture *texture);

#endif /* SDL2_STUBS_H */
