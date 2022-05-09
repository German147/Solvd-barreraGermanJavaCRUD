package org.example.entity;

import java.util.Date;

public class Behaviour_Atention_Call {
    private int idBehaviourCall;
    private Date dateOfBehaviourCall;
    private String detailOfBehaviour;
    private int numberOfCall;
    private boolean isTutorAwareOf;

    public Behaviour_Atention_Call() {
    }

    public Behaviour_Atention_Call(int idBehaviourCall, Date dateOfBehaviourCall,
                                   String detailOfBehaviour, int numberOfCall,
                                   boolean isTutorAwareOf) {
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

    public Date getDateOfBehaviourCall() {
        return dateOfBehaviourCall;
    }

    public void setDateOfBehaviourCall(Date dateOfBehaviourCall) {
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
}
