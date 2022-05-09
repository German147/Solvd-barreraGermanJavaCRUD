package org.example.entity;

import org.example.ENUM.EGender;

import java.sql.Date;

public class Tutor extends Person {

    private int idTutor;

    public Tutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public Tutor(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
    }

    public Tutor() {
        super();
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }
}
