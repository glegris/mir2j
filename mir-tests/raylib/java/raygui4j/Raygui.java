package raygui4j;

import java.util.Arrays;
import java.util.Vector;

public class Raygui extends RayguiBase implements Backend.InputSink {

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

    // Gui control state
    public static final int STATE_NORMAL = 0;
    public static final int STATE_FOCUSED = 1;
    public static final int STATE_PRESSED = 2;
    public static final int STATE_DISABLED = 3;

    // Gui control text alignment
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_RIGHT = 2;

    // Gui controls
    public static final int DEFAULT = 0;
    public static final int LABEL = 1; // Also: LABELBUTTON
    public static final int BUTTON = 2;
    public static final int TOGGLE = 3; // Also: TOGGLEGROUP
    public static final int SLIDER = 4; // Also: SLIDERBAR
    public static final int PROGRESSBAR = 5;
    public static final int CHECKBOX = 6;
    public static final int COMBOBOX = 7;
    public static final int DROPDOWNBOX = 8;
    public static final int TEXTBOX = 9; // Also: TEXTBOXMULTI
    public static final int VALUEBOX = 10;
    public static final int SPINNER = 11; // Uses: BUTTON, VALUEBOX
    public static final int LISTVIEW = 12;
    public static final int COLORPICKER = 13;
    public static final int SCROLLBAR = 14;
    public static final int STATUSBAR = 15;

    // Gui base properties
    public static final int BORDER_COLOR_NORMAL = 0;
    public static final int BASE_COLOR_NORMAL = 1;
    public static final int TEXT_COLOR_NORMAL = 2;
    public static final int BORDER_COLOR_FOCUSED = 3;
    public static final int BASE_COLOR_FOCUSED = 4;
    public static final int TEXT_COLOR_FOCUSED = 5;
    public static final int BORDER_COLOR_PRESSED = 6;
    public static final int BASE_COLOR_PRESSED = 7;
    public static final int TEXT_COLOR_PRESSED = 8;
    public static final int BORDER_COLOR_DISABLED = 9;
    public static final int BASE_COLOR_DISABLED = 10;
    public static final int TEXT_COLOR_DISABLED = 11;
    public static final int BORDER_WIDTH = 12;
    public static final int TEXT_PADDING = 13;
    public static final int TEXT_ALIGNMENT = 14;
    public static final int RESERVED = 15;

    // Gui default properties
    public static final int TEXT_SIZE = 16;
    public static final int TEXT_SPACING = 17;
    public static final int LINE_COLOR = 18;
    public static final int BACKGROUND_COLOR = 19;

    // GuiToggleProperty
    public static final int GROUP_PADDING = 16;

    // GuiSliderProperty
    public static final int SLIDER_WIDTH = 16;
    public static final int SLIDER_PADDING = 17;

    // GuiProgressBarProperty
    public static final int PROGRESS_PADDING = 16;

    // GuiScrollBarProperty
    public static final int ARROWS_SIZE = 16;
    public static final int ARROWS_VISIBLE = 17;
    public static final int SCROLL_SLIDER_PADDING = 18;
    public static final int SCROLL_SLIDER_SIZE = 19;
    public static final int SCROLL_PADDING = 20;
    public static final int SCROLL_SPEED = 21;

    // GuiCheckBoxProperty
    public static final int CHECK_PADDING = 16;

    // GuiComboBoxProperty
    public static final int COMBO_BUTTON_WIDTH = 16;
    public static final int COMBO_BUTTON_SPACING = 17;

    // GuiDropdownBoxProperty
    public static final int ARROW_PADDING = 16;
    public static final int DROPDOWN_ITEMS_SPACING = 17;

    // GuiTextBoxProperty
    public static final int TEXT_INNER_PADDING = 16;
    public static final int TEXT_LINES_SPACING = 17;

    // GuiSpinnerProperty
    public static final int SPIN_BUTTON_WIDTH = 16;
    public static final int SPIN_BUTTON_SPACING = 17;

    // GuiListViewProperty
    public static final int LIST_ITEMS_HEIGHT = 16;
    public static final int LIST_ITEMS_SPACING = 17;
    public static final int SCROLLBAR_WIDTH = 18;
    public static final int SCROLLBAR_SIDE = 19;

    // GuiColorPickerProperty
    public static final int COLOR_SELECTOR_SIZE = 16;
    public static final int HUEBAR_WIDTH = 17;
    public static final int HUEBAR_PADDING = 18;
    public static final int HUEBAR_SELECTOR_HEIGHT = 19;
    public static final int HUEBAR_SELECTOR_OVERFLOW = 20;

    public static final int LIGHTGRAY = RGBA(200, 200, 200, 255);
    public static final int GRAY = RGBA(130, 130, 130, 255);
    public static final int DARKGRAY = RGBA(80, 80, 80, 255);
    public static final int YELLOW = RGBA(253, 249, 0, 255);
    public static final int GOLD = RGBA(255, 203, 0, 255);
    public static final int ORANGE = RGBA(255, 161, 0, 255);
    public static final int PINK = RGBA(255, 109, 194, 255);
    public static final int RED = RGBA(230, 41, 55, 255);
    private static final int MAROON = RGBA(190, 33, 55, 255);
    public static final int GREEN = RGBA(0, 228, 48, 255);
    public static final int LIME = RGBA(0, 158, 47, 255);
    public static final int DARKGREEN = RGBA(0, 117, 44, 255);
    public static final int SKYBLUE = RGBA(102, 191, 255, 255);
    public static final int BLUE = RGBA(0, 121, 241, 255);
    public static final int DARKBLUE = RGBA(0, 82, 172, 255);
    public static final int PURPLE = RGBA(200, 122, 255, 255);
    public static final int VIOLET = RGBA(135, 60, 190, 255);
    public static final int DARKPURPLE = RGBA(112, 31, 126, 255);
    public static final int BEIGE = RGBA(211, 176, 131, 255);
    public static final int BROWN = RGBA(127, 106, 79, 255);
    public static final int DARKBROWN = RGBA(76, 63, 47, 255);
    public static final int WHITE = RGBA(255, 255, 255, 255);
    public static final int BLACK = RGBA(0, 0, 0, 255);
    public static final int BLANK = RGBA(0, 0, 0, 0);
    public static final int MAGENTA = RGBA(255, 0, 255, 255);
    public static final int RAYWHITE = RGBA(245, 245, 245, 255);

    public static final int ICON_NONE = 0;
    public static final int ICON_FOLDER_FILE_OPEN = 1;
    public static final int ICON_FILE_SAVE_CLASSIC = 2;
    public static final int ICON_FOLDER_OPEN = 3;
    public static final int ICON_FOLDER_SAVE = 4;
    public static final int ICON_FILE_OPEN = 5;
    public static final int ICON_FILE_SAVE = 6;
    public static final int ICON_FILE_EXPORT = 7;
    public static final int ICON_FILE_ADD = 8;
    public static final int ICON_FILE_DELETE = 9;
    public static final int ICON_FILETYPE_TEXT = 10;
    public static final int ICON_FILETYPE_AUDIO = 11;
    public static final int ICON_FILETYPE_IMAGE = 12;
    public static final int ICON_FILETYPE_PLAY = 13;
    public static final int ICON_FILETYPE_VIDEO = 14;
    public static final int ICON_FILETYPE_INFO = 15;
    public static final int ICON_FILE_COPY = 16;
    public static final int ICON_FILE_CUT = 17;
    public static final int ICON_FILE_PASTE = 18;
    public static final int ICON_CURSOR_HAND = 19;
    public static final int ICON_CURSOR_POINTER = 20;
    public static final int ICON_CURSOR_CLASSIC = 21;
    public static final int ICON_PENCIL = 22;
    public static final int ICON_PENCIL_BIG = 23;
    public static final int ICON_BRUSH_CLASSIC = 24;
    public static final int ICON_BRUSH_PAINTER = 25;
    public static final int ICON_WATER_DROP = 26;
    public static final int ICON_COLOR_PICKER = 27;
    public static final int ICON_RUBBER = 28;
    public static final int ICON_COLOR_BUCKET = 29;
    public static final int ICON_TEXT_T = 30;
    public static final int ICON_TEXT_A = 31;
    public static final int ICON_SCALE = 32;
    public static final int ICON_RESIZE = 33;
    public static final int ICON_FILTER_POINT = 34;
    public static final int ICON_FILTER_BILINEAR = 35;
    public static final int ICON_CROP = 36;
    public static final int ICON_CROP_ALPHA = 37;
    public static final int ICON_SQUARE_TOGGLE = 38;
    public static final int ICON_SYMMETRY = 39;
    public static final int ICON_SYMMETRY_HORIZONTAL = 40;
    public static final int ICON_SYMMETRY_VERTICAL = 41;
    public static final int ICON_LENS = 42;
    public static final int ICON_LENS_BIG = 43;
    public static final int ICON_EYE_ON = 44;
    public static final int ICON_EYE_OFF = 45;
    public static final int ICON_FILTER_TOP = 46;
    public static final int ICON_FILTER = 47;
    public static final int ICON_TARGET_POINT = 48;
    public static final int ICON_TARGET_SMALL = 49;
    public static final int ICON_TARGET_BIG = 50;
    public static final int ICON_TARGET_MOVE = 51;
    public static final int ICON_CURSOR_MOVE = 52;
    public static final int ICON_CURSOR_SCALE = 53;
    public static final int ICON_CURSOR_SCALE_RIGHT = 54;
    public static final int ICON_CURSOR_SCALE_LEFT = 55;
    public static final int ICON_UNDO = 56;
    public static final int ICON_REDO = 57;
    public static final int ICON_REREDO = 58;
    public static final int ICON_MUTATE = 59;
    public static final int ICON_ROTATE = 60;
    public static final int ICON_REPEAT = 61;
    public static final int ICON_SHUFFLE = 62;
    public static final int ICON_EMPTYBOX = 63;
    public static final int ICON_TARGET = 64;
    public static final int ICON_TARGET_SMALL_FILL = 65;
    public static final int ICON_TARGET_BIG_FILL = 66;
    public static final int ICON_TARGET_MOVE_FILL = 67;
    public static final int ICON_CURSOR_MOVE_FILL = 68;
    public static final int ICON_CURSOR_SCALE_FILL = 69;
    public static final int ICON_CURSOR_SCALE_RIGHT_FILL = 70;
    public static final int ICON_CURSOR_SCALE_LEFT_FILL = 71;
    public static final int ICON_UNDO_FILL = 72;
    public static final int ICON_REDO_FILL = 73;
    public static final int ICON_REREDO_FILL = 74;
    public static final int ICON_MUTATE_FILL = 75;
    public static final int ICON_ROTATE_FILL = 76;
    public static final int ICON_REPEAT_FILL = 77;
    public static final int ICON_SHUFFLE_FILL = 78;
    public static final int ICON_EMPTYBOX_SMALL = 79;
    public static final int ICON_BOX = 80;
    public static final int ICON_BOX_TOP = 81;
    public static final int ICON_BOX_TOP_RIGHT = 82;
    public static final int ICON_BOX_RIGHT = 83;
    public static final int ICON_BOX_BOTTOM_RIGHT = 84;
    public static final int ICON_BOX_BOTTOM = 85;
    public static final int ICON_BOX_BOTTOM_LEFT = 86;
    public static final int ICON_BOX_LEFT = 87;
    public static final int ICON_BOX_TOP_LEFT = 88;
    public static final int ICON_BOX_CENTER = 89;
    public static final int ICON_BOX_CIRCLE_MASK = 90;
    public static final int ICON_POT = 91;
    public static final int ICON_ALPHA_MULTIPLY = 92;
    public static final int ICON_ALPHA_CLEAR = 93;
    public static final int ICON_DITHERING = 94;
    public static final int ICON_MIPMAPS = 95;
    public static final int ICON_BOX_GRID = 96;
    public static final int ICON_GRID = 97;
    public static final int ICON_BOX_CORNERS_SMALL = 98;
    public static final int ICON_BOX_CORNERS_BIG = 99;
    public static final int ICON_FOUR_BOXES = 100;
    public static final int ICON_GRID_FILL = 101;
    public static final int ICON_BOX_MULTISIZE = 102;
    public static final int ICON_ZOOM_SMALL = 103;
    public static final int ICON_ZOOM_MEDIUM = 104;
    public static final int ICON_ZOOM_BIG = 105;
    public static final int ICON_ZOOM_ALL = 106;
    public static final int ICON_ZOOM_CENTER = 107;
    public static final int ICON_BOX_DOTS_SMALL = 108;
    public static final int ICON_BOX_DOTS_BIG = 109;
    public static final int ICON_BOX_CONCENTRIC = 110;
    public static final int ICON_BOX_GRID_BIG = 111;
    public static final int ICON_OK_TICK = 112;
    public static final int ICON_CROSS = 113;
    public static final int ICON_ARROW_LEFT = 114;
    public static final int ICON_ARROW_RIGHT = 115;
    public static final int ICON_ARROW_DOWN = 116;
    public static final int ICON_ARROW_UP = 117;
    public static final int ICON_ARROW_LEFT_FILL = 118;
    public static final int ICON_ARROW_RIGHT_FILL = 119;
    public static final int ICON_ARROW_DOWN_FILL = 120;
    public static final int ICON_ARROW_UP_FILL = 121;
    public static final int ICON_AUDIO = 122;
    public static final int ICON_FX = 123;
    public static final int ICON_WAVE = 124;
    public static final int ICON_WAVE_SINUS = 125;
    public static final int ICON_WAVE_SQUARE = 126;
    public static final int ICON_WAVE_TRIANGULAR = 127;
    public static final int ICON_CROSS_SMALL = 128;
    public static final int ICON_PLAYER_PREVIOUS = 129;
    public static final int ICON_PLAYER_PLAY_BACK = 130;
    public static final int ICON_PLAYER_PLAY = 131;
    public static final int ICON_PLAYER_PAUSE = 132;
    public static final int ICON_PLAYER_STOP = 133;
    public static final int ICON_PLAYER_NEXT = 134;
    public static final int ICON_PLAYER_RECORD = 135;
    public static final int ICON_MAGNET = 136;
    public static final int ICON_LOCK_CLOSE = 137;
    public static final int ICON_LOCK_OPEN = 138;
    public static final int ICON_CLOCK = 139;
    public static final int ICON_TOOLS = 140;
    public static final int ICON_GEAR = 141;
    public static final int ICON_GEAR_BIG = 142;
    public static final int ICON_BIN = 143;
    public static final int ICON_HAND_POINTER = 144;
    public static final int ICON_LASER = 145;
    public static final int ICON_COIN = 146;
    public static final int ICON_EXPLOSION = 147;
    public static final int ICON_1UP = 148;
    public static final int ICON_PLAYER = 149;
    public static final int ICON_PLAYER_JUMP = 150;
    public static final int ICON_KEY = 151;
    public static final int ICON_DEMON = 152;
    public static final int ICON_TEXT_POPUP = 153;
    public static final int ICON_GEAR_EX = 154;
    public static final int ICON_CRACK = 155;
    public static final int ICON_CRACK_POINTS = 156;
    public static final int ICON_STAR = 157;
    public static final int ICON_DOOR = 158;
    public static final int ICON_EXIT = 159;
    public static final int ICON_MODE_2D = 160;
    public static final int ICON_MODE_3D = 161;
    public static final int ICON_CUBE = 162;
    public static final int ICON_CUBE_FACE_TOP = 163;
    public static final int ICON_CUBE_FACE_LEFT = 164;
    public static final int ICON_CUBE_FACE_FRONT = 165;
    public static final int ICON_CUBE_FACE_BOTTOM = 166;
    public static final int ICON_CUBE_FACE_RIGHT = 167;
    public static final int ICON_CUBE_FACE_BACK = 168;
    public static final int ICON_CAMERA = 169;
    public static final int ICON_SPECIAL = 170;
    public static final int ICON_LINK_NET = 171;
    public static final int ICON_LINK_BOXES = 172;
    public static final int ICON_LINK_MULTI = 173;
    public static final int ICON_LINK = 174;
    public static final int ICON_LINK_BROKE = 175;
    public static final int ICON_TEXT_NOTES = 176;
    public static final int ICON_NOTEBOOK = 177;
    public static final int ICON_SUITCASE = 178;
    public static final int ICON_SUITCASE_ZIP = 179;
    public static final int ICON_MAILBOX = 180;
    public static final int ICON_MONITOR = 181;
    public static final int ICON_PRINTER = 182;
    public static final int ICON_PHOTO_CAMERA = 183;
    public static final int ICON_PHOTO_CAMERA_FLASH = 184;
    public static final int ICON_HOUSE = 185;
    public static final int ICON_HEART = 186;
    public static final int ICON_CORNER = 187;
    public static final int ICON_VERTICAL_BARS = 188;
    public static final int ICON_VERTICAL_BARS_FILL = 189;
    public static final int ICON_LIFE_BARS = 190;
    public static final int ICON_INFO = 191;
    public static final int ICON_CROSSLINE = 192;
    public static final int ICON_HELP = 193;
    public static final int ICON_FILETYPE_ALPHA = 194;
    public static final int ICON_FILETYPE_HOME = 195;
    public static final int ICON_LAYERS_VISIBLE = 196;
    public static final int ICON_LAYERS = 197;
    public static final int ICON_WINDOW = 198;
    public static final int ICON_HIDPI = 199;
    public static final int ICON_FILETYPE_BINARY = 200;
    public static final int ICON_HEX = 201;
    public static final int ICON_SHIELD = 202;
    public static final int ICON_FILE_NEW = 203;
    public static final int ICON_FOLDER_ADD = 204;
    public static final int ICON_ALARM = 205;
    public static final int ICON_CPU = 206;
    public static final int ICON_ROM = 207;
    public static final int ICON_STEP_OVER = 208;
    public static final int ICON_STEP_INTO = 209;
    public static final int ICON_STEP_OUT = 210;
    public static final int ICON_RESTART = 211;
    public static final int ICON_BREAKPOINT_ON = 212;
    public static final int ICON_BREAKPOINT_OFF = 213;
    public static final int ICON_BURGER_MENU = 214;
    public static final int ICON_CASE_SENSITIVE = 215;
    public static final int ICON_REG_EXP = 216;
    public static final int ICON_217 = 217;
    public static final int ICON_218 = 218;
    public static final int ICON_219 = 219;
    public static final int ICON_220 = 220;
    public static final int ICON_221 = 221;
    public static final int ICON_222 = 222;
    public static final int ICON_223 = 223;
    public static final int ICON_224 = 224;
    public static final int ICON_225 = 225;
    public static final int ICON_226 = 226;
    public static final int ICON_227 = 227;
    public static final int ICON_228 = 228;
    public static final int ICON_229 = 229;
    public static final int ICON_230 = 230;
    public static final int ICON_231 = 231;
    public static final int ICON_232 = 232;
    public static final int ICON_233 = 233;
    public static final int ICON_234 = 234;
    public static final int ICON_235 = 235;
    public static final int ICON_236 = 236;
    public static final int ICON_237 = 237;
    public static final int ICON_238 = 238;
    public static final int ICON_239 = 239;
    public static final int ICON_240 = 240;
    public static final int ICON_241 = 241;
    public static final int ICON_242 = 242;
    public static final int ICON_243 = 243;
    public static final int ICON_244 = 244;
    public static final int ICON_245 = 245;
    public static final int ICON_246 = 246;
    public static final int ICON_247 = 247;
    public static final int ICON_248 = 248;
    public static final int ICON_249 = 249;
    public static final int ICON_250 = 250;
    public static final int ICON_251 = 251;
    public static final int ICON_252 = 252;
    public static final int ICON_253 = 253;
    public static final int ICON_254 = 254;
    public static final int ICON_255 = 255;

    // Key state
    private static final int KEY_CAP = 512; // give us some headroom
    // Edge accumulators between frames (protected by a lock)
    private final Object keyLock = new Object();
    private final int[] keyPressAcc = new int[KEY_CAP];
    private final int[] keyReleaseAcc = new int[KEY_CAP];
    private final boolean[] keyDownState = new boolean[KEY_CAP]; // current state (EDT)
    private final boolean[] keyDownFrame = new boolean[KEY_CAP]; // snapshot for the frame
    private final boolean[] keyPressEdgeFrame = new boolean[KEY_CAP]; // visible 1 frame
    private final boolean[] keyReleaseEdgeFrame = new boolean[KEY_CAP]; // visible 1 frame

    // Mouse state (raylib indices: 0=LEFT,1=RIGHT,2=MIDDLE,3=SIDE,4=EXTRA)
    private static final int MOUSE_BUTTONS = 8;
    // Edge accumulators between frames (protected by a lock)
    private final Object mouseLock = new Object();
    private final int[] mousePressAcc = new int[MOUSE_BUTTONS];
    private final int[] mouseReleaseAcc = new int[MOUSE_BUTTONS];
    // Current state (EDT side) and snapshot readable by the frame
    private final boolean[] mouseDownState = new boolean[MOUSE_BUTTONS];
    private final boolean[] mouseDownFrame = new boolean[MOUSE_BUTTONS]; // snapshot for the frame
    // Edges visible ONLY during the current frame
    private static final int EDGE_NONE = -1;
    private final boolean[] mousePressEdgeFrame = new boolean[MOUSE_BUTTONS];
    private final boolean[] mouseReleaseEdgeFrame = new boolean[MOUSE_BUTTONS];

    private volatile int mouseX, mouseY;
    private final Vector<Character> charQueue = new Vector<>();

    private Backend backend;

    public Raygui(Backend backend) {
        this.backend = backend;
    }
    
    @Override
    public void InitWindow(int screenWidth, int screenHeight, long screenNameAddr) {
        initEdges();
        String screenName = getStringFromMemory(screenNameAddr);
        InitWindow(screenWidth, screenHeight, screenName);
    }

    public void InitWindow(int screenWidth, int screenHeight, String screenName) {
        backend = new SwingBackend();
        backend.initWindow(screenWidth, screenHeight, screenName, this);
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
        return backend.getScreenWidth();
    }

    @Override
    public int GetScreenHeight() {
        return backend.getScreenHeight();
    }

    @Override
    public void ClearBackground(long colorAddr) {
        backend.clearBackground(ColorToInt(colorAddr));
    }

    @Override
    public void DrawRectangle(int x, int y, int w, int h, long colorAddr) {
        backend.drawRectangle(x, y, w, h, ColorToInt(colorAddr));
    }

    @Override
    public void DrawRectangleGradientEx(long rectAddr, long c1Addr, long c2Addr, long c3Addr, long c4Addr) {
        int x = (int) mir_read_float(rectAddr);
        int y = (int) mir_read_float(rectAddr + 4);
        int w = (int) mir_read_float(rectAddr + 8);
        int h = (int) mir_read_float(rectAddr + 12);

        // RayguiBase provides : c1=TL, c2=BL, c3=BR, c4=TR
        // Backend: TL, TR, BL, BR
        backend.drawRectangleGradientEx(x, y, w, h, ColorToInt(c1Addr), // TL
                ColorToInt(c4Addr), // TR
                ColorToInt(c2Addr), // BL
                ColorToInt(c3Addr) // BR
        );
    }

    @Override
    public void DrawTextCodepoint(long _I0_font, int codepoint, long posAddr, float fontSize, long tintAddr) {
        float x = mir_read_float(posAddr);
        float y = mir_read_float(posAddr + 4);
        backend.drawTextCodepoint(x, y, codepoint, fontSize, ColorToInt(tintAddr), _I0_font);
    }

    @Override
    public void BeginDrawing() {
        // Snapshot edges for keyboard
        synchronized (keyLock) {
            for (int k = 0; k < KEY_CAP; k++) {
                keyDownFrame[k] = keyDownState[k];
                keyPressEdgeFrame[k] = (keyPressAcc[k] > 0);
                keyReleaseEdgeFrame[k] = (keyReleaseAcc[k] > 0);
                keyPressAcc[k] = 0;
                keyReleaseAcc[k] = 0;
            }
        }
        // Snapshot edges for mouse
        synchronized (mouseLock) {
            for (int b = 0; b < MOUSE_BUTTONS; b++) {
                mouseDownFrame[b] = mouseDownState[b];
                mousePressEdgeFrame[b] = (mousePressAcc[b] > 0);
                mouseReleaseEdgeFrame[b] = (mouseReleaseAcc[b] > 0);
                mousePressAcc[b] = 0;
                mouseReleaseAcc[b] = 0;
            }
        }
        backend.beginFrame();
    }

    @Override
    public void EndDrawing() {
        backend.endFrame();
    }

    @Override
    public int IsKeyDown(int key) {
        return (key >= 0 && key < KEY_CAP && keyDownFrame[key]) ? 1 : 0;
    }

    @Override
    public int IsKeyPressed(int key) {
        if (key < 0 || key >= KEY_CAP)
            return 0;
        return keyPressEdgeFrame[key] ? 1 : 0;
    }

    @Override
    public int IsMouseButtonDown(int b) {
        return (b >= 0 && b < MOUSE_BUTTONS && mouseDownFrame[b]) ? 1 : 0;
    }

    @Override
    public int IsMouseButtonPressed(int b) {
        if (b < 0 || b >= MOUSE_BUTTONS)
            return 0;
        return mousePressEdgeFrame[b] ? 1 : 0;
    }

    @Override
    public int IsMouseButtonReleased(int b) {
        if (b < 0 || b >= MOUSE_BUTTONS)
            return 0;
        return mouseReleaseEdgeFrame[b] ? 1 : 0;
    }

    @Override
    public int GetCharPressed() {
        synchronized (charQueue) {
            if (charQueue.isEmpty())
                return 0;
            return charQueue.remove(0);
        }
    }

    @Override
    public void GetMousePosition(long addr) {
        mir_write_float(addr, mouseX);
        mir_write_float(addr + 4, mouseY);
    }

    @Override
    public float GetMouseWheelMove() {
        return 0.0f;
    }

    @Override
    public void UnloadTexture(long textureAddr) {
        // Do nothing
    }

    @Override
    public void SetShapesTexture(long textureAddr, long rectAddr) {
        // Do nothing
    }

    @Override
    public int GetMaxCharWidth() {
        return backend.getMaxCharWidth();
    }

    @Override
    public int GetMaxCharHeight() {
        return backend.getMaxCharHeight();
    }

    // ====== Backend.InputSink : backend callbacks (Swing, etc.) ======

    @Override
    public void onKeyDown(int key) {
        if (key <= 0 || key >= KEY_CAP)
            return;
        synchronized (keyLock) {
            if (!keyDownState[key]) {
                keyDownState[key] = true;
                keyPressAcc[key]++;
            }
        }
    }

    @Override
    public void onKeyUp(int key) {
        if (key <= 0 || key >= KEY_CAP)
            return;
        synchronized (keyLock) {
            if (keyDownState[key]) {
                keyDownState[key] = false;
                keyReleaseAcc[key]++;
            }
        }
    }

    @Override
    public void onCharTyped(char c) {
        if (c < 0x20 && c != '\n' && c != '\t')
            return;
        synchronized (charQueue) {
            charQueue.add(c);
        }
    }

    @Override
    public void onMouseDown(int btn, int x, int y) {
        if (btn < 0 || btn >= MOUSE_BUTTONS)
            return;
        synchronized (mouseLock) {
            if (!mouseDownState[btn]) {
                mouseDownState[btn] = true;
                mousePressAcc[btn]++;
            }
        }
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void onMouseUp(int btn, int x, int y) {
        if (btn < 0 || btn >= MOUSE_BUTTONS)
            return;
        synchronized (mouseLock) {
            if (mouseDownState[btn]) {
                mouseDownState[btn] = false;
                mouseReleaseAcc[btn]++;
            }
        }
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void onMouseMove(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void onResize(int w, int h) {
        // nothing special logic-wise here; the surface is recreated in the backend
    }

    /*
     * =========================================== Java-friendly wrappers of the Raygui API ===========================================
     */

    public static final class Rect {
        public float x, y, w, h;

        public Rect(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    public static final class Vec2 {
        public float x, y;

        public Vec2() {
        }

        public Vec2(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final class RefInt {
        public int v;

        public RefInt(int v) {
            this.v = v;
        }
    }

    public static final class RefBool {
        public boolean v;

        public RefBool(boolean v) {
            this.v = v;
        }
    }

    public static final class RefString {
        /** Null-terminated UTF-16 (Java) buffer: always guarantees a terminating '\0'. */
        public final char[] buf;

        public RefString(int capacity) {
            this.buf = new char[Math.max(2, capacity)];
            this.buf[0] = '\0';
        }

        public RefString(String init, int capacity) {
            this(Math.max(capacity, 2));
            set(init);
        }

        public RefString(String init) {
            int cap = (init != null ? init.length() : 0);
            cap = Math.max(64, cap + 64);
            this.buf = new char[cap];
            set(init);
        }

        public int length() {
            for (int i = 0; i < buf.length; i++) {
                if (buf[i] == '\0')
                    return i;
            }
            buf[buf.length - 1] = '\0';
            return buf.length - 1;
        }

        /** Total capacity (excluding implicit null-terminator). */
        public int capacity() {
            return buf.length;
        }

        /** Returns the Java string (without the '\0' and the unused part). */
        public String get() {
            return new String(buf, 0, length());
        }

        @Override
        public String toString() {
            return get();
        }

        /** Replaces the contents with s (truncated if necessary) and adds a '\0' after it. */
        public void set(String s) {
            if (s == null) {
                buf[0] = '\0';
                return;
            }
            int n = Math.min(s.length(), buf.length - 1);
            s.getChars(0, n, buf, 0);
            buf[n] = '\0';
            // Clean up the rest ?
            // java.util.Arrays.fill(buf, n + 1, buf.length, '\0');
        }

        /** Clears logical content. */
        public void clear() {
            buf[0] = '\0';
        }

        /** Append (truncated if capacity is reached). Returns the number of tanks added. */
        public int append(String s) {
            if (s == null || s.isEmpty())
                return 0;
            int start = length();
            if (start >= buf.length - 1)
                return 0;
            int can = Math.min(s.length(), (buf.length - 1) - start);
            s.getChars(0, can, buf, start);
            buf[start + can] = '\0';
            return can;
        }

        /** Direct access if you need to edit character by character. */
        public char charAt(int i) {
            if (i < 0 || i >= length())
                throw new IndexOutOfBoundsException();
            return buf[i];
        }

        public void setCharAt(int i, char c) {
            if (i < 0 || i >= buf.length - 1)
                throw new IndexOutOfBoundsException();
            buf[i] = c;
            if (c == '\0') {
            } else if (i == length()) {
                int next = i + 1;
                if (next < buf.length)
                    buf[next] = '\0';
            }
        }
    }

    // ==== Color utils ====
    public static int RGBA(int r, int g, int b, int a) {
        return ((r & 0xFF) << 24) | ((g & 0xFF) << 16) | ((b & 0xFF) << 8) | (a & 0xFF);
    }

    public static int fade(int rgba, float alpha) {
        int a = Math.max(0, Math.min(255, Math.round((rgba & 0xFF) * alpha)));
        return (rgba & 0xFFFFFF00) | a;
    }

    // ==== Stack : save, restore ====
    private int spSave() {
        return mir_get_stack_position();
    }

    private void spRestore(int sp) {
        mir_set_stack_position(sp);
    }

    // ==== Helpers to read / write in memory ====
    private long stackRect(Rect r) {
        long p = mir_allocate(16);
        mir_write_float(p, r.x);
        mir_write_float(p + 4, r.y);
        mir_write_float(p + 8, r.w);
        mir_write_float(p + 12, r.h);
        return p;
    }

    private long stackColor(int rgba) {
        long p = mir_allocate(4);
        int r = (rgba >>> 24) & 0xFF, g = (rgba >>> 16) & 0xFF, b = (rgba >>> 8) & 0xFF, a = rgba & 0xFF;
        mir_write_ubyte(p, r);
        mir_write_ubyte(p + 1, g);
        mir_write_ubyte(p + 2, b);
        mir_write_ubyte(p + 3, a);
        return p;
    }

    private long stackInt(int v) {
        long p = mir_allocate(4);
        mir_write_int(p, v);
        return p;
    }

    private long stackVec2(Vec2 v) {
        long p = mir_allocate(8);
        mir_write_float(p, v.x);
        mir_write_float(p + 4, v.y);
        return p;
    }

    private long stackCharBuffer(RefString rs, int maxLen) {
        long p = mir_allocate(maxLen + 1);
        int n = Math.min(rs.buf.length, maxLen);
        for (int i = 0; i < n; i++)
            mir_write_ubyte(p + i, (byte) rs.buf[i]);
        mir_write_ubyte(p + n, 0);
        return p;
    }

    private void readBackCharBuffer(long addr, RefString out, int maxLen) {
        int n = Math.min(out.buf.length, maxLen);
        for (int i = 0; i < n; i++) {
            int b = mir_read_ubyte(addr + i);
            if (b == 0) {
                for (int k = i; k < n; k++)
                    out.buf[k] = '\0';
                break;
            }
            out.buf[i] = (char) (b & 0xFF);
        }
    }

    private long cStringConst(String s) {
        // Reusable “const” strings (Runtime internal map)
        return mir_get_string_ptr(s != null ? s : "");
    }

    private long cStringTemp(String s) {
        // Temporary strings (on the stack)
        if (s == null)
            s = "";
        byte[] bytes = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        long p = mir_allocate(bytes.length + 1);
        writeCStringInMemoryFromJavaString(p, bytes);
        return p;
    }

    // ==== Wrappers for windows and drawing ====
    public void initWindow(int w, int h, String title) {
        int sp = spSave();
        try {
            InitWindow(w, h, cStringConst(title));
        } finally {
            spRestore(sp);
        }
    }

    public void beginDrawing() {
        BeginDrawing();
    }

    public void endDrawing() {
        EndDrawing();
    }

    public int getScreenWidth() {
        return GetScreenWidth();
    }

    public int getScreenHeight() {
        return GetScreenHeight();
    }

    public void clearBackground(int rgba) {
        int sp = spSave();
        try {
            ClearBackground(stackColor(rgba));
        } finally {
            spRestore(sp);
        }
    }

    public void drawRectangle(int x, int y, int w, int h, int rgba) {
        int sp = spSave();
        try {
            DrawRectangle(x, y, w, h, stackColor(rgba));
        } finally {
            spRestore(sp);
        }
    }

    public void drawRectangleGradientEx(Rect r, int c00, int c10, int c01, int c11) {
        int sp = spSave();
        try {
            DrawRectangleGradientEx(stackRect(r), stackColor(c00), stackColor(c10), stackColor(c01), stackColor(c11));
        } finally {
            spRestore(sp);
        }
    }

    public void drawText(String s, float x, float y, float size, int tint) {
        if (s == null)
            return;
        float adv = Math.max(1, GetMaxCharWidth());
        for (int i = 0; i < s.length();) {
            int cp = s.codePointAt(i);
            drawTextCodepoint(cp, x, y, size, tint);
            x += adv;
            i += Character.charCount(cp);
        }
    }

    public void drawTextCodepoint(int codepoint, float x, float y, float size, int tint) {
        int sp = spSave();
        try {
            long pos = mir_allocate(8);
            mir_write_float(pos, x);
            mir_write_float(pos + 4, y);
            DrawTextCodepoint(0L, codepoint, pos, size, stackColor(tint));
        } finally {
            spRestore(sp);
        }
    }

    // ==== Wrappers raygui 3.5 ====

    public void guiSetStyle(int control, int property, int value) {
        GuiSetStyle(control, property, value);
    }

    public int guiGetStyle(int control, int property) {
        return GuiGetStyle(control, property);
    }

    public boolean guiWindowBox(Rect r, String title) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (title != null) ? cStringConst(title) : 0L;
            return GuiWindowBox(pRect, pTxt) == 1;
        } finally {
            spRestore(sp);
        }
    }

    public void guiDummyRec(Rect r, String text) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            GuiDummyRec(pRect, pTxt);
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiButton(Rect r, String text) {
        int sp = spSave();
        try {
            return GuiButton(stackRect(r), cStringConst(text)) == 1;
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiLabelButton(Rect r, String text) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            return GuiLabelButton(pRect, pTxt) == 1;
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiCheckBox(Rect r, String text, boolean checked) {
        int sp = spSave();
        try {
            return GuiCheckBox(stackRect(r), cStringConst(text), checked ? 1 : 0) != 0;
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiTextBox(Rect r, RefString buf, int maxLen, boolean edit) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pBuf = stackCharBuffer(buf, maxLen);
            int ret = GuiTextBox(pRect, pBuf, maxLen, edit ? 1 : 0);
            readBackCharBuffer(pBuf, buf, maxLen);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiSpinner(Rect r, String text, RefInt value, int min, int max, boolean edit) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pText = (text != null) ? cStringConst(text) : 0;
            long pVal = stackInt(value.v);
            int ret = GuiSpinner(pRect, pText, pVal, min, max, edit ? 1 : 0);
            value.v = mir_read_int(pVal);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiValueBox(Rect r, String text, RefInt value, int min, int max, boolean edit) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pText = (text != null) ? cStringConst(text) : 0;
            long pVal = stackInt(value.v);
            int ret = GuiValueBox(pRect, pText, pVal, min, max, edit ? 1 : 0);
            value.v = mir_read_int(pVal);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public int guiComboBox(Rect r, String items, int active) {
        int sp = spSave();
        try {
            return GuiComboBox(stackRect(r), cStringConst(items), active);
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiDropdownBox(Rect r, String items, RefInt active, boolean edit) {
        int sp = spSave();
        try {
            long pAct = stackInt(active.v);
            int ret = GuiDropdownBox(stackRect(r), cStringConst(items), pAct, edit ? 1 : 0);
            active.v = mir_read_int(pAct);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public float guiSlider(Rect r, String left, String right, float value, float min, float max) {
        int sp = spSave();
        try {
            long pL = (left != null) ? cStringConst(left) : 0;
            long pR = (right != null) ? cStringConst(right) : 0;
            return GuiSlider(stackRect(r), pL, pR, value, min, max);
        } finally {
            spRestore(sp);
        }
    }

    public float guiSliderBar(Rect r, String left, String right, float value, float min, float max) {
        int sp = spSave();
        try {
            long pL = (left != null) ? cStringConst(left) : 0;
            long pR = (right != null) ? cStringConst(right) : 0;
            return GuiSliderBar(stackRect(r), pL, pR, value, min, max);
        } finally {
            spRestore(sp);
        }
    }

    public float guiProgressBar(Rect r, String left, String right, float value, float min, float max) {
        int sp = spSave();
        try {
            long pL = (left != null) ? cStringConst(left) : 0;
            long pR = (right != null) ? cStringConst(right) : 0;
            return GuiProgressBar(stackRect(r), pL, pR, value, min, max);
        } finally {
            spRestore(sp);
        }
    }

    public void guiGroupBox(Rect r, String text) {
        int sp = spSave();
        try {
            GuiGroupBox(stackRect(r), text != null ? cStringConst(text) : 0);
        } finally {
            spRestore(sp);
        }
    }

    public void guiPanel(Rect r, String text) {
        int sp = spSave();
        try {
            GuiPanel(stackRect(r), text != null ? cStringConst(text) : 0);
        } finally {
            spRestore(sp);
        }
    }

    public void guiStatusBar(Rect r, String text) {
        int sp = spSave();
        try {
            GuiStatusBar(stackRect(r), text != null ? cStringConst(text) : 0);
        } finally {
            spRestore(sp);
        }
    }

    public Rect guiScrollPanel(Rect r, String text, Rect content, Vec2 scroll) {
        int sp = spSave();
        try {
            long pViewOut = mir_allocate(16);
            long pView = stackRect(r);
            long pText = (text != null) ? cStringConst(text) : 0;
            long pContent = stackRect(content);
            long pScroll = stackVec2(scroll);

            GuiScrollPanel(pViewOut, pView, pText, pContent, pScroll);

            // out-params
            scroll.x = mir_read_float(pScroll);
            scroll.y = mir_read_float(pScroll + 4);

            return new Rect(mir_read_float(pViewOut), mir_read_float(pViewOut + 4), mir_read_float(pViewOut + 8), mir_read_float(pViewOut + 12));
        } finally {
            spRestore(sp);
        }
    }

    public String guiIconText(int iconId, String text) {
        return "#" + iconId + "#" + (text != null ? text : "");
    }

    public void guiLabel(Rect r, String text) {
        int sp = spSave();
        try {
            GuiLabel(stackRect(r), text != null ? cStringConst(text) : 0L);
        } finally {
            spRestore(sp);
        }
    }

    public int guiListView(Rect r, String itemsSemicolon, RefInt scrollIndex, int active) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pText = cStringConst(itemsSemicolon != null ? itemsSemicolon : "");
            long pScroll = stackInt(scrollIndex != null ? scrollIndex.v : 0);
            int ret = GuiListView(pRect, pText, pScroll, active);
            if (scrollIndex != null)
                scrollIndex.v = mir_read_int(pScroll);
            return ret; // active index (or -1)
        } finally {
            spRestore(sp);
        }
    }

    public int guiListViewEx(Rect r, String[] items, int count, RefInt focus, RefInt scrollIndex, int active) {
        int sp = spSave();
        try {
            if (items == null)
                items = new String[0];
            count = Math.min(count, items.length);

            long pRect = stackRect(r);

            // Construct char** (table of pointers to c-strings)
            long pList = mir_allocate((long) count * 8);
            for (int i = 0; i < count; i++) {
                long pi = cStringConst(items[i] != null ? items[i] : "");
                mir_write_long(pList + (long) i * 8, pi);
            }

            long pFocus = stackInt(focus != null ? focus.v : -1);
            long pScroll = stackInt(scrollIndex != null ? scrollIndex.v : 0);

            int ret = GuiListViewEx(pRect, pList, count, pFocus, pScroll, active);

            if (focus != null)
                focus.v = mir_read_int(pFocus);
            if (scrollIndex != null)
                scrollIndex.v = mir_read_int(pScroll);
            return ret; // active index (or -1)
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiToggle(Rect r, String text, boolean active) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            int ret = GuiToggle(pRect, pTxt, active ? 1 : 0);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public int guiToggleGroup(Rect r, String textMultiline, int active) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = cStringConst(textMultiline != null ? textMultiline : "");
            return GuiToggleGroup(pRect, pTxt, active);
        } finally {
            spRestore(sp);
        }
    }

    public boolean guiTextBoxMulti(Rect r, RefString buf, int maxLen, boolean edit) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pBuf = stackCharBuffer(buf, maxLen);
            int ret = GuiTextBoxMulti(pRect, pBuf, maxLen, edit ? 1 : 0);
            readBackCharBuffer(pBuf, buf, maxLen);
            return ret == 1;
        } finally {
            spRestore(sp);
        }
    }

    public int guiColorPicker(Rect r, String text, int colorRgba) {
        int sp = spSave();
        try {
            long ret = mir_allocate(4); // Color (4 ubytes RGBA)
            long pRect = stackRect(r);
            long pTxt = (text != null) ? mir_get_string_ptr(text) : 0L;
            long pCol = stackColor(colorRgba); // initial color

            GuiColorPicker(ret, pRect, pTxt, pCol);

            int rgba = ColorToInt(ret);
            return rgba;
        } finally {
            spRestore(sp);
        }
    }

    public float guiColorBarAlpha(Rect r, String text, float alpha) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            return GuiColorBarAlpha(pRect, pTxt, alpha);
        } finally {
            spRestore(sp);
        }
    }

    public int guiColorPanel(Rect r, String text, int colorRgba) {
        int sp = spSave();
        try {
            long pRet = mir_allocate(4);
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            long pCol = stackColor(colorRgba);
            GuiColorPanel(pRet, pRect, pTxt, pCol);
            return ColorToInt(pRet);
        } finally {
            spRestore(sp);
        }
    }

    public float guiColorBarHue(Rect r, String text, float hue) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTxt = (text != null) ? cStringConst(text) : 0L;
            return GuiColorBarHue(pRect, pTxt, hue);
        } finally {
            spRestore(sp);
        }
    }

    public void guiDrawIcon(int iconId, int x, int y, int pixelSize, int tintRgba) {
        int sp = spSave();
        try {
            long pCol = stackColor(tintRgba);
            GuiDrawIcon(iconId, x, y, pixelSize, pCol);
        } finally {
            spRestore(sp);
        }
    }

    public Vec2 guiGrid(Rect r, String text, float spacing, int subdivs) {
        int sp = spSave();
        try {
            long ret = mir_allocate(8); // Vec2 (x,y) -> 2 floats
            long pRect = stackRect(r);
            long pTxt = (text != null) ? mir_get_string_ptr(text) : 0L;

            GuiGrid(ret, pRect, pTxt, spacing, subdivs);

            float x = mir_read_float(ret);
            float y = mir_read_float(ret + 4);
            return new Vec2(x, y);
        } finally {
            spRestore(sp);
        }
    }

    public int guiMessageBox(Rect r, String title, String message, String buttons) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTitle = (title != null) ? cStringConst(title) : 0L;
            long pMsg = (message != null) ? cStringConst(message) : 0L;
            long pBtns = (buttons != null) ? cStringConst(buttons) : 0L;
            return GuiMessageBox(pRect, pTitle, pMsg, pBtns); // index bouton (0..n-1) ou -1
        } finally {
            spRestore(sp);
        }
    }

    public int guiTextInputBox(Rect r, String title, String message, String buttons, RefString textBuf, int maxLen, RefBool secretView) {
        int sp = spSave();
        try {
            long pRect = stackRect(r);
            long pTitle = (title != null) ? cStringConst(title) : 0L;
            long pMsg = (message != null) ? cStringConst(message) : 0L;
            long pBtns = (buttons != null) ? cStringConst(buttons) : 0L;
            long pText = stackCharBuffer(textBuf, maxLen);
            long pSecret = (secretView != null) ? stackInt(secretView.v ? 1 : 0) : 0L;

            int res = GuiTextInputBox(pRect, pTitle, pMsg, pBtns, pText, maxLen, pSecret);

            readBackCharBuffer(pText, textBuf, maxLen);
            if (secretView != null)
                secretView.v = (mir_read_int(pSecret) != 0);

            return res; // button clicked (0..n-1) or -1
        } finally {
            spRestore(sp);
        }
    }

    // State / lock
    public void guiSetState(int st) {
        GuiSetState(st);
    }

    public void guiLock() {
        GuiLock();
    }

    public void guiUnlock() {
        GuiUnlock();
    }

    public boolean isKeyPressed(int k) {
        return IsKeyPressed(k) == 1;
    }

    public boolean isKeyDown(int k) {
        return IsKeyDown(k) == 1;
    }

    public boolean isMouseButtonPressed(int b) {
        return IsMouseButtonPressed(b) == 1;
    }

    public boolean isMouseButtonDown(int b) {
        return IsMouseButtonDown(b) == 1;
    }

    public int getCharPressed() {
        return GetCharPressed();
    }

    public Vec2 getMousePosition() {
        int sp = spSave();
        try {
            long p = mir_allocate(8);
            GetMousePosition(p);
            return new Vec2(mir_read_float(p), mir_read_float(p + 4));
        } finally {
            spRestore(sp);
        }
    }

   

}
