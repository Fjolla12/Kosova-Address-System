package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
            BorderPane root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Kosova Address System");
            primaryStage.show();
            ((MainController)loader.getController()).setMainApp(this);
        } catch(Exception e) { e.printStackTrace(); }
    }
    public static void main(String[] args) { launch(args); }
    public Stage getPrimaryStage() { return primaryStage; }
}
