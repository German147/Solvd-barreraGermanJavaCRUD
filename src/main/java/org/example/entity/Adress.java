package org.example.entity;

public class Adress extends City {
    private int idAddress;
    private String streetName;
    private int streetNumber;

    public Adress(int idCountry, String name,
                  int idState, String stateName,
                  int idCity, String cityName,
                  int idAddress, String streetName,
                  int streetNumber) {
        super(idCountry, name, idState, stateName, idCity, cityName);
        this.idAddress = idAddress;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
