package service;

import dao.AddressDAO;
import model.Address;

import java.util.List;

public class AddressService {

    private final AddressDAO addressDAO = new AddressDAO();

    public boolean addAddress(Address address) {
        if (!isValid(address)) {
            System.out.println("Të dhënat e adresës nuk janë valide.");
            return false;
        }

        return addressDAO.addAddress(address);
    }

    public List<Address> getAllAddresses() {
        return addressDAO.getAllAddresses();
    }

    public boolean updateAddress(Address address) {
        if (address.getId() <= 0 || !isValid(address)) {
            System.out.println("Të dhënat për përditësim nuk janë valide.");
            return false;
        }

        return addressDAO.updateAddress(address);
    }

    public boolean deleteAddress(int id) {
        if (id <= 0) {
            System.out.println("ID nuk është valide.");
            return false;
        }

        return addressDAO.deleteAddress(id);
    }

    public List<Address> searchAddress(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllAddresses();
        }

        return addressDAO.searchAddress(keyword.trim());
    }

    private boolean isValid(Address address) {
        return address != null
                && address.getQyteti() != null && !address.getQyteti().trim().isEmpty()
                && address.getRruga() != null && !address.getRruga().trim().isEmpty()
                && address.getNumri() != null && !address.getNumri().trim().isEmpty()
                && address.getKodiPostar() != null && !address.getKodiPostar().trim().isEmpty();
    }
}
