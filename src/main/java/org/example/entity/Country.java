package org.example.entity;

import java.util.List;

public class Country {

    private int idCountry;
    private String name;
    private List<States> statesList;

    public Country() {
    }

    public Country(int idCountry, String name, List<States> statesList) {
        this.idCountry = idCountry;
        this.name = name;
        this.statesList = statesList;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<States> getStatesList() {
        return statesList;
    }

    public void setStatesList(List<States> statesList) {
        this.statesList = statesList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", name='" + name + '\'' +
                ", statesList=" + statesList +
                '}';
    }
}
