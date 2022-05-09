package org.example.entity;

public class States  extends Country{
    private int idState;
    private String stateName;

    public States(int idCountry, String name) {
        super(idCountry, name);
    }

    public States(int idCountry, String name, int idState, String stateName) {
        super(idCountry, name);
        this.idState = idState;
        this.stateName = stateName;
    }

    public States() {
        super();
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
}
