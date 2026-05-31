package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

import util.LanguageManager;

public class HelpController {

    @FXML
    private TextArea addHelpText;

    @FXML
    private TextArea searchHelpText;

    @FXML
    private TextArea dashboardHelpText;

    @FXML
    private TextArea shortcutHelpText;

    @FXML
    private Tab tabAdd;

    @FXML
    private Tab tabSearch;

    @FXML
    private Tab tabDashboard;

    @FXML
    private Tab tabShortcuts;

    public void initialize(){
        loadTexts();

        LanguageManager.currentLocaleProperty()
                .addListener(
                    (
                        observable,
                        oldLocale,
                        newLocale
                    ) -> loadTexts()
                );
    }

    private void loadTexts(){
        tabAdd.setText(
            LanguageManager.getText(
                "help.tab.add"
            )
        );

        tabSearch.setText(
            LanguageManager.getText(
                "help.tab.search"
            )
        );

        tabDashboard.setText(
            LanguageManager.getText(
                "help.tab.dashboard"
            )
        );
        
        tabShortcuts.setText(
            LanguageManager.getText(
                "help.tab.shortcuts"
            )
        );

        addHelpText.setText(
            LanguageManager.getText(
                "help.add"
            )
        );

        searchHelpText.setText(
            LanguageManager.getText(
                "help.search"
            )
        );

        dashboardHelpText.setText(
            LanguageManager.getText(
                "help.dashboard"
            )
        );

        shortcutHelpText.setText(
            LanguageManager.getText(
                "help.shortcuts"
            )
        );

    }
}