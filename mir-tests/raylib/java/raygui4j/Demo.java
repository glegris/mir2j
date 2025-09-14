package raygui4j;

public class Demo {

    public void start(Backend backend) {

        Raygui gui = new Raygui(backend);

        final int screenWidth = 690;
        final int screenHeight = 560;

        gui.initWindow(screenWidth, screenHeight, "raygui - controls test suite (Java)");
        try {
            gui.guiSetStyle(Raygui.DEFAULT, Raygui.TEXT_SIZE, 16);
        } catch (Throwable ignore) {
        }

        int dropdownBox000Active = 0;
        boolean dropDown000EditMode = false;

        int dropdownBox001Active = 0;
        boolean dropDown001EditMode = false;

        Raygui.RefInt spinner001Value = new Raygui.RefInt(0);
        boolean spinnerEditMode = false;

        Raygui.RefInt valueBox002Value = new Raygui.RefInt(0);
        boolean valueBoxEditMode = false;

        Raygui.RefString textBoxText = new Raygui.RefString("Text box");
        boolean textBoxEditMode = false;

        Raygui.RefInt listViewScrollIndex = new Raygui.RefInt(0);
        int listViewActive = -1;

        Raygui.RefInt listViewExScrollIndex = new Raygui.RefInt(0);
        int listViewExActive = 2;
        Raygui.RefInt listViewExFocus = new Raygui.RefInt(-1);
        String[] listViewExList = { "This", "is", "a", "list view", "with", "disable", "elements", "amazing!" };

        Raygui.RefString multiTextBoxText = new Raygui.RefString("Multi text box");
        boolean multiTextBoxEditMode = false;

        int colorPickerValue = Raygui.RED;

        Raygui.RefInt sliderValue = new Raygui.RefInt(50);
        Raygui.RefInt sliderBarValue = new Raygui.RefInt(60);
        float progressValue = 0.4f;
        boolean forceSquaredChecked = false;

        float alphaValue = 0.5f;

        int comboBoxActive = 1;

        int toggleGroupActive = 0;

        boolean showWindow = false; // for GuiWindowBox
        boolean toggle001 = false; // for GuiToggle

        Raygui.Vec2 viewScroll = new Raygui.Vec2(0, 0);

        boolean exitWindow = false;
        boolean showMessageBox = false;

        Raygui.RefString textInput = new Raygui.RefString("");
        boolean showTextInputBox = false;

        Raygui.RefString textInputFileName = new Raygui.RefString("");

        while (!exitWindow) {

            if (gui.isKeyPressed(Raygui.KEY_ESCAPE))
                showMessageBox = !showMessageBox;
            if (gui.isKeyDown(Raygui.KEY_LEFT_CONTROL) && gui.isKeyPressed(Raygui.KEY_S))
                showTextInputBox = true;

            gui.beginDrawing();

            try {
                int bg = gui.guiGetStyle(Raygui.DEFAULT, Raygui.BACKGROUND_COLOR);
                gui.clearBackground(bg);
            } catch (Throwable t) {
                gui.clearBackground(Raygui.RAYWHITE);
            }

            if (dropDown000EditMode || dropDown001EditMode)
                gui.guiLock();
            else
                gui.guiUnlock();

            // ----- Column 1 -----
            gui.guiSetStyle(Raygui.CHECKBOX, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_RIGHT);
            forceSquaredChecked = gui.guiCheckBox(new Raygui.Rect(25, 108, 15, 15), "FORCE CHECK!", forceSquaredChecked);

            gui.guiSetStyle(Raygui.TEXTBOX, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_CENTER);
            if (gui.guiSpinner(new Raygui.Rect(25, 135, 125, 30), null, spinner001Value, 0, 100, spinnerEditMode))
                spinnerEditMode = !spinnerEditMode;

            if (gui.guiValueBox(new Raygui.Rect(25, 175, 125, 30), null, valueBox002Value, 0, 100, valueBoxEditMode))
                valueBoxEditMode = !valueBoxEditMode;

            gui.guiSetStyle(Raygui.TEXTBOX, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_LEFT);
            if (gui.guiTextBox(new Raygui.Rect(25, 215, 125, 30), textBoxText, 64, textBoxEditMode))
                textBoxEditMode = !textBoxEditMode;

            gui.guiSetStyle(Raygui.BUTTON, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_CENTER);
            if (gui.guiButton(new Raygui.Rect(25, 255, 125, 30), gui.guiIconText(Raygui.ICON_FILE_SAVE, "Save File"))) {
                showTextInputBox = true;
            }

            gui.guiGroupBox(new Raygui.Rect(25, 300, 125, 150), "STATES");
            gui.guiSetState(Raygui.STATE_NORMAL);
            gui.guiButton(new Raygui.Rect(30, 310, 115, 30), "NORMAL");
            gui.guiSetState(Raygui.STATE_FOCUSED);
            gui.guiButton(new Raygui.Rect(30, 345, 115, 30), "FOCUSED");
            gui.guiSetState(Raygui.STATE_PRESSED);
            gui.guiButton(new Raygui.Rect(30, 380, 115, 30), "#15#PRESSED");
            gui.guiSetState(Raygui.STATE_DISABLED);
            gui.guiButton(new Raygui.Rect(30, 415, 115, 30), "DISABLED");
            gui.guiSetState(Raygui.STATE_NORMAL);

            toggle001 = gui.guiToggle(new Raygui.Rect(25, 495, 125, 30), gui.guiIconText(Raygui.ICON_CURSOR_HAND, "Toggle me"), toggle001);

            comboBoxActive = gui.guiComboBox(new Raygui.Rect(25, 460, 125, 30), "ONE;TWO;THREE;FOUR", comboBoxActive);

            // Dropdowns
            gui.guiSetStyle(Raygui.DROPDOWNBOX, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_LEFT);
            if (gui.guiDropdownBox(new Raygui.Rect(25, 65, 125, 30), "#01#ONE;#02#TWO;#03#THREE;#04#FOUR", new Raygui.RefInt(dropdownBox001Active), dropDown001EditMode)) {
                dropDown001EditMode = !dropDown001EditMode;
            }

            gui.guiSetStyle(Raygui.DROPDOWNBOX, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_CENTER);
            if (gui.guiDropdownBox(new Raygui.Rect(25, 25, 125, 30), "ONE;TWO;THREE", new Raygui.RefInt(dropdownBox000Active), dropDown000EditMode)) {
                dropDown000EditMode = !dropDown000EditMode;
            }

            // ----- Column 2 -----
            listViewActive = gui.guiListView(new Raygui.Rect(165, 25, 140, 140), "Charmander;Bulbasaur;#18#Squirtel;Pikachu;Eevee;Pidgey", listViewScrollIndex, listViewActive);

            listViewExActive = gui.guiListViewEx(new Raygui.Rect(165, 180, 140, 200), listViewExList, listViewExList.length, listViewExFocus, listViewExScrollIndex,
                    listViewExActive);

            toggleGroupActive = gui.guiToggleGroup(new Raygui.Rect(165, 400, 140, 25), "#1#ONE\n#3#TWO\n#8#THREE\n#23#", toggleGroupActive);

            gui.guiSetStyle(Raygui.LABEL, Raygui.TEXT_ALIGNMENT, Raygui.TEXT_ALIGN_CENTER);
            if (gui.guiLabelButton(new Raygui.Rect(165, 510, 125, 20), "Show Window")) {
                showWindow = true;
            }

            // ----- Column 3 -----
            if (gui.guiTextBoxMulti(new Raygui.Rect(320, 25, 225, 140), multiTextBoxText, 256, multiTextBoxEditMode))
                multiTextBoxEditMode = !multiTextBoxEditMode;

            colorPickerValue = gui.guiColorPicker(new Raygui.Rect(320, 185, 196, 192), null, colorPickerValue);

            sliderValue.v = Math.round(gui.guiSlider(new Raygui.Rect(355, 400, 165, 20), "TEST", String.format("%2.2f", (float) sliderValue.v), sliderValue.v, -50, 100));
            sliderBarValue.v = Math.round(gui.guiSliderBar(new Raygui.Rect(320, 430, 200, 20), null, Integer.toString(sliderBarValue.v), sliderBarValue.v, 0, 100));
            progressValue = gui.guiProgressBar(new Raygui.Rect(320, 460, 200, 20), null, null, progressValue, 0f, 1f);

            // ----- Column 4 -----
            Raygui.Rect view = gui.guiScrollPanel(new Raygui.Rect(560, 25, 100, 160), null, new Raygui.Rect(560, 25, 200, 400), viewScroll);

            gui.guiPanel(new Raygui.Rect(560, 25 + 180, 100, 160), "Panel Info");

            // Dummy rec : simple “mute” placeholder
            gui.guiDummyRec(new Raygui.Rect(560, 25 + 180 + 160 + 5, 100, 18), "dummy");

            gui.guiGrid(new Raygui.Rect(560, 25 + 180 + 180, 100, 120), null, 20f, 2);

            gui.guiStatusBar(new Raygui.Rect(0, gui.getScreenHeight() - 20f, gui.getScreenWidth(), 20), "This is a status bar");

            alphaValue = gui.guiColorBarAlpha(new Raygui.Rect(320, 490, 200, 30), null, alphaValue);

            // Some icons rendered directly
            gui.guiDrawIcon(Raygui.ICON_CAMERA, 560, 515, 1, Raygui.DARKGRAY);
            gui.guiDrawIcon(Raygui.ICON_BOX_CENTER, 580, 515, 1, Raygui.DARKGRAY);
            gui.guiDrawIcon(Raygui.ICON_FILE_CUT, 600, 515, 1, Raygui.DARKGRAY);
            gui.guiDrawIcon(Raygui.ICON_CRACK_POINTS, 620, 515, 1, Raygui.DARKGRAY);

            // Mini Window (WindowBox)
            if (showWindow) {
                // If the cross (X) is clicked, the call returns true -> it is hidden
                if (gui.guiWindowBox(new Raygui.Rect(390, 25, 200, 110), "Mini Window")) {
                    showWindow = false;
                } else {
                    gui.guiLabel(new Raygui.Rect(400, 60, 200, 20), "Hello from WindowBox!");
                    gui.guiDrawIcon(Raygui.ICON_INFO, 400, 90, 2, Raygui.BLUE);
                }
            }

            // Overlays
            if (showMessageBox) {
                gui.drawRectangle(0, 0, gui.getScreenWidth(), gui.getScreenHeight(), Raygui.fade(Raygui.RAYWHITE, 0.8f));
                int result = gui.guiMessageBox(new Raygui.Rect(gui.getScreenWidth() / 2f - 125, gui.getScreenHeight() / 2f - 50, 250, 100),
                        gui.guiIconText(Raygui.ICON_EXIT, "Close Window"), "Do you really want to exit?", "Yes;No");
                if (result == 0 || result == 2)
                    showMessageBox = false;
                else if (result == 1)
                    exitWindow = true;
            }

            if (showTextInputBox) {
                gui.drawRectangle(0, 0, gui.getScreenWidth(), gui.getScreenHeight(), Raygui.fade(Raygui.RAYWHITE, 0.8f));
                int result = gui.guiTextInputBox(new Raygui.Rect(gui.getScreenWidth() / 2f - 120, gui.getScreenHeight() / 2f - 60, 240, 140), "Save",
                        gui.guiIconText(Raygui.ICON_FILE_SAVE, "Save file as..."), "Ok;Cancel", textInput, 255, null);
                if (result == 1) {
                    textInputFileName = textInput;
                    System.out.println("Save file: " + textInputFileName);
                }
                if (result == 0 || result == 1 || result == 2) {
                    showTextInputBox = false;
                }
            }

            gui.endDrawing();

            try {
                Thread.sleep(16);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static void main(String[] args) {
        SwingBackend backend = new SwingBackend();
        new Demo().start(backend);
    }

}
