package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.Main;

public class MainController {
    @FXML private Label statusLabel;
    private Main main;

    public void setMainApp(Main main) { this.main = main; }

    private void openWindow(String fxml, String title) {
        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/" + fxml))));
            stage.setTitle(title);
            stage.initOwner(main.getPrimaryStage());
            stage.showAndWait();
        } catch(Exception e) { statusLabel.setText("Error"); }
    }

    @FXML private void handleExit() { System.exit(0); }
    @FXML private void handleHelp() { openWindow("Help.fxml", "Help"); }
    @FXML private void handleAddAddress() { openWindow("AddAddress.fxml", "Add Address"); }
    @FXML private void handleSearch() { openWindow("SearchAddress.fxml", "Search"); }
    @FXML private void handleDashboard() { statusLabel.setText("Dashboard"); }
    public void setStatus(String s) { statusLabel.setText(s); }
}
