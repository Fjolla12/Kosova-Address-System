package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import util.FocusManager;

public class SearchAddressController {
    @FXML private TextField searchField;
    @FXML private TableView<?> resultsTable;
    @FXML private TableColumn<?,?> cityColumn, streetColumn, numberColumn, postalCodeColumn;
    @FXML
public void initialize() {

    FocusManager.enableTabNavigation(
            searchField
    );

    Platform.runLater(() ->
            FocusManager.setInitialFocus(searchField));
}
    @FXML private void handleSearch() {
        String text = searchField.getText();
        if(!text.isEmpty()) {
            // AddressService.searchAddress(text);
            System.out.println("Searching: " + text);
        }
    }
}
