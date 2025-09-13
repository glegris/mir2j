package raygui4j;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Raygui extends RayguiBase {

	public static final int KEY_NULL = 0; // Key: NULL; used for no key pressed
	// Alphanumeric keys
	public static final int KEY_APOSTROPHE = 39; // Key: '
	public static final int KEY_COMMA = 44; // Key: ,
	public static final int KEY_MINUS = 45; // Key: -
	public static final int KEY_PERIOD = 46; // Key: .
	public static final int KEY_SLASH = 47; // Key: /
	public static final int KEY_ZERO = 48; // Key: 0
	public static final int KEY_ONE = 49; // Key: 1
	public static final int KEY_TWO = 50; // Key: 2
	public static final int KEY_THREE = 51; // Key: 3
	public static final int KEY_FOUR = 52; // Key: 4
	public static final int KEY_FIVE = 53; // Key: 5
	public static final int KEY_SIX = 54; // Key: 6
	public static final int KEY_SEVEN = 55; // Key: 7
	public static final int KEY_EIGHT = 56; // Key: 8
	public static final int KEY_NINE = 57; // Key: 9
	public static final int KEY_SEMICOLON = 59; // Key: ;
	public static final int KEY_EQUAL = 61; // Key: =
	public static final int KEY_A = 65; // Key: A | a
	public static final int KEY_B = 66; // Key: B | b
	public static final int KEY_C = 67; // Key: C | c
	public static final int KEY_D = 68; // Key: D | d
	public static final int KEY_E = 69; // Key: E | e
	public static final int KEY_F = 70; // Key: F | f
	public static final int KEY_G = 71; // Key: G | g
	public static final int KEY_H = 72; // Key: H | h
	public static final int KEY_I = 73; // Key: I | i
	public static final int KEY_J = 74; // Key: J | j
	public static final int KEY_K = 75; // Key: K | k
	public static final int KEY_L = 76; // Key: L | l
	public static final int KEY_M = 77; // Key: M | m
	public static final int KEY_N = 78; // Key: N | n
	public static final int KEY_O = 79; // Key: O | o
	public static final int KEY_P = 80; // Key: P | p
	public static final int KEY_Q = 81; // Key: Q | q
	public static final int KEY_R = 82; // Key: R | r
	public static final int KEY_S = 83; // Key: S | s
	public static final int KEY_T = 84; // Key: T | t
	public static final int KEY_U = 85; // Key: U | u
	public static final int KEY_V = 86; // Key: V | v
	public static final int KEY_W = 87; // Key: W | w
	public static final int KEY_X = 88; // Key: X | x
	public static final int KEY_Y = 89; // Key: Y | y
	public static final int KEY_Z = 90; // Key: Z | z
	public static final int KEY_LEFT_BRACKET = 91; // Key: [
	public static final int KEY_BACKSLASH = 92; // Key: '\'
	public static final int KEY_RIGHT_BRACKET = 93; // Key: ]
	public static final int KEY_GRAVE = 96; // Key: `
	// Function keys
	public static final int KEY_SPACE = 32; // Key: Space
	public static final int KEY_ESCAPE = 256; // Key: Esc
	public static final int KEY_ENTER = 257; // Key: Enter
	public static final int KEY_TAB = 258; // Key: Tab
	public static final int KEY_BACKSPACE = 259; // Key: Backspace
	public static final int KEY_INSERT = 260; // Key: Ins
	public static final int KEY_DELETE = 261; // Key: Del
	public static final int KEY_RIGHT = 262; // Key: Cursor right
	public static final int KEY_LEFT = 263; // Key: Cursor left
	public static final int KEY_DOWN = 264; // Key: Cursor down
	public static final int KEY_UP = 265; // Key: Cursor up
	public static final int KEY_PAGE_UP = 266; // Key: Page up
	public static final int KEY_PAGE_DOWN = 267; // Key: Page down
	public static final int KEY_HOME = 268; // Key: Home
	public static final int KEY_END = 269; // Key: End
	public static final int KEY_CAPS_LOCK = 280; // Key: Caps lock
	public static final int KEY_SCROLL_LOCK = 281; // Key: Scroll down
	public static final int KEY_NUM_LOCK = 282; // Key: Num lock
	public static final int KEY_PRINT_SCREEN = 283; // Key: Print screen
	public static final int KEY_PAUSE = 284; // Key: Pause
	public static final int KEY_F1 = 290; // Key: F1
	public static final int KEY_F2 = 291; // Key: F2
	public static final int KEY_F3 = 292; // Key: F3
	public static final int KEY_F4 = 293; // Key: F4
	public static final int KEY_F5 = 294; // Key: F5
	public static final int KEY_F6 = 295; // Key: F6
	public static final int KEY_F7 = 296; // Key: F7
	public static final int KEY_F8 = 297; // Key: F8
	public static final int KEY_F9 = 298; // Key: F9
	public static final int KEY_F10 = 299; // Key: F10
	public static final int KEY_F11 = 300; // Key: F11
	public static final int KEY_F12 = 301; // Key: F12
	public static final int KEY_LEFT_SHIFT = 340; // Key: Shift left
	public static final int KEY_LEFT_CONTROL = 341; // Key: Control left
	public static final int KEY_LEFT_ALT = 342; // Key: Alt left
	public static final int KEY_LEFT_SUPER = 343; // Key: Super left
	public static final int KEY_RIGHT_SHIFT = 344; // Key: Shift right
	public static final int KEY_RIGHT_CONTROL = 345; // Key: Control right
	public static final int KEY_RIGHT_ALT = 346; // Key: Alt right
	public static final int KEY_RIGHT_SUPER = 347; // Key: Super right
	public static final int KEY_KB_MENU = 348; // Key: KB menu
	// Keypad keys
	public static final int KEY_KP_0 = 320; // Key: Keypad 0
	public static final int KEY_KP_1 = 321; // Key: Keypad 1
	public static final int KEY_KP_2 = 322; // Key: Keypad 2
	public static final int KEY_KP_3 = 323; // Key: Keypad 3
	public static final int KEY_KP_4 = 324; // Key: Keypad 4
	public static final int KEY_KP_5 = 325; // Key: Keypad 5
	public static final int KEY_KP_6 = 326; // Key: Keypad 6
	public static final int KEY_KP_7 = 327; // Key: Keypad 7
	public static final int KEY_KP_8 = 328; // Key: Keypad 8
	public static final int KEY_KP_9 = 329; // Key: Keypad 9
	public static final int KEY_KP_DECIMAL = 330; // Key: Keypad .
	public static final int KEY_KP_DIVIDE = 331; // Key: Keypad /
	public static final int KEY_KP_MULTIPLY = 332; // Key: Keypad *
	public static final int KEY_KP_SUBTRACT = 333; // Key: Keypad -
	public static final int KEY_KP_ADD = 334; // Key: Keypad +
	public static final int KEY_KP_ENTER = 335; // Key: Keypad Enter
	public static final int KEY_KP_EQUAL = 336; // Key: Keypad =
	// Android key buttons
	public static final int KEY_BACK = 4; // Key: Android back button
	public static final int KEY_MENU = 82; // Key: Android menu button
	public static final int KEY_VOLUME_UP = 24; // Key: Android volume up button
	public static final int KEY_VOLUME_DOWN = 25; // Key: Android volume down button

	private static final boolean LOG_ENABLED = true;
		
	// Key state
	private static final int KEY_CAP = 512;  // give us some headroom
	// Edge accumulators between frames (protected by a lock)
	private final Object keyLock = new Object();
	private final int[]  keyPressAcc    = new int[KEY_CAP];
	private final int[]  keyReleaseAcc  = new int[KEY_CAP];
	private final boolean[] keyDownState = new boolean[KEY_CAP]; // current state (EDT)
	private final boolean[] keyDownFrame = new boolean[KEY_CAP]; // snapshot for the frame
	private final boolean[] keyPressEdgeFrame   = new boolean[KEY_CAP]; // visible 1 frame
	private final boolean[] keyReleaseEdgeFrame = new boolean[KEY_CAP]; // visible 1 frame

	// Mouse state (raylib indices: 0=LEFT,1=RIGHT,2=MIDDLE,3=SIDE,4=EXTRA)
	private static final int MOUSE_BUTTONS = 8;
	// Edge accumulators between frames (protected by a lock)
	private final Object mouseLock = new Object();
	private final int[]  mousePressAcc   = new int[MOUSE_BUTTONS];
	private final int[]  mouseReleaseAcc = new int[MOUSE_BUTTONS];
	// Current state (EDT side) and snapshot readable by the frame
	private final boolean[] mouseDownState  = new boolean[MOUSE_BUTTONS];
	private final boolean[] mouseDownFrame  = new boolean[MOUSE_BUTTONS]; // snapshot for the frame
	// Edges visible ONLY during the current frame
	private static final int EDGE_NONE = -1;
	private final boolean[] mousePressEdgeFrame   = new boolean[MOUSE_BUTTONS];
	private final boolean[] mouseReleaseEdgeFrame = new boolean[MOUSE_BUTTONS];

	private volatile int mouseX, mouseY;
	private final Vector<Character> charQueue = new Vector<>();

	BufferedImage offscreenSurface;
	
	private Font defaultBaseFont = new Font(Font.MONOSPACED, Font.PLAIN, 10); // Only support monospaced fonts for now
    private float lastFontSize;
    private Font sizedFont;
    
	private JFrame frame;
	private JPanel panel;
	private Graphics graphics;


	//AWTEventConverter converter;

	@Override
	public void InitWindow(int screenWidth, int screenHeight, long screenNameAddr) {
	    initEdges();
		//super.InitWindow(screenWidth, screenHeight, screenNameAddr);
		offscreenSurface = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
		graphics = offscreenSurface.createGraphics();
		//graphics.setFont(defaultFont);
		AWTEventConverter converter = new AWTEventConverter();
		panel = createPanel(converter);
		panel.addComponentListener(converter);
		String screenName = getStringFromMemory(screenNameAddr);
		frame = new JFrame(screenName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.addWindowListener(converter);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		panel.requestFocus();
	}
	
	private void initEdges() {
	    Arrays.fill(keyPressAcc, EDGE_NONE);
	    Arrays.fill(keyReleaseAcc, EDGE_NONE);
	    Arrays.fill(keyDownState, false);
	    Arrays.fill(mousePressAcc, EDGE_NONE);
	    Arrays.fill(mouseReleaseAcc, EDGE_NONE);
	    Arrays.fill(mouseDownState, false);
	}

	@Override
	public int GetScreenWidth() {
		return offscreenSurface.getWidth();
	}

	@Override
	public int GetScreenHeight() {
		//return super.GetScreenHeight();
		return offscreenSurface.getHeight();
	}

	private int convertRGBAToARGB(int rgba) {
	    // rgba is expected as 0xRRGGBBAA (as produced by ColorToInt in raylib)
	    int r = (rgba >>> 24) & 0xFF;
	    int g = (rgba >>> 16) & 0xFF;
	    int b = (rgba >>>  8) & 0xFF;
	    int a = (rgba       ) & 0xFF;
	    return (a << 24) | (r << 16) | (g << 8) | b;
	}

	private void drawRectangle(int x, int y, int width, int height, int rgba) {
		int argb = convertRGBAToARGB(rgba);
		graphics.setColor(new java.awt.Color(argb));
		graphics.fillRect(x, y, width, height);
	}

	@Override
	public void ClearBackground(long colorAddr) {
		//super.ClearBackground(colorAddr);
		int rgba = ColorToInt(colorAddr);
		int argb = convertRGBAToARGB(rgba);
		graphics.setColor(new java.awt.Color(argb));
		graphics.fillRect(0, 0, offscreenSurface.getWidth(), offscreenSurface.getHeight());
	}

	@Override
	public void DrawRectangle(int x, int y, int width, int height, long colorAddr) {
		//super.DrawRectangle(x, y, width, height, colorAddr);
		int rgba = ColorToInt(colorAddr);
		drawRectangle(x, y, width, height, rgba);
	}

	@Override
	public void DrawRectangleGradientEx(long rectangleAddr, long color1Addr, long color2Addr, long color3Addr, long color4Addr) {
		// TODO Auto-generated method stub
		//super.DrawRectangleGradientEx(_I0_rec, _I0_col1, _I0_col2, _I0_col3, _I0_col4);
		// TODO: See AWT LinearGradientPaint
		int rgba1 = ColorToInt(color1Addr);
		int rgba2 = ColorToInt(color2Addr);
		int rgba3 = ColorToInt(color3Addr);
		int rgba4 = ColorToInt(color4Addr);
		Color color1 = new Color(rgba1);
		//System.out.println(color1);
		Color color2 = new Color(rgba2);
		Color color3 = new Color(rgba3);
		Color color4 = new Color(rgba4);
		int x = (int) mir_read_float(rectangleAddr);
		int y = (int) mir_read_float(rectangleAddr + 4);
		int w = (int) mir_read_float(rectangleAddr + 8);
		int h = (int) mir_read_float(rectangleAddr + 12);

        // Works but slow (TODO: add a cache) 
//		Color pointColor = new Color();
//		for (int j = 0; j < h; j++) {
//			float fractionY =  ((float) j) / h;
//			for (int i = 0; i < w; i++) {
//				float fractionX = ((float) i) / w;
//				bilinearInterpolateColor(pointColor, color1, color4, color2, color3, fractionX, fractionY);
//				java.awt.Color c = new java.awt.Color(pointColor.red, pointColor.green, pointColor.blue, pointColor.alpha);
//				graphics.setColor(c);
//				graphics.drawLine(x + i, y + j, x + i, y + j);
//			}
//		}

		final java.awt.Graphics2D g2D = (Graphics2D) graphics.create();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color pointColor1 = new Color();
		Color pointColor2 = new Color();
		for (int j = 0; j < h; j++) {
			float fractionY = ((float) j) / h;
			bilinearInterpolateColor(pointColor1, color1, color4, color2, color3, 0, fractionY);
			bilinearInterpolateColor(pointColor2, color1, color4, color2, color3, 1.0f, fractionY);
			java.awt.Color c1 = new java.awt.Color(pointColor1.red, pointColor1.green, pointColor1.blue, pointColor1.alpha);
			java.awt.Color c2 = new java.awt.Color(pointColor2.red, pointColor2.green, pointColor2.blue, pointColor2.alpha);
			GradientPaint paint = new GradientPaint(x, y + j, c1, x + w, y + j, c2);
			g2D.setPaint(paint);
			Rectangle rect = new Rectangle(x, y + j, w, 1);
			g2D.fill(rect);
		}
		g2D.dispose();

		// Doesn't work as expected
//		final java.awt.Graphics2D g2D = (Graphics2D) graphics.create();
//		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		java.awt.Color c1 = new java.awt.Color(color1.red, color1.green, color1.blue, color1.alpha);
//		java.awt.Color c2 = new java.awt.Color(color2.red, color2.green, color2.blue, color2.alpha);
//		java.awt.Color c3 = new java.awt.Color(color3.red, color3.green, color3.blue, color3.alpha);
//		java.awt.Color c4 = new java.awt.Color(color4.red, color4.green, color4.blue, color4.alpha);
//		Rectangle rect = new Rectangle(x, y, w, h);
//		BiLinearGradientPaint BILINEAR_GRADIENT = new BiLinearGradientPaint(rect, c1, c4, c2, c3);
//		g2D.setPaint(BILINEAR_GRADIENT);
//		g2D.fill(rect);
//		g2D.dispose();

//		System.out.println("[DEBUG] DrawRectangleGradientEx(): x=" + x + " y=" + y + " w=" + w + " h=" + h + " c1=" + Integer.toHexString(rgba1) + " c2=" + Integer.toHexString(rgba2) + " c3="
//				+ Integer.toHexString(rgba3) + " c4=" + Integer.toHexString(rgba4));
//		if (rgba1 != 0) {
//			drawRectangle((int) x, (int) y, (int) w, (int) h, rgba1);
//		}
	}

	@Override
	public void DrawTextCodepoint(long _I0_font, int codepoint, long positionAddr, float fontSize, long tint) {
		//super.DrawTextCodepoint(_I0_font, codepoint, positionAddr, f0_fontSize, _I0_tint);
		float x = mir_read_float(positionAddr);
		float y = mir_read_float(positionAddr + 4);
		//FontMetrics fontMetrics = graphics.getFontMetrics(defaultFont);
		//int fontHeight = fontMetrics.getHeight();
		
		// Respect the size requested by raygui
		//System.out.println("DrawTextCodepoint(): codepoint=" + codepoint + " ('" + new String(Character.toChars(codepoint)) + "') x=" + x + " y=" + y + " fontSize=" + fontSize);
	    Font font = defaultBaseFont.deriveFont(fontSize);
	    graphics.setFont(font);
	    
	    if (fontSize <= 0) fontSize = 10; // secours
	    if (fontSize != lastFontSize) {
	        sizedFont = defaultBaseFont.deriveFont(fontSize);
	        lastFontSize = fontSize;
	    }
	    graphics.setFont(sizedFont);
	    
	    FontMetrics fontMetrics = graphics.getFontMetrics(sizedFont);
	    
	    int rgba = ColorToInt(tint);
	    int argb = convertRGBAToARGB(rgba);            
	    graphics.setColor(new java.awt.Color(argb, true)); // Respect alpha
	    
	    int bx = (int) x;
	    //int nudge = Math.round(fontMetrics.getHeight() * 0.25f);
	    int nudge = Math.round((fontMetrics.getDescent() + fontMetrics.getLeading()) * 0.5f);
	    int by = (int) (y + fontMetrics.getAscent() - nudge);
		
		//System.out.println("f0_fontSize=" + f0_fontSize + " fontHeight=" + fontHeight);
		
	    // Support codepoints > BMP
	    char[] chars = Character.toChars(codepoint);
	    graphics.drawChars(chars, 0, chars.length, bx, by);
	    //graphics.drawString(String.valueOf((char) codepoint), bx, by);
		
		
		
	}

	@Override
	public void BeginDrawing() {
	    // Snapshot of edges + down state for the frame
	    synchronized (keyLock) {
	        for (int k = 0; k < KEY_CAP; k++) {
	            keyDownFrame[k]        = keyDownState[k];
	            keyPressEdgeFrame[k]   = (keyPressAcc[k]   > 0);
	            keyReleaseEdgeFrame[k] = (keyReleaseAcc[k] > 0);
	            keyPressAcc[k]   = 0;
	            keyReleaseAcc[k] = 0;
	        }
	    }
	    synchronized (mouseLock) {
	        for (int b = 0; b < MOUSE_BUTTONS; b++) {
	            mouseDownFrame[b]        = mouseDownState[b];
	            mousePressEdgeFrame[b]   = (mousePressAcc[b]   > 0);
	            mouseReleaseEdgeFrame[b] = (mouseReleaseAcc[b] > 0);
	            mousePressAcc[b]   = 0;
	            mouseReleaseAcc[b] = 0;
	        }
	    }
	    try {
	        SwingUtilities.invokeAndWait(() -> { /* flush EDT */ });
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void EndDrawing() {
		//super.EndDrawing();
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					//panel.repaint();
					panel.paintImmediately(new Rectangle(offscreenSurface.getWidth(), offscreenSurface.getHeight()));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public int IsKeyDown(int key) {
	    return (key >= 0 && key < KEY_CAP && keyDownFrame[key]) ? 1 : 0;
	}

	@Override
	public int IsKeyPressed(int key) {
	    if (key < 0 || key >= KEY_CAP) return 0;
	    return keyPressEdgeFrame[key] ? 1 : 0;    // visible 1 frame
	}

	@Override
	public int IsMouseButtonDown(int b) {
	    return (b >= 0 && b < MOUSE_BUTTONS && mouseDownFrame[b]) ? 1 : 0;
	}

	@Override
	public int IsMouseButtonPressed(int b) {
	    if (b < 0 || b >= MOUSE_BUTTONS) return 0;
	    return mousePressEdgeFrame[b] ? 1 : 0;   // visible une seule frame
	}

	@Override
	public int IsMouseButtonReleased(int b) {
	    if (b < 0 || b >= MOUSE_BUTTONS) return 0;
	    return mouseReleaseEdgeFrame[b] ? 1 : 0; // visible une seule frame
	}

	@Override
	public int GetCharPressed() {
	    synchronized (charQueue) {
	        if (charQueue.isEmpty()) return 0;
	        return charQueue.remove(0);
	    }
	}

	@Override
	public void GetMousePosition(long addr) {
	    mir_write_float(addr, mouseX);
	    mir_write_float(addr + 4, mouseY);
	}
	
    public float GetMouseWheelMove() {
        // TODO
        return 0.0f;
    }	
    
    public int getMaxCharWidth () {
        return 10;
      } // End of function getMaxCharWidth

      public int getMaxCharHeight () {
        return 20;
      } // End of function getMaxCharHeight

	private JPanel createPanel(AWTEventConverter converter) {

		final Dimension dimension = new Dimension(offscreenSurface.getWidth(), offscreenSurface.getHeight());
		JPanel panel = new JPanel() {

			public Dimension getMinimumSize() {
				return dimension;
			}

			public Dimension getPreferredSize() {
				return dimension;
			}

			public void paintComponent(Graphics g) {
				if (offscreenSurface != null) {
					g.drawImage(offscreenSurface, 0, 0, null);
				}
			}
		};
		panel.addKeyListener(converter);
		panel.addMouseListener(converter);
		panel.addMouseMotionListener(converter);
		// Disable focus traversal keys to handle tab events
		panel.setFocusTraversalKeysEnabled(false);
		panel.setFocusable(true);

		return panel;
	}

	private void fireKeyPressed(int key) {
	    if (key <= 0 || key >= KEY_CAP) return;
	    synchronized (keyLock) {
	        if (!keyDownState[key]) {        // edge up -> down
	            keyDownState[key] = true;
	            keyPressAcc[key]++;           // accumule le press
	        }
	    }
	}

	private void fireKeyReleased(int key) {
	    if (key <= 0 || key >= KEY_CAP) return;
	    synchronized (keyLock) {
	        if (keyDownState[key]) {         // edge down -> up
	            keyDownState[key] = false;
	            keyReleaseAcc[key]++;        // accumule le release
	        }
	    }
	}

	private void fireMousePressed(int rb) {
	    if (rb < 0 || rb >= MOUSE_BUTTONS) return;
	    synchronized (mouseLock) {
	        if (!mouseDownState[rb]) {          // edge up -> down
	            mouseDownState[rb] = true;
	            mousePressAcc[rb]++;            // on accumule le press
	        }
	    }
	}

	private void fireMouseReleased(int rb) {
	    if (rb < 0 || rb >= MOUSE_BUTTONS) return;
	    synchronized (mouseLock) {
	        if (mouseDownState[rb]) {           // edge down -> up
	            mouseDownState[rb] = false;
	            mouseReleaseAcc[rb]++;          // on accumule le release
	        }
	    }
	}

	// Char queue stays the same but make it thread-safe
	private void fireCharTyped(char c) {
	    // Ignore most control chars; raygui reads BACKSPACE via KEY_BACKSPACE, not chars
	    if (c < 0x20 && c != '\n' && c != '\t') return;
	    synchronized (charQueue) { charQueue.add(c); }
	}


	private void setMousePosition(int x, int y) {
	    mouseX = x;
	    mouseY = y;
	}

    private static int mapAwtButtonToRaylibIndex(int awtButton) {
        // raylib: 0=LEFT,1=RIGHT,2=MIDDLE,3/4=EXTRA
        switch (awtButton) {
        case MouseEvent.BUTTON1:
            return 0;
        case MouseEvent.BUTTON3:
            return 1;
        case MouseEvent.BUTTON2:
            return 2;
        default:
            return Math.min(awtButton, MOUSE_BUTTONS - 1);
        }
    }

	private class AWTEventConverter extends ComponentAdapter implements KeyListener, MouseListener, MouseMotionListener, WindowListener {

		public int convertAWTKeyCode(int keyCode) {
			switch (keyCode) {
			case KeyEvent.VK_ENTER:
				return KEY_ENTER;
			case KeyEvent.VK_BACK_SPACE:
				return KEY_BACKSPACE;
			case KeyEvent.VK_TAB:
				return KEY_TAB;
			case KeyEvent.VK_SHIFT:
				return KEY_LEFT_SHIFT;
			case KeyEvent.VK_CONTROL:
				return KEY_LEFT_CONTROL;
			case KeyEvent.VK_ALT:
				return KEY_LEFT_ALT;
			case KeyEvent.VK_PAUSE:
				return KEY_PAUSE;
			case KeyEvent.VK_CAPS_LOCK:
				return KEY_CAPS_LOCK;
			case KeyEvent.VK_ESCAPE:
				return KEY_ESCAPE;
			case KeyEvent.VK_SPACE:
				return KEY_SPACE;
			case KeyEvent.VK_PAGE_UP:
				return KEY_PAGE_UP;
			case KeyEvent.VK_PAGE_DOWN:
				return KEY_PAGE_DOWN;
			case KeyEvent.VK_END:
				return KEY_END;
			case KeyEvent.VK_HOME:
				return KEY_HOME;
			case KeyEvent.VK_LEFT:
				return KEY_LEFT;
			case KeyEvent.VK_UP:
				return KEY_UP;
			case KeyEvent.VK_RIGHT:
				return KEY_RIGHT;
			case KeyEvent.VK_DOWN:
				return KEY_DOWN;
			case KeyEvent.VK_COMMA:
				return KEY_COMMA;
			case KeyEvent.VK_MINUS:
				return KEY_MINUS;
			case KeyEvent.VK_PERIOD:
				return KEY_PERIOD;
			case KeyEvent.VK_SLASH:
				return KEY_SLASH;
			case KeyEvent.VK_SEMICOLON:
				return KEY_SEMICOLON;
			case KeyEvent.VK_EQUALS:
				return KEY_EQUAL;
			case KeyEvent.VK_0:
			case KeyEvent.VK_1:
			case KeyEvent.VK_2:
			case KeyEvent.VK_3:
			case KeyEvent.VK_4:
			case KeyEvent.VK_5:
			case KeyEvent.VK_6:
			case KeyEvent.VK_7:
			case KeyEvent.VK_8:
			case KeyEvent.VK_9:
			case KeyEvent.VK_A:
			case KeyEvent.VK_B:
			case KeyEvent.VK_C:
			case KeyEvent.VK_D:
			case KeyEvent.VK_E:
			case KeyEvent.VK_F:
			case KeyEvent.VK_G:
			case KeyEvent.VK_H:
			case KeyEvent.VK_I:
			case KeyEvent.VK_J:
			case KeyEvent.VK_K:
			case KeyEvent.VK_L:
			case KeyEvent.VK_M:
			case KeyEvent.VK_N:
			case KeyEvent.VK_O:
			case KeyEvent.VK_P:
			case KeyEvent.VK_Q:
			case KeyEvent.VK_R:
			case KeyEvent.VK_S:
			case KeyEvent.VK_T:
			case KeyEvent.VK_U:
			case KeyEvent.VK_V:
			case KeyEvent.VK_W:
			case KeyEvent.VK_X:
			case KeyEvent.VK_Y:
			case KeyEvent.VK_Z:
				return keyCode;
			case KeyEvent.VK_OPEN_BRACKET:
				return KEY_LEFT_BRACKET;
			case KeyEvent.VK_BACK_SLASH:
				return KEY_BACKSLASH;
			case KeyEvent.VK_CLOSE_BRACKET:
				return KEY_RIGHT_BRACKET;
			case KeyEvent.VK_NUMPAD0:
				return KEY_KP_0;
			case KeyEvent.VK_NUMPAD1:
				return KEY_KP_1;
			case KeyEvent.VK_NUMPAD2:
				return KEY_KP_2;
			case KeyEvent.VK_NUMPAD3:
				return KEY_KP_3;
			case KeyEvent.VK_NUMPAD4:
				return KEY_KP_4;
			case KeyEvent.VK_NUMPAD5:
				return KEY_KP_5;
			case KeyEvent.VK_NUMPAD6:
				return KEY_KP_6;
			case KeyEvent.VK_NUMPAD7:
				return KEY_KP_7;
			case KeyEvent.VK_NUMPAD8:
				return KEY_KP_8;
			case KeyEvent.VK_NUMPAD9:
				return KEY_KP_9;
			case KeyEvent.VK_MULTIPLY:
				return KEY_KP_MULTIPLY;
			case KeyEvent.VK_ADD:
				return KEY_KP_ADD;
			//case KeyEvent.VK_SEPARATOR:
			case KeyEvent.VK_SUBTRACT:
				return KEY_KP_SUBTRACT;
			//case KeyEvent.VK_DECIMAL:
			case KeyEvent.VK_DIVIDE:
				return KEY_KP_DIVIDE;
			case KeyEvent.VK_DELETE:
				return KEY_DELETE;
			case KeyEvent.VK_NUM_LOCK:
				return KEY_NUM_LOCK;
			case KeyEvent.VK_SCROLL_LOCK:
				return KEY_SCROLL_LOCK;
			case KeyEvent.VK_F1:
				return KEY_F1;
			case KeyEvent.VK_F2:
				return KEY_F2;
			case KeyEvent.VK_F3:
				return KEY_F3;
			case KeyEvent.VK_F4:
				return KEY_F4;
			case KeyEvent.VK_F5:
				return KEY_F5;
			case KeyEvent.VK_F6:
				return KEY_F6;
			case KeyEvent.VK_F7:
				return KEY_F7;
			case KeyEvent.VK_F8:
				return KEY_F8;
			case KeyEvent.VK_F9:
				return KEY_F9;
			case KeyEvent.VK_F10:
				return KEY_F10;
			case KeyEvent.VK_F11:
				return KEY_F11;
			case KeyEvent.VK_F12:
				return KEY_F12;
			case KeyEvent.VK_PRINTSCREEN:
				return KEY_PRINT_SCREEN;
			case KeyEvent.VK_INSERT:
				return KEY_INSERT;
			case KeyEvent.VK_BACK_QUOTE:
				return KEY_GRAVE;
			case KeyEvent.VK_QUOTE:
				return KEY_APOSTROPHE;
			case KeyEvent.VK_KP_UP:
				return KEY_UP;
			case KeyEvent.VK_KP_DOWN:
				return KEY_DOWN;
			case KeyEvent.VK_KP_LEFT:
				return KEY_LEFT;
			case KeyEvent.VK_KP_RIGHT:
				return KEY_RIGHT;
			//case KeyEvent.VK_AMPERSAND:
			case KeyEvent.VK_ASTERISK:
				return KEY_KP_MULTIPLY;
			//case KeyEvent.VK_QUOTEDBL:
			case KeyEvent.VK_LESS:
				return KEY_MINUS;
			//case KeyEvent.VK_GREATER:
			//case KeyEvent.VK_BRACELEFT:
			//case KeyEvent.VK_BRACERIGHT:
			//case KeyEvent.VK_AT:
			//case KeyEvent.VK_COLON:
			//case KeyEvent.VK_CIRCUMFLEX:
			//case KeyEvent.VK_DOLLAR:
			//case KeyEvent.VK_EURO_SIGN:
			//case KeyEvent.VK_EXCLAMATION_MARK:
			//case KeyEvent.VK_INVERTED_EXCLAMATION_MARK:
			//case KeyEvent.VK_LEFT_PARENTHESIS:
			//case KeyEvent.VK_NUMBER_SIGN:
			case KeyEvent.VK_PLUS:
				return KEY_KP_ADD;
			//case KeyEvent.VK_RIGHT_PARENTHESIS:
			//case KeyEvent.VK_UNDERSCORE:
			default:
				return KEY_NULL;
			}
		}

		@Override
	    public void keyPressed(KeyEvent e) {
	        int ray = convertAWTKeyCode(e.getKeyCode());
	        fireKeyPressed(ray);
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	        int ray = convertAWTKeyCode(e.getKeyCode());
	        fireKeyReleased(ray);
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	        char c = e.getKeyChar();
	        // Synthesize press edges for keys that often arrive as typed chars
	        if (c == '\b') { // BACKSPACE auto-repeat arrives here on many systems
	            fireKeyPressed(KEY_BACKSPACE);
	            return;
	        }
	        if (c == '\n') { // Enter in text fields can be typed
	            fireKeyPressed(KEY_ENTER);
	            return;
	        }
	        // Keep printable chars for GetCharPressed()
	        if (c >= 0x20 || c == '\t' || c == '\n') {
	            fireCharTyped(c);
	        }
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
	        if (!panel.isFocusOwner()) 
	            panel.requestFocusInWindow();        // keep keyboard focus after click
	        setMousePosition(e.getX(), e.getY());
	        fireMousePressed(mapAwtButtonToRaylibIndex(e.getButton()));
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	        setMousePosition(e.getX(), e.getY());
	        fireMouseReleased(mapAwtButtonToRaylibIndex(e.getButton()));
	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
	        setMousePosition(e.getX(), e.getY());
	    }

	    @Override
	    public void mouseMoved(MouseEvent e) {
	        setMousePosition(e.getX(), e.getY());
	    }

		public void windowClosing(WindowEvent e) {
			//addEvent(EVENT_TYPE_WINDOW_CLOSING, 0, 0);
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowActivated(WindowEvent arg0) {
		}

		public void windowDeactivated(WindowEvent arg0) {
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {
		}

		public void windowOpened(WindowEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		  
		}


        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
		public void componentResized(ComponentEvent e) {
			int w = e.getComponent().getWidth();
			int h = e.getComponent().getHeight();
			offscreenSurface = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			graphics = offscreenSurface.createGraphics();
        }

	}

	class Color {

		final float INT_TO_FLOAT_CONST = 1f / 255f;
		float alpha;
		float red;
		float green;
		float blue;

		public Color() {
		}

		public Color(int rgba) {
			setRGBA(rgba);
		}

		void setRGBA(int rgba) {
			int r = (rgba >> 24) & 0xFF;
			int g = (rgba >> 16) & 0xFF;
			int b = (rgba >> 8) & 0xFF;
			int a = rgba & 0xFF;
			setInt(r, g, b, a);
		}

		void setInt(int red, int green, int blue, int alpha) {
			this.red = red * INT_TO_FLOAT_CONST;
			this.green = green * INT_TO_FLOAT_CONST;
			this.blue = blue * INT_TO_FLOAT_CONST;
			this.alpha = alpha * INT_TO_FLOAT_CONST;
		}

		void setFloat(float red, float green, float blue, float alpha) {
			this.alpha = alpha;
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

		@Override
		public String toString() {
			return "Color [alpha=" + alpha + ", red=" + red + ", green=" + green + ", blue=" + blue + "]";
		}
	}

	/*
	 * See
	 * https://harmoniccode.blogspot.com/2011/04/bilinear-color-interpolation.
	 * html
	 */
	private void interpolateColor(Color outputColor, final Color color1, final Color color2, float fraction) {
		fraction = Math.min(fraction, 1f);
		fraction = Math.max(fraction, 0f);

		final float RED1 = color1.red;
		final float GREEN1 = color1.green;
		final float BLUE1 = color1.blue;
		final float ALPHA1 = color1.alpha;

		final float RED2 = color2.red;
		final float GREEN2 = color2.green;
		final float BLUE2 = color2.blue;
		final float ALPHA2 = color2.alpha;

		final float DELTA_RED = RED2 - RED1;
		final float DELTA_GREEN = GREEN2 - GREEN1;
		final float DELTA_BLUE = BLUE2 - BLUE1;
		final float DELTA_ALPHA = ALPHA2 - ALPHA1;

		float red = RED1 + (DELTA_RED * fraction);
		float green = GREEN1 + (DELTA_GREEN * fraction);
		float blue = BLUE1 + (DELTA_BLUE * fraction);
		float alpha = ALPHA1 + (DELTA_ALPHA * fraction);

		red = Math.min(red, 1f);
		red = Math.max(red, 0f);
		green = Math.min(green, 1f);
		green = Math.max(green, 0f);
		blue = Math.min(blue, 1f);
		blue = Math.max(blue, 0f);
		alpha = Math.min(alpha, 1f);
		alpha = Math.max(alpha, 0f);
		outputColor.setFloat(red, green, blue, alpha);
	}

	Color COLOR_X1 = new Color();
	Color COLOR_X2 = new Color();

	private void bilinearInterpolateColor(Color outputColor, final Color color00, Color color10, final Color color01, final Color color11, final float fractionX, final float fractionY) {
		interpolateColor(COLOR_X1, color00, color10, fractionX);
		interpolateColor(COLOR_X2, color01, color11, fractionX);
		interpolateColor(outputColor, COLOR_X1, COLOR_X2, fractionY);
	}

	/**
	 * @author Gerrit Grunwald <han.solo at muenster.de>
	 */
	public final class BiLinearGradientPaint implements java.awt.Paint {
		private static final float INT_TO_FLOAT_CONST = 1f / 255f;
		private final java.awt.Rectangle BOUNDS;
		private final java.awt.Color COLOR_00;
		private final java.awt.Color COLOR_10;
		private final java.awt.Color COLOR_01;
		private final java.awt.Color COLOR_11;
		private final float FRACTION_X_STEPSIZE;
		private final float FRACTION_Y_STEPSIZE;
		private int titleBarHeight;

		/**
		 * Enhanced constructor which takes bounds of the objects SHAPE to fill and the four
		 * colors we need to create the bilinear interpolated gradient
		 * @param SHAPE      
		 * @param COLOR_00      
		 * @param COLOR_10 
		 * @param COLOR_01 
		 * @param COLOR_11 
		 * @throws IllegalArgumentException
		 */
		public BiLinearGradientPaint(final java.awt.Shape SHAPE, final java.awt.Color COLOR_00, final java.awt.Color COLOR_10, final java.awt.Color COLOR_01, final java.awt.Color COLOR_11)
				throws IllegalArgumentException {
			// Set the values
			this.BOUNDS = SHAPE.getBounds();
			this.COLOR_00 = COLOR_00;
			this.COLOR_10 = COLOR_10;
			this.COLOR_01 = COLOR_01;
			this.COLOR_11 = COLOR_11;
			this.FRACTION_X_STEPSIZE = 1.0f / (BOUNDS.getBounds().width);
			this.FRACTION_Y_STEPSIZE = 1.0f / (BOUNDS.getBounds().height);
			this.titleBarHeight = -1;
		}

		@Override
		public java.awt.PaintContext createContext(final java.awt.image.ColorModel COLOR_MODEL, final java.awt.Rectangle DEVICE_BOUNDS, final java.awt.geom.Rectangle2D USER_BOUNDS,
				final java.awt.geom.AffineTransform TRANSFORM, final java.awt.RenderingHints HINTS) {
			return new BiLinearGradientPaintContext();
		}

		@Override
		public int getTransparency() {
			return java.awt.Transparency.TRANSLUCENT;
		}

		private final class BiLinearGradientPaintContext implements java.awt.PaintContext {
			public BiLinearGradientPaintContext() {
			}

			/**
			 * Returns the interpolated color that you get if you multiply the delta between
			 * color2 and color1 with the given fraction (for each channel). The fraction should
			 * be a value between 0 and 1.
			 * @param COLOR1 The first color as integer in the hex format 0xALPHA RED GREEN BLUE, e.g. 0xFF00FF00 for a pure green
			 * @param COLOR2 The second color as integer in the hex format 0xALPHA RED GREEN BLUE e.g. 0xFFFF0000 for a pure red
			 * @param fraction The fraction between those two colors that we would like to get e.g. 0.5f will result in the color 0xFF808000
			 * @return the interpolated color between color1 and color2 calculated by the given fraction
			 */
			private java.awt.Color interpolateColor(final java.awt.Color COLOR1, final java.awt.Color COLOR2, float fraction) {
				fraction = Math.min(fraction, 1f);
				fraction = Math.max(fraction, 0f);

				final float RED1 = COLOR1.getRed() * INT_TO_FLOAT_CONST;
				final float GREEN1 = COLOR1.getGreen() * INT_TO_FLOAT_CONST;
				final float BLUE1 = COLOR1.getBlue() * INT_TO_FLOAT_CONST;
				final float ALPHA1 = COLOR1.getAlpha() * INT_TO_FLOAT_CONST;

				final float RED2 = COLOR2.getRed() * INT_TO_FLOAT_CONST;
				final float GREEN2 = COLOR2.getGreen() * INT_TO_FLOAT_CONST;
				final float BLUE2 = COLOR2.getBlue() * INT_TO_FLOAT_CONST;
				final float ALPHA2 = COLOR2.getAlpha() * INT_TO_FLOAT_CONST;

				final float DELTA_RED = RED2 - RED1;
				final float DELTA_GREEN = GREEN2 - GREEN1;
				final float DELTA_BLUE = BLUE2 - BLUE1;
				final float DELTA_ALPHA = ALPHA2 - ALPHA1;

				float red = RED1 + (DELTA_RED * fraction);
				float green = GREEN1 + (DELTA_GREEN * fraction);
				float blue = BLUE1 + (DELTA_BLUE * fraction);
				float alpha = ALPHA1 + (DELTA_ALPHA * fraction);

				red = Math.min(red, 1f);
				red = Math.max(red, 0f);
				green = Math.min(green, 1f);
				green = Math.max(green, 0f);
				blue = Math.min(blue, 1f);
				blue = Math.max(blue, 0f);
				alpha = Math.min(alpha, 1f);
				alpha = Math.max(alpha, 0f);

				return new java.awt.Color(red, green, blue, alpha);
			}

			/**
			 * Returns the color calculated by a bilinear interpolation by the two fractions in x and y direction.
			 * To get the color of the point defined by FRACTION_X and FRACTION_Y with in the rectangle defined by the
			 * for given colors we first calculate the interpolated color between COLOR_00 and COLOR_10 (x-direction) with
			 * the given FRACTION_X. After that we calculate the interpolated color between COLOR_01 and COLOR_11 (x-direction)
			 * with the given FRACTION_X. Now we interpolate between the two results of the former calculations (y-direction)
			 * with the given FRACTION_Y.
			 * @param COLOR_00 The color on the lower left corner of the square
			 * @param COLOR_10 The color on the lower right corner of the square
			 * @param COLOR_01 The color on the upper left corner of the square
			 * @param COLOR_11 The color on the upper right corner of the square
			 * @param FRACTION_X The fraction of the point in x direction (between COLOR_00 and COLOR_10 or COLOR_01 and COLOR_11) range: 0.0f .. 1.0f
			 * @param FRACTION_Y The fraction of the point in y direction (between COLOR_00 and COLOR_01 or COLOR_10 and COLOR_11) range: 0.0f .. 1.0f
			 * @return the color of the point defined by fraction_x and fraction_y in the square defined by the for colors
			 */
			private java.awt.Color bilinearInterpolateColor(final java.awt.Color COLOR_00, final java.awt.Color COLOR_10, final java.awt.Color COLOR_01, final java.awt.Color COLOR_11,
					final float FRACTION_X, final float FRACTION_Y) {
				final java.awt.Color INTERPOLATED_COLOR_X1 = interpolateColor(COLOR_00, COLOR_10, FRACTION_X);
				final java.awt.Color INTERPOLATED_COLOR_X2 = interpolateColor(COLOR_01, COLOR_11, FRACTION_X);
				return interpolateColor(INTERPOLATED_COLOR_X1, INTERPOLATED_COLOR_X2, FRACTION_Y);
			}

			@Override
			public void dispose() {
			}

			@Override
			public java.awt.image.ColorModel getColorModel() {
				return java.awt.image.ColorModel.getRGBdefault();
			}

			@Override
			public java.awt.image.Raster getRaster(final int X, final int Y, final int TILE_WIDTH, final int TILE_HEIGHT) {
				// Get the offset given by the height of the titlebar
				if (titleBarHeight == -1) {
					titleBarHeight = Y;
				}

				// Create raster for given colormodel
				final java.awt.image.WritableRaster RASTER = getColorModel().createCompatibleWritableRaster(TILE_WIDTH, TILE_HEIGHT);

				// Create data array with place for red, green, blue and alpha values
				final int[] DATA = new int[(TILE_WIDTH * TILE_HEIGHT * 4)];
				java.awt.Color currentColor;

				float fraction_x = (X - BOUNDS.x) * FRACTION_X_STEPSIZE;
				float fraction_y = (Y - BOUNDS.y - titleBarHeight) * FRACTION_Y_STEPSIZE;

				fraction_x = Math.min(fraction_x, 1f);
				fraction_y = Math.min(fraction_y, 1f);

				for (int tileY = 0; tileY < TILE_HEIGHT; tileY++) {
					for (int tileX = 0; tileX < TILE_WIDTH; tileX++) {
						currentColor = bilinearInterpolateColor(COLOR_00, COLOR_10, COLOR_01, COLOR_11, fraction_x, fraction_y);

						fraction_x += FRACTION_X_STEPSIZE;
						fraction_x = Math.min(fraction_x, 1f);

						// Fill data array with calculated color values
						final int BASE = (tileY * TILE_WIDTH + tileX) * 4;
						DATA[BASE + 0] = currentColor.getRed();
						DATA[BASE + 1] = currentColor.getGreen();
						DATA[BASE + 2] = currentColor.getBlue();
						DATA[BASE + 3] = currentColor.getAlpha();
					}
					fraction_x = (X - BOUNDS.x) * FRACTION_X_STEPSIZE;
					fraction_y += FRACTION_Y_STEPSIZE;
					fraction_y = Math.min(fraction_y, 1f);
				}

				// Fill the raster with the data
				RASTER.setPixels(0, 0, TILE_WIDTH, TILE_HEIGHT, DATA);

				return RASTER;
			}
		}

		@Override
		public String toString() {
			return "BiLinearGradientPaint";
		}
	}

	public static void main(String[] args) {
		Raygui raygui = new Raygui();
		raygui.main();
	}

}
