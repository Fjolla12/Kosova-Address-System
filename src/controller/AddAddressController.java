package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddAddressController {
    @FXML private TextField cityField, streetField, numberField, postalCodeField;
    private Stage stage;
    private Label status;

    public void setDialogStage(Stage s) { stage = s; }
    public void setStatusLabel(Label l) { status = l; }

    @FXML private void handleSave() {
        if(cityField.getText().isEmpty() || streetField.getText().isEmpty()) {
            if(status != null) status.setText("Error: Qyteti dhe Rruga required!");
            return;
        }
        // AddressService.addAddress(cityField.getText(), streetField.getText(), numberField.getText(), postalCodeField.getText());
        if(status != null) status.setText("Saved!");
        stage.close();
    }
    @FXML private void handleCancel() { stage.close(); }
}