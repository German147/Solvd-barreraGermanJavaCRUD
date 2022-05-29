package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Behaviour_Attention_Call {

    @JsonProperty
    private int idBehaviourCall;
    @JsonProperty
    private String dateOfBehaviourCall;
    @JsonProperty
    private String detailOfBehaviour;
    @JsonProperty
    private int numberOfCall;
    @JsonProperty
    private boolean isTutorAwareOf;

    public Behaviour_Attention_Call() {
    }

    public Behaviour_Attention_Call(int idBehaviourCall, String dateOfBehaviourCall,
                                    String detailOfBehaviour, int numberOfCall, boolean isTutorAwareOf) {
        this.idBehaviourCall = idBehaviourCall;
        this.dateOfBehaviourCall = dateOfBehaviourCall;
        this.detailOfBehaviour = detailOfBehaviour;
        this.numberOfCall = numberOfCall;
        this.isTutorAwareOf = isTutorAwareOf;
    }

    public int getIdBehaviourCall() {
        return idBehaviourCall;
    }

    public void setIdBehaviourCall(int idBehaviourCall) {
        this.idBehaviourCall = idBehaviourCall;
    }

    public String getDateOfBehaviourCall() {
        return dateOfBehaviourCall;
    }

    public void setDateOfBehaviourCall(String dateOfBehaviourCall) {
        this.dateOfBehaviourCall = dateOfBehaviourCall;
    }

    public String getDetailOfBehaviour() {
        return detailOfBehaviour;
    }

    public void setDetailOfBehaviour(String detailOfBehaviour) {
        this.detailOfBehaviour = detailOfBehaviour;
    }

    public int getNumberOfCall() {
        return numberOfCall;
    }

    public void setNumberOfCall(int numberOfCall) {
        this.numberOfCall = numberOfCall;
    }

    public boolean isTutorAwareOf() {
        return isTutorAwareOf;
    }

    public void setTutorAwareOf(boolean tutorAwareOf) {
        isTutorAwareOf = tutorAwareOf;
    }

    @Override
    public String toString() {
        return "Behaviour_Attention_Call{" +
                "idBehaviourCall=" + idBehaviourCall +
                ", dateOfBehaviourCall='" + dateOfBehaviourCall + '\'' +
                ", detailOfBehaviour='" + detailOfBehaviour + '\'' +
                ", numberOfCall=" + numberOfCall +
                ", isTutorAwareOf=" + isTutorAwareOf +
                '}';
    }
}

