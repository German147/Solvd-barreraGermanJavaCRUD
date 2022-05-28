package org.example.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Tutor")
public class Tutor extends Person {

    @XmlAttribute(name = "idTutor")
    private int idTutor;

    @XmlElement(name ="tutorAddress")
    private Address tutorAddress;

    @XmlElementWrapper(name = "tutorStudentList")
    @XmlElement(name = "Studetn",type = Student.class)
    private List<Student> tutorStudentList;

    public Tutor() {
    }

    public Tutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public Tutor(int idTutor, Address tutorAddress, List<Student> tutorStudentList) {
        this.idTutor = idTutor;
        this.tutorAddress = tutorAddress;
        this.tutorStudentList = tutorStudentList;
    }


    public Tutor(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
    }

    public Tutor(int idTutor, String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.idTutor = idTutor;
    }

    public Tutor(String name, String surname, String phoneNumber, int idTutor,
                 Address tutorAddress, List<Student> tutorStudentList) {
        super(name, surname, phoneNumber);
        this.idTutor = idTutor;
        this.tutorAddress = tutorAddress;
        this.tutorStudentList = tutorStudentList;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
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
                ", tutorAddress=" + tutorAddress +
                ", tutorStudentList=" + tutorStudentList +
                '}';
    }
}
