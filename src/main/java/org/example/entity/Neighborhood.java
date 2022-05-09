package org.example.entity;

public class Neighborhood extends States{

    private int idNeghborhood;
    private String neighborhoodName;

    public Neighborhood(int idCountry, String name,
                        int idState, String stateName,
                        int idNeghborhood,
                        String neighborhoodName) {
        super(idCountry, name, idState, stateName);
        this.idNeghborhood = idNeghborhood;
        this.neighborhoodName = neighborhoodName;
    }

    public int getIdNeghborhood() {
        return idNeghborhood;
    }

    public void setIdNeghborhood(int idNeghborhood) {
        this.idNeghborhood = idNeghborhood;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }
}
