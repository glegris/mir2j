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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingBackend implements Backend {

    private JFrame frame;
    private JPanel panel;
    private BufferedImage surface;
    private Graphics2D g;
    private final GradientCache gradCache = new GradientCache();

    private InputSink sink;

    // Use monospaced font by default
    private final Font baseMono = new Font(Font.MONOSPACED, Font.PLAIN, 10);
    private float lastFontSize = -1f;
    private Font sizedFont = baseMono;

    @Override
    public void initWindow(final int width, final int height, String title, InputSink sink) {
        this.sink = sink;

        surface = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = surface.createGraphics();
        g.setFont(baseMono);
        // g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics gg) {
                super.paintComponent(gg);
                gg.drawImage(surface, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };

        // AWT listeners -> callbacks InputSink
        AWTBridge bridge = new AWTBridge();
        panel.addKeyListener(bridge);
        panel.addMouseListener(bridge);
        panel.addMouseMotionListener(bridge);
        panel.addComponentListener(bridge);
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    @Override
    public void beginFrame() {
        // Force upstream AWT processing if necessary
        try {
            /* flush EDT */
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                }
            });
        } catch (Exception ignored) {
        }
    }

    @Override
    public void endFrame() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    if (panel != null)
                        panel.paintImmediately(0, 0, surface.getWidth(), surface.getHeight());
                }
            });
        } catch (Exception ignored) {
        }
    }

    @Override
    public int getScreenWidth() {
        return surface.getWidth();
    }

    @Override
    public int getScreenHeight() {
        return surface.getHeight();
    }

    @Override
    public void clearBackground(int rgba) {
        g.setColor(argb(rgba));
        g.fillRect(0, 0, surface.getWidth(), surface.getHeight());
    }

    @Override
    public void drawRectangle(int x, int y, int w, int h, int rgba) {
        g.setColor(argb(rgba));
        g.fillRect(x, y, w, h);
    }

    private static final class GradientCache {
        int x, y, w, h;
        int tl, tr, bl, br;
        int[] blockARGB; // w*h, row-major, ARGB

        boolean matches(int x, int y, int w, int h, int tl, int tr, int bl, int br) {
            return this.blockARGB != null && this.x == x && this.y == y && this.w == w && this.h == h && this.tl == tl && this.tr == tr && this.bl == bl && this.br == br;
        }

        void rebuild(int x, int y, int w, int h, int tl, int tr, int bl, int br) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.tl = tl;
            this.tr = tr;
            this.bl = bl;
            this.br = br;
            this.blockARGB = GradientHelper.makeBilinearBlockARGB(w, h, tl, tr, bl, br);
        }
    }

    @Override
    public void drawRectangleGradientEx(int x, int y, int w, int h, int colTL, int colTR, int colBL, int colBR) {
        if (w <= 0 || h <= 0)
            return;

        // Regenerate cache if needed
        if (!gradCache.matches(x, y, w, h, colTL, colTR, colBL, colBR)) {
            gradCache.rebuild(x, y, w, h, colTL, colTR, colBL, colBR);
        }

        int sw = surface.getWidth();
        int[] pixels = ((java.awt.image.DataBufferInt) surface.getRaster().getDataBuffer()).getData();
        int[] src = gradCache.blockARGB;

        int maxW = Math.min(w, sw - x);
        int sh = surface.getHeight();
        int maxH = Math.min(h, sh - y);
        if (maxW <= 0 || maxH <= 0)
            return;

        // Blend line by line
        for (int j = 0; j < maxH; j++) {
            int srcBase = j * w;
            int dstBase = (y + j) * sw + x;

            for (int i = 0; i < maxW; i++) {
                int s = src[srcBase + i];
                int sa = (s >>> 24) & 0xFF;
                if (sa == 255) {
                    // Opaque : copy RGB
                    pixels[dstBase + i] = s & 0x00FFFFFF;
                } else if (sa != 0) {
                    // semi-transparent : alpha blend
                    pixels[dstBase + i] = GradientHelper.srcOverRGB(pixels[dstBase + i], s);
                }
                // else (alpha 0) : do nothing (keep dst)
            }
        }
    }

//    @Override
//    public void drawRectangleGradientEx(int x, int y, int w, int h,
//                                        int colTL, int colTR, int colBL, int colBR) {
//        Color cTL = argb(colTL);
//        Color cTR = argb(colTR);
//        Color cBL = argb(colBL);
//        Color cBR = argb(colBR);
//
//        Graphics2D g2 = (Graphics2D) g.create();
//        for (int j = 0; j < h; j++) {
//            float fy = (h <= 1) ? 0f : (j / (float) (h - 1));
//            // vertical : gauche = TL->BL, droite = TR->BR
//            Color left  = lerpColor(cTL, cBL, fy);
//            Color right = lerpColor(cTR, cBR, fy);
//
//            g2.setPaint(new GradientPaint(x, y + j, left, x + w, y + j, right));
//            g2.fillRect(x, y + j, w, 1);
//        }
//        g2.dispose();
//    }

    @Override
    public void drawTextCodepoint(float x, float y, int codepoint, float fontSize, int rgbaTint, long fontHandle) {
        if (fontSize <= 0)
            fontSize = 10f;
        if (fontSize != lastFontSize) {
            sizedFont = baseMono.deriveFont(fontSize);
            lastFontSize = fontSize;
        }
        g.setFont(sizedFont);
        FontMetrics fm = g.getFontMetrics(sizedFont);

        // Teinte (respect alpha de RGBA)
        g.setColor(argb(rgbaTint));

        int bx = Math.round(x);
        // centered nudge (stabilizes the visual rendering)
        int nudge = Math.round((fm.getDescent() + fm.getLeading()) * 0.5f);
        int by = Math.round(y + fm.getAscent() - nudge);

        char[] chars = Character.toChars(codepoint);
        g.drawChars(chars, 0, chars.length, bx, by);
    }

    @Override
    public int getMaxCharWidth() {
        return panel.getFontMetrics(baseMono).charWidth('M');
    }

    @Override
    public int getMaxCharHeight() {
        return panel.getFontMetrics(baseMono).getHeight();
    }

    private static Color argb(int rgba) {
        // rgba: 0xRRGGBBAA -> AWT: 0xAARRGGBB
        int r = (rgba >>> 24) & 0xFF;
        int g = (rgba >>> 16) & 0xFF;
        int b = (rgba >>> 8) & 0xFF;
        int a = (rgba) & 0xFF;
        return new Color(r, g, b, a);
    }

    private static Color lerpColor(Color a, Color b, float t) {
        t = Math.max(0f, Math.min(1f, t));
        int r = (int) (a.getRed() + (b.getRed() - a.getRed()) * t);
        int g = (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t);
        int bch = (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t);
        int al = (int) (a.getAlpha() + (b.getAlpha() - a.getAlpha()) * t);
        return new Color(r, g, bch, al);
    }

    // === Pont AWT -> InputSink ===
    private final class AWTBridge extends ComponentAdapter implements KeyListener, MouseListener, MouseMotionListener {

        @Override
        public void keyPressed(KeyEvent e) {
            sink.onKeyDown(mapKey(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            sink.onKeyUp(mapKey(e.getKeyCode()));
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c >= 0x20 || c == '\n' || c == '\t')
                sink.onCharTyped(c);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.requestFocusInWindow();
            sink.onMouseDown(mapButton(e.getButton()), e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            sink.onMouseUp(mapButton(e.getButton()), e.getX(), e.getY());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            sink.onMouseMove(e.getX(), e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            sink.onMouseMove(e.getX(), e.getY());
        }

        @Override
        public void componentResized(ComponentEvent e) {
            int w = panel.getWidth(), h = panel.getHeight();
            surface = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            g = surface.createGraphics();
            g.setFont(sizedFont);
            // g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            sink.onResize(w, h);
        }

        // Mapping AWT -> Raylib codes
        private int mapKey(int kc) {
            switch (kc) {
            case KeyEvent.VK_ENTER:
                return Raygui.KEY_ENTER;
            case KeyEvent.VK_BACK_SPACE:
                return Raygui.KEY_BACKSPACE;
            case KeyEvent.VK_TAB:
                return Raygui.KEY_TAB;
            case KeyEvent.VK_SHIFT:
                return Raygui.KEY_LEFT_SHIFT;
            case KeyEvent.VK_CONTROL:
                return Raygui.KEY_LEFT_CONTROL;
            case KeyEvent.VK_ALT:
                return Raygui.KEY_LEFT_ALT;
            case KeyEvent.VK_ESCAPE:
                return Raygui.KEY_ESCAPE;
            case KeyEvent.VK_SPACE:
                return Raygui.KEY_SPACE;
            case KeyEvent.VK_PAGE_UP:
                return Raygui.KEY_PAGE_UP;
            case KeyEvent.VK_PAGE_DOWN:
                return Raygui.KEY_PAGE_DOWN;
            case KeyEvent.VK_END:
                return Raygui.KEY_END;
            case KeyEvent.VK_HOME:
                return Raygui.KEY_HOME;
            case KeyEvent.VK_LEFT:
                return Raygui.KEY_LEFT;
            case KeyEvent.VK_UP:
                return Raygui.KEY_UP;
            case KeyEvent.VK_RIGHT:
                return Raygui.KEY_RIGHT;
            case KeyEvent.VK_DOWN:
                return Raygui.KEY_DOWN;
            case KeyEvent.VK_COMMA:
                return Raygui.KEY_COMMA;
            case KeyEvent.VK_MINUS:
                return Raygui.KEY_MINUS;
            case KeyEvent.VK_PERIOD:
                return Raygui.KEY_PERIOD;
            case KeyEvent.VK_SLASH:
                return Raygui.KEY_SLASH;
            case KeyEvent.VK_SEMICOLON:
                return Raygui.KEY_SEMICOLON;
            case KeyEvent.VK_EQUALS:
                return Raygui.KEY_EQUAL;
            case KeyEvent.VK_OPEN_BRACKET:
                return Raygui.KEY_LEFT_BRACKET;
            case KeyEvent.VK_BACK_SLASH:
                return Raygui.KEY_BACKSLASH;
            case KeyEvent.VK_CLOSE_BRACKET:
                return Raygui.KEY_RIGHT_BRACKET;
            case KeyEvent.VK_BACK_QUOTE:
                return Raygui.KEY_GRAVE;
            default:
                if ((kc >= '0' && kc <= '9') || (kc >= 'A' && kc <= 'Z'))
                    return kc;
                return Raygui.KEY_NULL;
            }
        }

        private int mapButton(int awt) {
            switch (awt) {
            case MouseEvent.BUTTON1:
                return 0; // LEFT
            case MouseEvent.BUTTON3:
                return 1; // RIGHT
            case MouseEvent.BUTTON2:
                return 2; // MIDDLE
            default:
                return Math.min(7, awt); // side/extra
            }
        }

        // Unused
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
