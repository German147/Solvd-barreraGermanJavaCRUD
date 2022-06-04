package org.example.entity;

import java.util.Date;

public class BehaviourAttentionCall {

    private int idBehaviourCall;
    private String detailOfBehaviour;
    private Date dateOfBehaviourCall;
    private int numberOfCall;
    private boolean isTutorAwareOf;

    public BehaviourAttentionCall() {
    }

    public BehaviourAttentionCall(int idBehaviourCall) {
        this.idBehaviourCall = idBehaviourCall;
    }

    public BehaviourAttentionCall(int idBehaviourCall,
                                  String detailOfBehaviour,
                                  Date dateOfBehaviourCall,
                                  int numberOfCall,
                                  boolean isTutorAwareOf) {
        this.idBehaviourCall = idBehaviourCall;
        this.detailOfBehaviour = detailOfBehaviour;
        this.dateOfBehaviourCall = dateOfBehaviourCall;
        this.numberOfCall = numberOfCall;
        this.isTutorAwareOf = isTutorAwareOf;
    }

    public BehaviourAttentionCall(String detailOfBehaviour,
                                  Date dateOfBehaviourCall,
                                  int numberOfCall,
                                  boolean isTutorAwareOf) {
        this.detailOfBehaviour = detailOfBehaviour;
        this.dateOfBehaviourCall = dateOfBehaviourCall;
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

    public String getDetailOfBehaviour() {
        return detailOfBehaviour;
    }

    public void setDetailOfBehaviour(String detailOfBehaviour) {
        this.detailOfBehaviour = detailOfBehaviour;
    }

    @Override
    public String toString() {
        return "BehaviourAttentionCall{" +
                "idBehaviourCall=" + idBehaviourCall +
                ", detailOfBehaviour='" + detailOfBehaviour + '\'' +
                ", dateOfBehaviourCall=" + dateOfBehaviourCall +
                ", numberOfCall=" + numberOfCall +
                ", isTutorAwareOf=" + isTutorAwareOf +
                '}';
    }
}

