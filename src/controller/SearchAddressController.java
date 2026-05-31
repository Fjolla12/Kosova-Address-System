package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchAddressController {
    @FXML private TextField searchField;
    @FXML private TableView<?> resultsTable;
    @FXML private TableColumn<?,?> cityColumn, streetColumn, numberColumn, postalCodeColumn;

    @FXML private void handleSearch() {
        String text = searchField.getText();
        if(!text.isEmpty()) {
            // AddressService.searchAddress(text);
            System.out.println("Searching: " + text);
        }
    }
}