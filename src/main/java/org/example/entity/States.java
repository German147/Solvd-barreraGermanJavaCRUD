package org.example.entity;

import java.util.List;

public class States {

    private int idState;
    private String stateName;
    private List<City> cityList;

    public States() {
    }

    public States(int idState, String stateName, List<City> cityList) {
        this.idState = idState;
        this.stateName = stateName;
        this.cityList = cityList;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "States{" +
                "idState=" + idState +
                ", stateName='" + stateName + '\'' +
                ", cityList=" + cityList +
                '}';
    }
}

