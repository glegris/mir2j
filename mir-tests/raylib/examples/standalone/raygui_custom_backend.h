/*******************************************************************************************
*
*   raygui - Standalone mode custom backend
*
*   Just edit this file to include your custom implementation to your graphic API
*
*   LICENSE: <your_license>
*
*   Copyright (c) <year> <developer_name>
*
**********************************************************************************************/

//#include "my_cool_graphic_api.h"

//----------------------------------------------------------------------------------
// Defines and Macros
// TODO: Define input keys required by raygui
//----------------------------------------------------------------------------------

/*
#define KEY_RIGHT           262
#define KEY_LEFT            263
#define KEY_DOWN            264
#define KEY_UP              265
#define KEY_BACKSPACE       259
#define KEY_ENTER           257
#define MOUSE_LEFT_BUTTON     0
*/

//----------------------------------------------------------------------------------
// Types and Structures Definition
// TODO: Define required structures, maybe Font/Texture2D should be defined here?
//----------------------------------------------------------------------------------
// ...
void ClearBackground(Color c) {
    printf("[DEBUG] ClearBackground()\n");
	// TODO:  Set background color (framebuffer clear color)
}   

int GetScreenWidth(void) {
    printf("[DEBUG] GetScreenWidth()\n");
	// TODO: Get current screen width
	return 640;
}                                   

int GetScreenHeight(void) {
    printf("[DEBUG] GetScreenHeight()\n");
	// TODO: Get current screen height  
	return 480;
}                                                      

//----------------------------------------------------------------------------------
// Global Variables Definition
//----------------------------------------------------------------------------------
// ...

//----------------------------------------------------------------------------------
// Module Functions Definition
// TODO: Define all raygui required functions (previously provided by raylib)
//----------------------------------------------------------------------------------

void InitWindow(int screenWidth, int screenHeight, char* screenName) {
  printf("[DEBUG] InitWindow()\n");	
}

void BeginDrawing() {
  printf("[DEBUG] BeginDrawing()\n");
} 

void EndDrawing() {
  printf("[DEBUG] EndDrawing()\n");
}                     



//-------------------------------------------------------------------------------
// Input required functions
//-------------------------------------------------------------------------------
Vector2 GetMousePosition(void)
{
    printf("[DEBUG] GetMousePosition()\n");
    Vector2 position = { 0 };
    
    // TODO: Mouse position
    
    return position;
}

float GetMouseWheelMove(void)
{
    printf("[DEBUG] GetMouseWheelMove()\n");
    // TODO: Mouse wheel movement variation, reseted every frame
    
    return 0;
}

bool IsMouseButtonDown(int button)
{
    printf("[DEBUG] IsMouseButtonDown()\n");
    // TODO: Return true while mouse button [0..2] is being down
    
    return false;
}

bool IsMouseButtonPressed(int button)
{
    printf("[DEBUG] IsMouseButtonPressed()\n");
    // TODO: Return true when mouse button [0..2] has been pressed: up->down
    
    return false;
}

bool IsMouseButtonReleased(int button)
{
    printf("[DEBUG] IsMouseButtonReleased()\n");
    // TODO: Return true when mouse button [0..2] has been released: down->up
    
    return false;
}

bool IsKeyDown(int key)
{
    printf("[DEBUG] IsKeyDown()\n");
    // TODO: Return true while key is being down
    
    return false;
}

bool IsKeyPressed(int key)
{
    printf("[DEBUG] IsKeyPressed()\n");
    // TODO: Return true when key has been pressed: up->down
    
    return false;
}

// USED IN: GuiTextBox(), GuiTextBoxMulti(), GuiValueBox()
int GetCharPressed(void)
{
    printf("[DEBUG] GetCharPressed()\n");
    // TODO: Return last key pressed (up->down) in the frame
    
    return 0;
}

//-------------------------------------------------------------------------------
// Drawing required functions
//-------------------------------------------------------------------------------
void DrawRectangle(int x, int y, int width, int height, Color color)
{ 
    printf("[DEBUG] DrawRectangle()\n");
    // TODO: Draw rectangle on the screen
}

// USED IN: GuiColorPicker()
void DrawRectangleGradientEx(Rectangle rec, Color col1, Color col2, Color col3, Color col4)
{
    printf("[DEBUG] DrawRectangleGradientEx()\n");   
    // TODO: Draw rectangle with gradients (4 vertex colors) on the screen
}

// USED IN: GuiDropdownBox(), GuiScrollBar()
void DrawTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color)
{ 
    printf("[DEBUG] DrawTriangle()\n");
    // TODO: Draw triangle on the screen, required for arrows
}

// USED IN: GuiImageButtonEx()
void DrawTextureRec(Texture2D texture, Rectangle sourceRec, Vector2 position, Color tint)
{
    printf("[DEBUG] DrawTextureRec()\n");
    // TODO: Draw texture (piece defined by source rectangle) on screen
}

/*
// USED IN: GuiTextBoxMulti()
static void DrawTextRec(Font font, const char *text, Rectangle rec, float fontSize, float spacing, bool wordWrap, Color tint)
{
    // TODO: Draw text limited by a rectangle. This advance function wraps the text inside the rectangle
}
*/

// Draw one character (codepoint)
void DrawTextCodepoint(Font font, int codepoint, Vector2 position, float fontSize, Color tint) {
    // TODO: Draw one character (codepoint)
        printf("[DEBUG] DrawTextCodepoint()\n");
    /*
    // Character index position in sprite font
    // NOTE: In case a codepoint is not available in the font, index returned points to '?'
    int index = GetGlyphIndex(font, codepoint);
    float scaleFactor = fontSize/font.baseSize;     // Character quad scaling factor

    // Character destination rectangle on screen
    // NOTE: We consider glyphPadding on drawing
    Rectangle dstRec = { position.x + font.glyphs[index].offsetX*scaleFactor - (float)font.glyphPadding*scaleFactor,
                      position.y + font.glyphs[index].offsetY*scaleFactor - (float)font.glyphPadding*scaleFactor,
                      (font.recs[index].width + 2.0f*font.glyphPadding)*scaleFactor,
                      (font.recs[index].height + 2.0f*font.glyphPadding)*scaleFactor };

    // Character source rectangle from font texture atlas
    // NOTE: We consider chars padding when drawing, it could be required for outline/glow shader effects
    Rectangle srcRec = { font.recs[index].x - (float)font.glyphPadding, font.recs[index].y - (float)font.glyphPadding,
                         font.recs[index].width + 2.0f*font.glyphPadding, font.recs[index].height + 2.0f*font.glyphPadding };

    // Draw the character texture on the screen
    DrawTexturePro(font.texture, srcRec, dstRec, (Vector2){ 0, 0 }, 0.0f, tint);
    */
}

void UnloadTexture(Texture2D texture) 
{
    printf("[DEBUG] UnloadTexture()\n");
	// TODO
}

//-------------------------------------------------------------------------------
// Text required functions
//-------------------------------------------------------------------------------
// USED IN: GuiLoadStyleDefault()

int GetMaxCharWidth()  { return 10; }
int GetMaxCharHeight() { return 10; }

static Font defaultFont = { 0 };

Font GetFontDefault(void)
{
    //printf("[DEBUG] GetFontDefault()\n");
    
    if (defaultFont.glyphs != NULL) {
        return defaultFont;
    }
    int baseH = GetMaxCharHeight();
    int monoW = GetMaxCharWidth();
    int glyphCount = 128;
    
    Rectangle* rects = malloc(glyphCount * sizeof(Rectangle)); 
    GlyphInfo* glyphs = malloc(glyphCount * sizeof(GlyphInfo));
    
    for (int i = 0; i < glyphCount; i++) {
        rects[i] = (Rectangle) { .x = i * monoW, .y = 0, .width = monoW, .height = baseH };
        glyphs[i] = (GlyphInfo) { .value = i, .offsetX = 0, .offsetY = 0, .advanceX = monoW, .image = (Image){0} };
    }

    Texture2D tex = (Texture2D) { .id = 1, .width = monoW * glyphCount, .height = baseH, .mipmaps = 1, .format = 0}; // FIXME format ?
    defaultFont = (Font) { .baseSize = baseH, .glyphCount = glyphCount, .texture = tex, .recs = rects, .glyphs = glyphs };

    return defaultFont; 
}

// USED IN: GetTextWidth(), GuiTextBoxMulti()
// Vector2 MeasureTextEx(Font font, const char *text, float fontSize, float spacing) 
// { 
    // printf("[DEBUG] MeasureTextEx()\n");
    // Vector2 size = { 0 };
    
    // // TODO: Return text size (width, height) on screen depending on the Font, text, fontSize and spacing
    
    // return size;
// }

// USED IN: GuiDrawText()
void DrawTextEx(Font font, const char *text, Vector2 position, float fontSize, float spacing, Color tint)
{
    printf("[DEBUG] DrawTextEx()\n");
    // TODO: Draw text on the screen
}

// USED IN:  GuiLoadStyle(). Set texture and rectangle to be used on shapes drawing
void SetShapesTexture(Texture2D tex, Rectangle rec) {
    printf("[DEBUG] SetShapesTexture()\n");
} 

// USED IN:  GuiLoadStyle()
char *LoadFileText(const char *fileName) {
    // TODO
    printf("[DEBUG] LoadFileText()\n");
    return NULL;	
}           

//static int GetGlyphIndex(Font font, int codepoint) {
//	// TODO
//}

//-------------------------------------------------------------------------------
// GuiLoadStyle() required functions
//-------------------------------------------------------------------------------
Font LoadFontEx(const char *fileName, int fontSize, int *fontChars, int glyphCount)
{
    Font font = { 0 };
    printf("[DEBUG] LoadFontEx()\n");
    
    // TODO: Load a new font from a file
    
    return font; 
}

char *LoadText(const char *fileName)
{
    printf("[DEBUG] LoadText()\n");
    // TODO: Load text file data, used by GuiLoadStyle() to load characters list required on Font generation,
    // this is a .rgs feature, probably this function is not required in most cases

    return NULL;
}

const char *GetDirectoryPath(const char *filePath)
{
    printf("[DEBUG] GetDirectoryPath()\n");
    // TODO: Get directory path for .rgs file, required to look for a possible .ttf/.otf font file referenced,
    // this is a .rgs feature, probably this function is not required in most cases
    
    return NULL;
}

