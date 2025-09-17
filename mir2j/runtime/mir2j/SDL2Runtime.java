package mir2j;

public class SDL2Runtime extends StdlibRuntime {

    /* =========================================================================
     * SDL backend 
     * =========================================================================*/

    // --- SDL event types (subset) ---
    private static final int SDL_QUIT = 0x100;
    private static final int SDL_KEYDOWN = 0x300;
    private static final int SDL_KEYUP = 0x301;
    private static final int SDL_MOUSEMOTION = 0x400;
    private static final int SDL_MOUSEBUTTONDOWN = 0x401;
    private static final int SDL_MOUSEBUTTONUP = 0x402;
    private static final int SDL_MOUSEWHEEL = 0x403;

    // --- SDL scancode base (subset we use often) ---
    private static final int SDL_SCANCODE_A = 4; // A..Z => 4..29
    private static final int SDL_SCANCODE_1 = 30; // 1..0 => 30..38, 0 => 39
    private static final int SDL_SCANCODE_0 = 39;
    private static final int SDL_SCANCODE_RETURN = 40;
    private static final int SDL_SCANCODE_ESCAPE = 41;
    private static final int SDL_SCANCODE_BACKSPACE = 42;
    private static final int SDL_SCANCODE_TAB = 43;
    private static final int SDL_SCANCODE_SPACE = 44;
    private static final int SDL_SCANCODE_MINUS = 45;
    private static final int SDL_SCANCODE_EQUALS = 46;
    private static final int SDL_SCANCODE_LEFTBRACKET = 47;
    private static final int SDL_SCANCODE_RIGHTBRACKET = 48;
    private static final int SDL_SCANCODE_BACKSLASH = 49;
    private static final int SDL_SCANCODE_SEMICOLON = 51;
    private static final int SDL_SCANCODE_APOSTROPHE = 52;
    private static final int SDL_SCANCODE_GRAVE = 53;
    private static final int SDL_SCANCODE_COMMA = 54;
    private static final int SDL_SCANCODE_PERIOD = 55;
    private static final int SDL_SCANCODE_SLASH = 56;
    private static final int SDL_SCANCODE_CAPSLOCK = 57;
    private static final int SDL_SCANCODE_F1 = 58; // F1..F12 => 58..69
    private static final int SDL_SCANCODE_F12 = 69;
    private static final int SDL_SCANCODE_PRINTSCREEN = 70;
    private static final int SDL_SCANCODE_SCROLLLOCK = 71;
    private static final int SDL_SCANCODE_PAUSE = 72;
    private static final int SDL_SCANCODE_INSERT = 73;
    private static final int SDL_SCANCODE_HOME = 74;
    private static final int SDL_SCANCODE_PAGEUP = 75;
    private static final int SDL_SCANCODE_DELETE = 76;
    private static final int SDL_SCANCODE_END = 77;
    private static final int SDL_SCANCODE_PAGEDOWN = 78;
    private static final int SDL_SCANCODE_RIGHT = 79, SDL_SCANCODE_LEFT = 80, SDL_SCANCODE_DOWN = 81, SDL_SCANCODE_UP = 82;
    private static final int SDL_SCANCODE_NUMLOCKCLEAR = 83;
    private static final int SDL_SCANCODE_KP_DIVIDE = 84;
    private static final int SDL_SCANCODE_KP_MULTIPLY = 85;
    private static final int SDL_SCANCODE_KP_MINUS = 86;
    private static final int SDL_SCANCODE_KP_PLUS = 87;
    private static final int SDL_SCANCODE_KP_ENTER = 88;
    private static final int SDL_SCANCODE_KP_1 = 89, SDL_SCANCODE_KP_2 = 90, SDL_SCANCODE_KP_3 = 91;
    private static final int SDL_SCANCODE_KP_4 = 92, SDL_SCANCODE_KP_5 = 93, SDL_SCANCODE_KP_6 = 94;
    private static final int SDL_SCANCODE_KP_7 = 95, SDL_SCANCODE_KP_8 = 96, SDL_SCANCODE_KP_9 = 97, SDL_SCANCODE_KP_0 = 98;
    private static final int SDL_SCANCODE_KP_PERIOD = 99;
    private static final int SDL_SCANCODE_LCTRL = 224, SDL_SCANCODE_LSHIFT = 225, SDL_SCANCODE_LALT = 226, SDL_SCANCODE_LGUI = 227;
    private static final int SDL_SCANCODE_RCTRL = 228, SDL_SCANCODE_RSHIFT = 229, SDL_SCANCODE_RALT = 230, SDL_SCANCODE_RGUI = 231;

    // --- SDL keycode helpers ---
    private static final int SDLK_SCANCODE_MASK = (1 << 30); // macro from SDL_keycode.h

    private static int SDL_SCANCODE_TO_KEYCODE(int sc) {
        return sc | SDLK_SCANCODE_MASK;
    }

    // Printable special keys per SDL_keycode.h
    private static final int SDLK_RETURN = '\r';
    private static final int SDLK_ESCAPE = 27;
    private static final int SDLK_BACKSPACE = '\b';
    private static final int SDLK_TAB = '\t';
    private static final int SDLK_SPACE = ' ';

    // Keyboard state by scancode (we expose it via SDL_GetKeyboardState)
    private final boolean[] sdlKeyDown = new boolean[512];

    // Mouse state
    private volatile int mouseX, mouseY, mouseRelX, mouseRelY, wheelX, wheelY;
    private volatile int mouseButtonsMask; // SDL_BUTTON_LMASK=1, M=2, R=4 (simple mask)

    // Minimal event record
    private static final class SdlEvent {
        int type;
        int timestamp;
        // keyboard
        int scancode, keycode, mod, keyState /* 1 down, 0 up */, repeat /* 0/1 */;
        // mouse
        int mx, my, mxRel, myRel, mButtons, mButton, mClicks, wX, wY;
    }

    // Simple queue
    private final java.util.ArrayDeque<SdlEvent> eventQ = new java.util.ArrayDeque<>();

    private static int nowMs() {
        return (int) (System.currentTimeMillis() & 0x7fffffff);
    }

    // Push helper
    private synchronized void pushEvent(SdlEvent e) {
        eventQ.addLast(e);
    }

    private synchronized SdlEvent pollEvent() {
        return eventQ.pollFirst();
    }

    // Returns SDL scancode for an AWT VK + key location (left/right)
    private int awtToScancode(java.awt.event.KeyEvent e) {
        int vk = e.getKeyCode();
        int loc = e.getKeyLocation();

        // Letters A..Z → 4..29
        if (vk >= java.awt.event.KeyEvent.VK_A && vk <= java.awt.event.KeyEvent.VK_Z)
            return SDL_SCANCODE_A + (vk - java.awt.event.KeyEvent.VK_A);

        // Top row digits 1..0 → 30..39
        if (vk >= java.awt.event.KeyEvent.VK_1 && vk <= java.awt.event.KeyEvent.VK_9)
            return SDL_SCANCODE_1 + (vk - java.awt.event.KeyEvent.VK_1);
        if (vk == java.awt.event.KeyEvent.VK_0)
            return SDL_SCANCODE_0;

        switch (vk) {
        // Whitespace & controls
        case java.awt.event.KeyEvent.VK_ENTER:
            return SDL_SCANCODE_RETURN;
        case java.awt.event.KeyEvent.VK_ESCAPE:
            return SDL_SCANCODE_ESCAPE;
        case java.awt.event.KeyEvent.VK_BACK_SPACE:
            return SDL_SCANCODE_BACKSPACE;
        case java.awt.event.KeyEvent.VK_TAB:
            return SDL_SCANCODE_TAB;
        case java.awt.event.KeyEvent.VK_SPACE:
            return SDL_SCANCODE_SPACE;

        // Punctuation
        case java.awt.event.KeyEvent.VK_MINUS:
            return SDL_SCANCODE_MINUS;
        case java.awt.event.KeyEvent.VK_EQUALS:
            return SDL_SCANCODE_EQUALS;
        case java.awt.event.KeyEvent.VK_OPEN_BRACKET:
            return SDL_SCANCODE_LEFTBRACKET;
        case java.awt.event.KeyEvent.VK_CLOSE_BRACKET:
            return SDL_SCANCODE_RIGHTBRACKET;
        case java.awt.event.KeyEvent.VK_BACK_SLASH:
            return SDL_SCANCODE_BACKSLASH;
        case java.awt.event.KeyEvent.VK_SEMICOLON:
            return SDL_SCANCODE_SEMICOLON;
        case java.awt.event.KeyEvent.VK_QUOTE:
            return SDL_SCANCODE_APOSTROPHE;
        case java.awt.event.KeyEvent.VK_BACK_QUOTE:
            return SDL_SCANCODE_GRAVE;
        case java.awt.event.KeyEvent.VK_COMMA:
            return SDL_SCANCODE_COMMA;
        case java.awt.event.KeyEvent.VK_PERIOD:
            return SDL_SCANCODE_PERIOD;
        case java.awt.event.KeyEvent.VK_SLASH:
            return SDL_SCANCODE_SLASH;

        // Navigation
        case java.awt.event.KeyEvent.VK_INSERT:
            return SDL_SCANCODE_INSERT;
        case java.awt.event.KeyEvent.VK_DELETE:
            return SDL_SCANCODE_DELETE;
        case java.awt.event.KeyEvent.VK_HOME:
            return SDL_SCANCODE_HOME;
        case java.awt.event.KeyEvent.VK_END:
            return SDL_SCANCODE_END;
        case java.awt.event.KeyEvent.VK_PAGE_UP:
            return SDL_SCANCODE_PAGEUP;
        case java.awt.event.KeyEvent.VK_PAGE_DOWN:
            return SDL_SCANCODE_PAGEDOWN;
        case java.awt.event.KeyEvent.VK_LEFT:
            return SDL_SCANCODE_LEFT;
        case java.awt.event.KeyEvent.VK_RIGHT:
            return SDL_SCANCODE_RIGHT;
        case java.awt.event.KeyEvent.VK_UP:
            return SDL_SCANCODE_UP;
        case java.awt.event.KeyEvent.VK_DOWN:
            return SDL_SCANCODE_DOWN;

        // Function keys
        case java.awt.event.KeyEvent.VK_F1:
            return SDL_SCANCODE_F1;
        case java.awt.event.KeyEvent.VK_F2:
            return SDL_SCANCODE_F1 + 1;
        case java.awt.event.KeyEvent.VK_F3:
            return SDL_SCANCODE_F1 + 2;
        case java.awt.event.KeyEvent.VK_F4:
            return SDL_SCANCODE_F1 + 3;
        case java.awt.event.KeyEvent.VK_F5:
            return SDL_SCANCODE_F1 + 4;
        case java.awt.event.KeyEvent.VK_F6:
            return SDL_SCANCODE_F1 + 5;
        case java.awt.event.KeyEvent.VK_F7:
            return SDL_SCANCODE_F1 + 6;
        case java.awt.event.KeyEvent.VK_F8:
            return SDL_SCANCODE_F1 + 7;
        case java.awt.event.KeyEvent.VK_F9:
            return SDL_SCANCODE_F1 + 8;
        case java.awt.event.KeyEvent.VK_F10:
            return SDL_SCANCODE_F1 + 9;
        case java.awt.event.KeyEvent.VK_F11:
            return SDL_SCANCODE_F1 + 10;
        case java.awt.event.KeyEvent.VK_F12:
            return SDL_SCANCODE_F1 + 11;

        // Numpad
        case java.awt.event.KeyEvent.VK_DIVIDE:
            return SDL_SCANCODE_KP_DIVIDE;
        case java.awt.event.KeyEvent.VK_MULTIPLY:
            return SDL_SCANCODE_KP_MULTIPLY;
        case java.awt.event.KeyEvent.VK_SUBTRACT:
            return SDL_SCANCODE_KP_MINUS;
        case java.awt.event.KeyEvent.VK_ADD:
            return SDL_SCANCODE_KP_PLUS;
        case java.awt.event.KeyEvent.VK_DECIMAL:
            return SDL_SCANCODE_KP_PERIOD;
        case java.awt.event.KeyEvent.VK_NUMPAD0:
            return SDL_SCANCODE_KP_0;
        case java.awt.event.KeyEvent.VK_NUMPAD1:
            return SDL_SCANCODE_KP_1;
        case java.awt.event.KeyEvent.VK_NUMPAD2:
            return SDL_SCANCODE_KP_2;
        case java.awt.event.KeyEvent.VK_NUMPAD3:
            return SDL_SCANCODE_KP_3;
        case java.awt.event.KeyEvent.VK_NUMPAD4:
            return SDL_SCANCODE_KP_4;
        case java.awt.event.KeyEvent.VK_NUMPAD5:
            return SDL_SCANCODE_KP_5;
        case java.awt.event.KeyEvent.VK_NUMPAD6:
            return SDL_SCANCODE_KP_6;
        case java.awt.event.KeyEvent.VK_NUMPAD7:
            return SDL_SCANCODE_KP_7;
        case java.awt.event.KeyEvent.VK_NUMPAD8:
            return SDL_SCANCODE_KP_8;
        case java.awt.event.KeyEvent.VK_NUMPAD9:
            return SDL_SCANCODE_KP_9;

        // Modifiers (respect left/right via key location)
        case java.awt.event.KeyEvent.VK_SHIFT:
            return (loc == java.awt.event.KeyEvent.KEY_LOCATION_RIGHT) ? SDL_SCANCODE_RSHIFT : SDL_SCANCODE_LSHIFT;
        case java.awt.event.KeyEvent.VK_CONTROL:
            return (loc == java.awt.event.KeyEvent.KEY_LOCATION_RIGHT) ? SDL_SCANCODE_RCTRL : SDL_SCANCODE_LCTRL;
        case java.awt.event.KeyEvent.VK_ALT:
            return (loc == java.awt.event.KeyEvent.KEY_LOCATION_RIGHT) ? SDL_SCANCODE_RALT : SDL_SCANCODE_LALT;
        case java.awt.event.KeyEvent.VK_WINDOWS: // Super/Win
            return (loc == java.awt.event.KeyEvent.KEY_LOCATION_RIGHT) ? SDL_SCANCODE_RGUI : SDL_SCANCODE_LGUI;
        }
        return 0; // unknown
    }

    // SDL keycode from AWT event + scancode
    private int awtToKeycode(java.awt.event.KeyEvent e, int sc) {
        char ch = e.getKeyChar();
        // Prefer printable ASCII when available to match SDL keycode semantics
        if (ch != java.awt.event.KeyEvent.CHAR_UNDEFINED && ch < 128)
            return (int) ch;

        // Special printable controls
        if (sc == SDL_SCANCODE_RETURN)
            return SDLK_RETURN;
        if (sc == SDL_SCANCODE_TAB)
            return SDLK_TAB;
        if (sc == SDL_SCANCODE_BACKSPACE)
            return SDLK_BACKSPACE;
        if (sc == SDL_SCANCODE_ESCAPE)
            return SDLK_ESCAPE;
        if (sc == SDL_SCANCODE_SPACE)
            return SDLK_SPACE;

        // Non-printable => SDL_SCANCODE_TO_KEYCODE(scancode)
        return SDL_SCANCODE_TO_KEYCODE(sc);
    }

    // SDL KMOD flags (very small subset)
    private static final int KMOD_LSHIFT = 0x0001, KMOD_RSHIFT = 0x0002, KMOD_LCTRL = 0x0040, KMOD_RCTRL = 0x0080, KMOD_LALT = 0x0100, KMOD_RALT = 0x0200, KMOD_LGUI = 0x0400,
            KMOD_RGUI = 0x0800;

    private int awtToSDLMod(java.awt.event.KeyEvent e) {
        int mod = 0, loc = e.getKeyLocation();
        int mods = e.getModifiersEx();
        boolean right = (loc == java.awt.event.KeyEvent.KEY_LOCATION_RIGHT);

        if ((mods & java.awt.event.InputEvent.SHIFT_DOWN_MASK) != 0)
            mod |= right ? KMOD_RSHIFT : KMOD_LSHIFT;
        if ((mods & java.awt.event.InputEvent.CTRL_DOWN_MASK) != 0)
            mod |= right ? KMOD_RCTRL : KMOD_LCTRL;
        if ((mods & java.awt.event.InputEvent.ALT_DOWN_MASK) != 0)
            mod |= right ? KMOD_RALT : KMOD_LALT;
        if ((mods & java.awt.event.InputEvent.META_DOWN_MASK) != 0)
            mod |= right ? KMOD_RGUI : KMOD_LGUI;
        return mod;
    }

    private void attachAwtListeners(int winId, javax.swing.JFrame f, ImagePanel panel) {
        // Key
        java.awt.event.KeyAdapter keyAd = new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
//                System.out.println(
//                        "AWT keyPressed: vk=" + e.getKeyCode() + " char=" + ((e.getKeyChar() == java.awt.event.KeyEvent.CHAR_UNDEFINED) ? "undef" : "'" + e.getKeyChar() + "'")
//                                + " loc=" + e.getKeyLocation() + " mods=0x" + Integer.toHexString(e.getModifiersEx()));
                int sc = awtToScancode(e);
                if (sc == 0)
                    return;
                sdlKeyDown[sc] = true;
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_KEYDOWN;
                ev.timestamp = nowMs();
                ev.scancode = sc;
                ev.keycode = awtToKeycode(e, sc);
                ev.mod = awtToSDLMod(e);
                ev.keyState = 1;
                ev.repeat = (e.getWhen() == 0 ? 0 : 0); // simple repeat=0
                pushEvent(ev);
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                int sc = awtToScancode(e);
                if (sc == 0)
                    return;
                sdlKeyDown[sc] = false;
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_KEYUP;
                ev.timestamp = nowMs();
                ev.scancode = sc;
                ev.keycode = awtToKeycode(e, sc);
                ev.mod = awtToSDLMod(e);
                ev.keyState = 0;
                ev.repeat = 0;
                pushEvent(ev);
            }
        };

        // Mouse
        java.awt.event.MouseAdapter mouseAd = new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int b = (e.getButton() == java.awt.event.MouseEvent.BUTTON1) ? 1
                        : (e.getButton() == java.awt.event.MouseEvent.BUTTON2) ? 2 : (e.getButton() == java.awt.event.MouseEvent.BUTTON3) ? 3 : 0;
                if (b != 0)
                    mouseButtonsMask |= (1 << (b - 1));
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_MOUSEBUTTONDOWN;
                ev.timestamp = nowMs();
                ev.mButton = b;
                ev.mClicks = e.getClickCount();
                ev.mx = mouseX = e.getX();
                ev.my = mouseY = e.getY();
                pushEvent(ev);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                int b = (e.getButton() == java.awt.event.MouseEvent.BUTTON1) ? 1
                        : (e.getButton() == java.awt.event.MouseEvent.BUTTON2) ? 2 : (e.getButton() == java.awt.event.MouseEvent.BUTTON3) ? 3 : 0;
                if (b != 0)
                    mouseButtonsMask &= ~(1 << (b - 1));
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_MOUSEBUTTONUP;
                ev.timestamp = nowMs();
                ev.mButton = b;
                ev.mClicks = e.getClickCount();
                ev.mx = mouseX = e.getX();
                ev.my = mouseY = e.getY();
                pushEvent(ev);
            }

            @Override
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
                wheelY += e.getWheelRotation(); // SDL uses +1/-1 steps
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_MOUSEWHEEL;
                ev.timestamp = nowMs();
                ev.wX = 0;
                ev.wY = e.getWheelRotation();
                pushEvent(ev);
            }

            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                onMove(e);
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                onMove(e);
            }

            private void onMove(java.awt.event.MouseEvent e) {
                int nx = e.getX(), ny = e.getY();
                int rx = nx - mouseX, ry = ny - mouseY;
                mouseX = nx;
                mouseY = ny;
                mouseRelX = rx;
                mouseRelY = ry;
                SdlEvent ev = new SdlEvent();
                ev.type = SDL_MOUSEMOTION;
                ev.timestamp = nowMs();
                ev.mx = nx;
                ev.my = ny;
                ev.mxRel = rx;
                ev.myRel = ry;
                ev.mButtons = mouseButtonsMask;
                pushEvent(ev);
            }
        };

        panel.addKeyListener(keyAd);
        panel.addMouseListener(mouseAd);
        panel.addMouseMotionListener(mouseAd);
        panel.addMouseWheelListener(mouseAd);
        // Make sure panel gets key focus
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);
        panel.requestFocusInWindow();
    }

    /* Maps of handles */
    private final java.util.Map<Integer, javax.swing.JFrame> sdlWindows = new java.util.HashMap<>();
    private final java.util.Map<Integer, Integer> sdlWindowW = new java.util.HashMap<>();
    private final java.util.Map<Integer, Integer> sdlWindowH = new java.util.HashMap<>();

    private final java.util.Map<Integer, Integer> sdlRendererToWindow = new java.util.HashMap<>();

    /* Texture = BufferedImage + last presented flag */
    private static final class SdlTexture {
        final int w, h;
        final int format; // SDL_PIXELFORMAT_*
        final java.awt.image.BufferedImage img;

        SdlTexture(int w, int h, int format) {
            this.w = w;
            this.h = h;
            this.format = format;
            this.img = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_RGB);
        }
    }

    private final java.util.Map<Integer, SdlTexture> sdlTextures = new java.util.HashMap<>();
    private final java.util.Map<Integer, Integer> sdlRendererLastTex = new java.util.HashMap<>();

    private int nextSdlId = 1;

    /* Utility: simple panel that paints a BufferedImage scaled to window size */
    private static final class ImagePanel extends javax.swing.JPanel {
        volatile java.awt.image.BufferedImage img;

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            if (img != null) {
//                g.setColor(java.awt.Color.RED);
//                g.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }

    /* Each window owns an ImagePanel */
    private final java.util.Map<Integer, ImagePanel> sdlWindowPanels = new java.util.HashMap<>();

    /* ---- API exposed to C ---- */

    public int mir_sdl_create_window(long titlePtr, int w, int h, long flags) {
        try {
            String title = (titlePtr != 0) ? getStringFromMemory(titlePtr) : "SDL";
            //System.out.println("mir_sdl_create_window title='" + title + "' w=" + w + " h=" + h + " flags=0x" + Long.toHexString(flags));

            int id = nextSdlId++;

            javax.swing.JFrame f = new javax.swing.JFrame(title);
            ImagePanel panel = new ImagePanel();
            attachAwtListeners(id, f, panel);
            f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            f.add(panel);
            f.setSize(Math.max(320, w), Math.max(240, h)); // simple size
            f.setLocationByPlatform(true);
            f.setVisible(true);

            sdlWindows.put(id, f);
            sdlWindowPanels.put(id, panel);
            sdlWindowW.put(id, w);
            sdlWindowH.put(id, h);
            return id;
        } catch (Throwable t) {
            return -5; // -EIO
        }
    }

    public int mir_sdl_destroy_window(int winId) {
        javax.swing.JFrame f = sdlWindows.remove(winId);
        sdlWindowPanels.remove(winId);
        sdlWindowW.remove(winId);
        sdlWindowH.remove(winId);
        if (f != null) {
            f.dispose();
            return 0;
        }
        return -2; // -ENOENT
    }

    public int mir_sdl_create_renderer(int winId, long flags) {
        if (!sdlWindows.containsKey(winId))
            return -2;
        int id = nextSdlId++;
        sdlRendererToWindow.put(id, winId);
        return id;
    }

    public int mir_sdl_destroy_renderer(int rendId) {
        sdlRendererToWindow.remove(rendId);
        sdlRendererLastTex.remove(rendId);
        return 0;
    }

    public int mir_sdl_create_texture(int rendId, long format, int access, int w, int h) {
        // System.out.println("mir_sdl_create_texture rendId=" + rendId + " format=0x" + Long.toHexString(format) + " access=" + access + " w=" + w + " h=" + h);
        if (!sdlRendererToWindow.containsKey(rendId))
            return -2;
        int id = nextSdlId++;
        sdlTextures.put(id, new SdlTexture(w, h, (int) format));
        return id;
    }

    public int mir_sdl_destroy_texture(int texId) {
        sdlTextures.remove(texId);
        return 0;
    }

    /* Convert BGR565 -> RGB and copy from VM memory at bufferAddr into BufferedImage */
    public int mir_sdl_update_texture(int texId, long bufferAddr, int pitch, int w, int h, long format) {
//        System.out.println("mir_sdl_update_texture texId=" + texId + " bufferAddr=0x" + Long.toHexString(bufferAddr) + " pitch=" + pitch + " w=" + w + " h=" + h + " format=0x"
//                + Long.toHexString(format));
        SdlTexture t = sdlTextures.get(texId);
        if (t == null)
            return -2;
        if (t.w != w || t.h != h)
            return -22; // -EINVAL
        // final boolean isBGR565 = (format == 0x00000000 /* replace with SDL_PIXELFORMAT_BGR565 value */) || true;
        try {
            int[] rgb = new int[w];

            for (int y = 0; y < h; y++) {
                long rowAddr = bufferAddr + (long) y * (long) pitch;

                for (int x = 0; x < w; x++) {
                    // Read one 16-bit pixel (little-endian) from VM memory
                    int v = mir_read_ushort(rowAddr + (long) (x * 2));
//                    if (v != 0)
//                        System.out.println("v=0x" + Integer.toHexString(v));

                    int r5 = v & 0x1F; // low 5 bits
                    int g6 = (v >> 5) & 0x3F; // mid 6 bits
                    int b5 = (v >> 11) & 0x1F; // high 5 bits

                    // Expand to 8-bit channels (replicate high bits)
                    int R = (r5 << 3) | (r5 >> 2);
                    int G = (g6 << 2) | (g6 >> 4);
                    int B = (b5 << 3) | (b5 >> 2);

                    rgb[x] = (R << 16) | (G << 8) | B; // TYPE_INT_RGB expects 0x00RRGGBB
//                    if (rgb[x] != 0)
//                       System.out.printf("(%d,%d) v=0x%04X -> R=%d G=%d B=%d rgb=0x%06X\n", x, y, v, R, G, B, rgb[x]);
                }

                t.img.setRGB(0, y, w, 1, rgb, 0, w);
            }
            return 0;
        } catch (Throwable e) {
            return -5;
        }
    }

    public int mir_sdl_render_copy(int rendId, int texId) {
        // System.out.println("mir_sdl_render_copy rendId=" + rendId + " texId=" + texId);
        if (!sdlRendererToWindow.containsKey(rendId) || !sdlTextures.containsKey(texId))
            return -2;
        sdlRendererLastTex.put(rendId, texId);
        return 0;
    }

    public int mir_sdl_render_present(int rendId) {
        // System.out.println("mir_sdl_render_present rendId=" + rendId);
        Integer winId = sdlRendererToWindow.get(rendId);
        Integer texId = sdlRendererLastTex.get(rendId);
        if (winId == null || texId == null)
            return 0;
        javax.swing.JFrame f = sdlWindows.get(winId);
        ImagePanel panel = sdlWindowPanels.get(winId);
        SdlTexture t = sdlTextures.get(texId);
        if (f == null || panel == null || t == null)
            return 0;
        panel.img = t.img;
        panel.repaint();
        return 0;
    }

    // Write keyboard state as 0/1 bytes for scancodes 0..(n-1)
    public int mir_sdl_get_keyboard_state(long destAddr, int maxLen) {
        int n = Math.min(maxLen, 512);
        for (int i = 0; i < n; i++)
            mir_write_ubyte(destAddr + i, sdlKeyDown[i] ? 1 : 0);
        return n;
    }

    /*
     * Memory layout we write at eventAddr :
     *  offset 0 : u32 type
     *  Keyboard:
     *    +4 : s32 scancode
     *    +8 : s32 keycode
     *   +12 : s32 mod
     *   +16 : u8  state (1=down,0=up)
     *   +17 : u8  repeat
     *  Mouse motion:
     *    +4 : s32 x, +8 : s32 y, +12 : s32 xrel, +16 : s32 yrel, +20 : u32 buttons mask
     *  Mouse button:
     *    +4 : u8  button(1=L,2=M,3=R), +5 : u8 state, +6 : u8 clicks, +8 : s32 x, +12 : s32 y
     *  Mouse wheel:
     *    +4 : s32 wheelX, +8 : s32 wheelY
     */
    public int mir_sdl_poll_event(long eventAddr) {
        // System.out.println("mir_sdl_poll_event eventAddr=0x" + Long.toHexString(eventAddr));
        SdlEvent e = pollEvent();
        if (e == null)
            return 0;

        mir_write_uint(eventAddr + 0, e.type);

        switch (e.type) {
        case SDL_KEYDOWN:
        case SDL_KEYUP:
//            System.out.println("SDL event: type=" + (e.type == SDL_KEYDOWN ? "KEYDOWN" : "KEYUP") + " scancode=" + e.scancode + " keycode=" + e.keycode + " mod=0x"
//                    + Integer.toHexString(e.mod) + " state=" + e.keyState + " repeat=" + e.repeat);
            mir_write_int(eventAddr + 4, e.scancode);
            mir_write_int(eventAddr + 8, e.keycode);
            mir_write_int(eventAddr + 12, e.mod);
            mir_write_ubyte(eventAddr + 16, e.keyState);
            mir_write_ubyte(eventAddr + 17, e.repeat);
            break;

        case SDL_MOUSEMOTION:
            mir_write_int(eventAddr + 4, e.mx);
            mir_write_int(eventAddr + 8, e.my);
            mir_write_int(eventAddr + 12, e.mxRel);
            mir_write_int(eventAddr + 16, e.myRel);
            mir_write_uint(eventAddr + 20, e.mButtons);
            break;

        case SDL_MOUSEBUTTONDOWN:
        case SDL_MOUSEBUTTONUP:
            mir_write_ubyte(eventAddr + 4, e.mButton);
            mir_write_ubyte(eventAddr + 5, e.type == SDL_MOUSEBUTTONDOWN ? 1 : 0);
            mir_write_ubyte(eventAddr + 6, e.mClicks);
            mir_write_int(eventAddr + 8, e.mx);
            mir_write_int(eventAddr + 12, e.my);
            break;

        case SDL_MOUSEWHEEL:
            mir_write_int(eventAddr + 4, e.wX);
            mir_write_int(eventAddr + 8, e.wY);
            break;

        case SDL_QUIT:
        default:
            // Nothing to do
            break;
        }
        return 1;
    }

}
