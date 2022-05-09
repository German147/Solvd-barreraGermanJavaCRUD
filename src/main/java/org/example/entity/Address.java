package org.example.entity;

public class Address {

    private int idAddress;
    private String streetName;
    private int streetNumber;

    public Address() {
    }

    public Address(int idAddress, String streetName, int streetNumber) {
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

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }
}


