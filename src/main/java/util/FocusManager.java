package util;

import javafx.scene.control.Control;

public class FocusManager {

    public static void enableTabNavigation(Control... controls) {

        for (Control control : controls) {
            control.setFocusTraversable(true);
        }
    }

    public static void setInitialFocus(Control control) {

        control.requestFocus();
    }
}
