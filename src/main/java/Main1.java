import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));

            // Hap dritaren me rezolucionin bazë responsive
            Scene scene = new Scene(root, 1270, 770);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sistemi i Adresave të Kosovës");

            // KJO E BËN TË HAPET DIREKT MAXIMIZE
            primaryStage.setMaximized(true);

            primaryStage.setResizable(true);
            primaryStage.show();

        } catch(Exception e) {
            System.out.println("Gabim gjatë nisjes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}