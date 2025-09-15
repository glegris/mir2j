/*
MIT License

Copyright (c) 2025 Guillaume Legris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package raygui4j;

public interface Backend {

    // Event bridge: the backend notifies Raygui (which keeps the edge accumulators)
    interface InputSink {
        void onKeyDown(int rayKey);

        void onKeyUp(int rayKey);

        void onCharTyped(char c);

        void onMouseDown(int rayButton, int x, int y);

        void onMouseUp(int rayButton, int x, int y);

        void onMouseMove(int x, int y);

        void onResize(int w, int h);
    }

    // Lifecycle / Window
    void initWindow(int width, int height, String title, InputSink sink);

    // Frame pacing
    void beginFrame(); // flush toolkit event queue

    void endFrame(); // immediate swap/paint

    // Screen size
    int getScreenWidth();

    int getScreenHeight();

    // Drawing (colors in RGBA 0xRRGGBBAA)
    void clearBackground(int rgba);

    void drawRectangle(int x, int y, int w, int h, int rgba);

    public void drawRectangleGradientEx(int x, int y, int w, int h, int colTL, int colTR, int colBL, int colBR);

    void drawTextCodepoint(float x, float y, int codepoint, float fontSize, int rgbaTint, long fontHandle);

    // Default monospace metrics (for GetFontDefault)
    int getMaxCharWidth();

    int getMaxCharHeight();
}
