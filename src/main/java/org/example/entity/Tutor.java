package org.example.entity;

import org.example.ENUM.EGender;

import java.sql.Date;
import java.util.List;

public class Tutor extends Person {

    private int idTutor;
    private String tutorName;
    private String tutorSurname;
    private Address tutorAddress;
    private List<Student> tutorStudentList;

    public Tutor() {
    }

    public Tutor(int idTutor, String tutorName, String tutorSurname,
                 Address tutorAddress, List<Student> tutorStudentList) {
        this.idTutor = idTutor;
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
        this.tutorAddress = tutorAddress;
        this.tutorStudentList = tutorStudentList;
    }

    public Tutor(String name, String surname, String phoneNumber, int idTutor, String tutorName,
                 String tutorSurname, Address tutorAddress, List<Student> tutorStudentList) {
        super(name, surname, phoneNumber);
        this.idTutor = idTutor;
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
        this.tutorAddress = tutorAddress;
        this.tutorStudentList = tutorStudentList;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorSurname() {
        return tutorSurname;
    }

    public void setTutorSurname(String tutorSurname) {
        this.tutorSurname = tutorSurname;
    }

    public Address getTutorAddress() {
        return tutorAddress;
    }

    public void setTutorAddress(Address tutorAddress) {
        this.tutorAddress = tutorAddress;
    }

    public List<Student> getTutorStudentList() {
        return tutorStudentList;
    }

    public void setTutorStudentList(List<Student> tutorStudentList) {
        this.tutorStudentList = tutorStudentList;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "idTutor=" + idTutor +
                ", tutorName='" + tutorName + '\'' +
                ", tutorSurname='" + tutorSurname + '\'' +
                ", tutorAddress=" + tutorAddress +
                ", tutorStudentList=" + tutorStudentList +
                '}';
    }
}
