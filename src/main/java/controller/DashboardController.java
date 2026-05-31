package controller;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DashboardController {

    @FXML private ScrollPane contentScrollPane;
    @FXML private VBox dashboardHome;

    @FXML private Button btnPaneli, btnRegjistrimet, btnKerkimet, btnHarta, btnCilesimet, btnLogout;

    @FXML private ImageView iconPaneli, iconRegjistrimet, iconKerkimet, iconHarta, iconCilesimet, iconLogout;

    @FXML private LineChart<String, Number> lineChart;
    @FXML private PieChart pieChart;
    @FXML private BarChart<String, Number> barChart;

    @FXML private ImageView logoCard1, logoCard2, logoCard3, logoCard4;
    @FXML private Label lblTotaliAdresave;
    @FXML private Label lblQyteteAktive;

    @FXML private TableView<AddressRecord> tableView;
    @FXML private TableColumn<AddressRecord, Integer> colId;
    @FXML private TableColumn<AddressRecord, String> colQyteti;
    @FXML private TableColumn<AddressRecord, String> colRruga;
    @FXML private TableColumn<AddressRecord, String> colNumri;
    @FXML private TableColumn<AddressRecord, String> colKodi;

    private Button currentActiveButton;

    @FXML
    public void initialize() {
        currentActiveButton = btnPaneli;

        try {
            iconPaneli.setImage(new Image(getClass().getResourceAsStream("/images/home.png")));
            iconRegjistrimet.setImage(new Image(getClass().getResourceAsStream("/images/register.png")));
            iconKerkimet.setImage(new Image(getClass().getResourceAsStream("/images/search.png")));
            iconHarta.setImage(new Image(getClass().getResourceAsStream("/images/map.png")));
            iconCilesimet.setImage(new Image(getClass().getResourceAsStream("/images/settings.png")));
            iconLogout.setImage(new Image(getClass().getResourceAsStream("/images/logout.png")));
        } catch (Exception e) {
            System.out.println("Gabim gjatë ngarkimit të ikonave: " + e.getMessage());
        }

        refreshDashboardData();
    }

    private void refreshDashboardData() {
        loadCardStats();
        setupLineChart();
        setupPieChart();
        setupBarChart();
        setupTable();
    }

    @FXML
    private void handleMenuChange(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton == currentActiveButton) return;

        if (currentActiveButton != null) {
            currentActiveButton.getStyleClass().remove("active");
        }
        clickedButton.getStyleClass().add("active");
        currentActiveButton = clickedButton;

        if (clickedButton == btnPaneli) {
            refreshDashboardData();
            contentScrollPane.setContent(dashboardHome);
        } else {
            String fxmlPath = "";

            if (clickedButton == btnRegjistrimet) {
                fxmlPath = "/fxml/regjistrimet.fxml";
            } else if (clickedButton == btnKerkimet) {
                fxmlPath = "/fxml/Search.fxml";
            } else if (clickedButton == btnHarta) {
                fxmlPath = "/fxml/MapView.fxml";
            } else if (clickedButton == btnCilesimet) {
                fxmlPath = "/fxml/Settings.fxml";
            }

            if (!fxmlPath.isEmpty()) {
                try {
                    Parent newPage = FXMLLoader.load(getClass().getResource(fxmlPath));
                    contentScrollPane.setContent(newPage);
                } catch (IOException e) {
                    System.out.println("Gabim kritik gjatë hapjes së faqes [" + fxmlPath + "]: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadCardStats() {
        try {
            logoCard1.setImage(new Image(getClass().getResourceAsStream("/images/regjistrimet.png")));
            logoCard2.setImage(new Image(getClass().getResourceAsStream("/images/qytete.png")));
            logoCard3.setImage(new Image(getClass().getResourceAsStream("/images/shteti.png")));
            logoCard4.setImage(new Image(getClass().getResourceAsStream("/images/statusi.png")));
        } catch (Exception e) {
            System.out.println("Gabim imagjesh: " + e.getMessage());
        }

        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try (Statement stmt = conn.createStatement()) {

                ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM adresa");
                if (rs1.next()) {
                    lblTotaliAdresave.setText(String.valueOf(rs1.getInt(1)));
                }

                ResultSet rs2 = stmt.executeQuery("SELECT COUNT(DISTINCT qyteti) FROM adresa");
                if (rs2.next()) {
                    lblQyteteAktive.setText(String.valueOf(rs2.getInt(1)));
                }

            } catch (Exception e) {
                System.out.println("Gabim te kartat SQL: " + e.getMessage());
            }
        }
    }

    private void setupBarChart() {
        barChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Numri i Adresave");

        String query = "SELECT qyteti, COUNT(*) as totali FROM adresa GROUP BY qyteti ORDER BY totali DESC LIMIT 5";
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    series.getData().add(new XYChart.Data<>(rs.getString("qyteti"), rs.getInt("totali")));
                }
                barChart.getData().add(series);

            } catch (Exception e) {
                System.out.println("Gabim në BarChart SQL: " + e.getMessage());
            }
        }
    }

    private void setupLineChart() {
        lineChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Trendi");
        series.getData().add(new XYChart.Data<>("Sot", 10));
        series.getData().add(new XYChart.Data<>("Këtë javë", 35));
        lineChart.getData().add(series);
    }

    private void setupPieChart() {
        pieChart.getData().clear();
        PieChart.Data slice1 = new PieChart.Data("Të dhëna aktuale", 100);
        pieChart.getData().add(slice1);
    }

    private void setupTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colQyteti.setCellValueFactory(new PropertyValueFactory<>("qyteti"));
        colRruga.setCellValueFactory(new PropertyValueFactory<>("rruga"));
        colNumri.setCellValueFactory(new PropertyValueFactory<>("numri"));
        colKodi.setCellValueFactory(new PropertyValueFactory<>("kodiPostar"));

        ObservableList<AddressRecord> data = FXCollections.observableArrayList();
        String query = "SELECT id, qyteti, rruga, numri, kodi_postar FROM adresa ORDER BY id DESC LIMIT 5";
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    data.add(new AddressRecord(
                            rs.getInt("id"),
                            rs.getString("qyteti"),
                            rs.getString("rruga"),
                            rs.getString("numri"),
                            rs.getString("kodi_postar")
                    ));
                }
                tableView.setItems(data);

            } catch (Exception e) {
                System.out.println("Gabim gjatë mbushjes së tabelës: " + e.getMessage());
            }
        }
    }

    public static class AddressRecord {
        private final int id;
        private final String qyteti;
        private final String rruga;
        private final String numri;
        private final String kodiPostar;

        public AddressRecord(int id, String qyteti, String rruga, String numri, String kodiPostar) {
            this.id = id;
            this.qyteti = qyteti;
            this.rruga = rruga;
            this.numri = numri;
            this.kodiPostar = kodiPostar;
        }

        public int getId() { return id; }
        public String getQyteti() { return qyteti; }
        public String getRruga() { return rruga; }
        public String getNumri() { return numri; }
        public String getKodiPostar() { return kodiPostar; }
    }
}