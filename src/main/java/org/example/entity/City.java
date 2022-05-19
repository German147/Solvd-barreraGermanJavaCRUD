package org.example.entity;

import java.util.List;

public class City {

    private int idCity;
    private String cityName;
    private List<Neighborhood> neighborhoodList;

    public City() {
    }

    public City(int idCity, String cityName, List<Neighborhood> neighborhoodList) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.neighborhoodList = neighborhoodList;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Neighborhood> getNeighborhoodList() {
        return neighborhoodList;
    }

    public void setNeighborhoodList(List<Neighborhood> neighborhoodList) {
        this.neighborhoodList = neighborhoodList;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", neighborhoodList=" + neighborhoodList +
                '}';
    }
}
