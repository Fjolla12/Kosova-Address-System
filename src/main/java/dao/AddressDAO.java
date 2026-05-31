package dao;

import database.DBConnection;
import model.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

    public boolean addAddress(Address address) {
        String sql = "INSERT INTO adresa (qyteti, rruga, numri, kodi_postar) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address.getQyteti());
            stmt.setString(2, address.getRruga());
            stmt.setString(3, address.getNumri());
            stmt.setString(4, address.getKodiPostar());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gabim gjatë shtimit të adresës: " + e.getMessage());
            return false;
        }
    }

    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM adresa";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                addresses.add(mapResultSetToAddress(rs));
            }

        } catch (SQLException e) {
            System.out.println("Gabim gjatë leximit të adresave: " + e.getMessage());
        }

        return addresses;
    }

    public boolean updateAddress(Address address) {
        String sql = "UPDATE adresa SET qyteti = ?, rruga = ?, numri = ?, kodi_postar = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address.getQyteti());
            stmt.setString(2, address.getRruga());
            stmt.setString(3, address.getNumri());
            stmt.setString(4, address.getKodiPostar());
            stmt.setInt(5, address.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gabim gjatë përditësimit të adresës: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteAddress(int id) {
        String sql = "DELETE FROM adresa WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gabim gjatë fshirjes së adresës: " + e.getMessage());
            return false;
        }
    }

    public List<Address> searchAddress(String keyword) {
        List<Address> addresses = new ArrayList<>();

        String sql = """
                SELECT * FROM adresa
                WHERE qyteti LIKE ?
                   OR rruga LIKE ?
                   OR numri LIKE ?
                   OR kodi_postar LIKE ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String searchValue = "%" + keyword + "%";

            stmt.setString(1, searchValue);
            stmt.setString(2, searchValue);
            stmt.setString(3, searchValue);
            stmt.setString(4, searchValue);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                addresses.add(mapResultSetToAddress(rs));
            }

        } catch (SQLException e) {
            System.out.println("Gabim gjatë kërkimit të adresës: " + e.getMessage());
        }

        return addresses;
    }

    private Address mapResultSetToAddress(ResultSet rs) throws SQLException {
        return new Address(
                rs.getInt("id"),
                rs.getString("qyteti"),
                rs.getString("rruga"),
                rs.getString("numri"),
                rs.getString("kodi_postar")
        );
    }
}
