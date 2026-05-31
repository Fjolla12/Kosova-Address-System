package model;

public class Address {

    private int id;
    private String qyteti;
    private String rruga;
    private String numri;
    private String kodiPostar;

    public Address() {
    }

    public Address(String qyteti, String rruga, String numri, String kodiPostar) {
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.numri = numri;
        this.kodiPostar = kodiPostar;
    }

    public Address(int id, String qyteti, String rruga, String numri, String kodiPostar) {
        this.id = id;
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.numri = numri;
        this.kodiPostar = kodiPostar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public String getRruga() {
        return rruga;
    }

    public void setRruga(String rruga) {
        this.rruga = rruga;
    }

    public String getNumri() {
        return numri;
    }

    public void setNumri(String numri) {
        this.numri = numri;
    }

    public String getKodiPostar() {
        return kodiPostar;
    }

    public void setKodiPostar(String kodiPostar) {
        this.kodiPostar = kodiPostar;
    }
}
