module kosova.address.system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml;
    opens util to javafx.fxml;

    exports application;
    exports controller;
}
