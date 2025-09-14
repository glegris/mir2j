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
