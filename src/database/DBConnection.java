package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Kontrollon: url, username, password
    private static final String URL = "jdbc:mysql://localhost:3306/kosova_address_system";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Nisa123.."; 
    
    private static Connection connection = null;

    // 1. connect() -> hap lidhje me DB
    public static void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("SUKSES: Lidhja me databazën u krye me sukses!");
            }
        } catch (SQLException e) {
            System.out.println("GABIM: Nuk mund të lidhemi me databazën! " + e.getMessage());
        }
    }

    // 2. disconnect() -> mbyll connection
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("SUKSES: Lidhja me databazën u mbyll.");
            }
        } catch (SQLException e) {
            System.out.println("GABIM gjatë mbylljes: " + e.getMessage());
        }
    }

    // 3. getConnection() -> kthen connection për CRUD
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            System.out.println("GABIM te getConnection: " + e.getMessage());
        }
        return connection;
    }
}
