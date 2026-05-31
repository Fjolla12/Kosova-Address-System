package util;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination
public class ShortcutManager {

    public static void applyShortcuts(
            Scene scene,
            Runnable saveAction,
            Runnable searchAction,
            Runnable exitAction) {

        scene.setOnKeyPressed(event -> {

            if (new KeyCodeCombination(
                    KeyCode.S,
                    KeyCombination.CONTROL_DOWN)
                    .match(event)) {

                saveAction.run();
                event.consume();
            }

            if (new KeyCodeCombination(
                    KeyCode.F,
                    KeyCombination.CONTROL_DOWN)
                    .match(event)) {

                searchAction.run();
                event.consume();
            }

            if (new KeyCodeCombination(
                    KeyCode.E,
                    KeyCombination.CONTROL_DOWN)
                    .match(event)) {

                exitAction.run();
                event.consume();
            }
        });
    }
}
