package org.example.entity;

public class City extends States
{
    private int idCity;
    private String cityName;

    public City(){
        super();

    }

    public City(int idCountry, String name,
                int idState, String stateName,
                int idCity, String cityName) {
        super(idCountry, name, idState, stateName);
        this.idCity = idCity;
        this.cityName = cityName;
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
}
