package org.example.entity;

import java.util.List;

public class Neighborhood{

    private int idNeighborhood;
    private String neighborhoodName;
    private List<Address> addressList;

    public Neighborhood() {
    }

    public Neighborhood(int idNeighborhood, String neighborhoodName, List<Address> addressList) {
        this.idNeighborhood = idNeighborhood;
        this.neighborhoodName = neighborhoodName;
        this.addressList = addressList;
    }

    public int getIdNeighborhood() {
        return idNeighborhood;
    }

    public void setIdNeighborhood(int idNeighborhood) {
        this.idNeighborhood = idNeighborhood;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Neighborhood{" +
                "idNeighborhood=" + idNeighborhood +
                ", neighborhoodName='" + neighborhoodName + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
