package org.example.entity;

import org.example.XMLadapter.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends Person {

    @XmlAttribute(name = "idStudent")
    private int idStudent;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "firstDayAtSchool")
    private Date firstDayAtSchool;

    @XmlElement(name = "studentMedicalCertificates",type = MedicalCertificates.class)
    private MedicalCertificates studentMedicalCertificates;

    @XmlElement(name = "studentCourse",type = Course.class)
    private Course studentCourse;

    @XmlElementWrapper(name = "studentTutorList")
    @XmlElement(name = "Tutor", type = Tutor.class)
    private List<Tutor> studentTutorList;

    @XmlElementWrapper(name = "attention_callList")
    @XmlElement(name = "Behaviour_Attention_Call")
    private List<Behaviour_Attention_Call> attention_callList;

    //@XmlTransient is used for passwords

    public Student() {
    }

    public Student(int idStudent) {
        this.idStudent = idStudent;
    }

    public Student(int idStudent, String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.idStudent = idStudent;
    }

    public Student(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
    }

    public Student(String name, String surname, String phoneNumber, int idStudent,
                   MedicalCertificates studentMedicalCertificates, Course studentCourse,
                   List<Tutor> studentTutorList,
                   List<Behaviour_Attention_Call> attention_callList) {
        super(name, surname, phoneNumber);
        this.idStudent = idStudent;
        this.studentMedicalCertificates = studentMedicalCertificates;
        this.studentCourse = studentCourse;
        this.studentTutorList = studentTutorList;
        this.attention_callList = attention_callList;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public MedicalCertificates getStudentMedicalCertificates() {
        return studentMedicalCertificates;
    }

    public void setStudentMedicalCertificates(MedicalCertificates studentMedicalCertificates) {
        this.studentMedicalCertificates = studentMedicalCertificates;
    }

    public Course getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(Course studentCourse) {
        this.studentCourse = studentCourse;
    }

    public List<Tutor> getStudentTutorList() {
        return studentTutorList;
    }

    public void setStudentTutorList(List<Tutor> studentTutorList) {
        this.studentTutorList = studentTutorList;
    }


    public List<Behaviour_Attention_Call> getAttention_callList() {
        return attention_callList;
    }

    public void setAttention_callList(List<Behaviour_Attention_Call> attention_callList) {
        this.attention_callList = attention_callList;
    }

    public Date getFirstDayAtSchool() {
        return firstDayAtSchool;
    }

    public void setFirstDayAtSchool(Date firstDayAtSchool) {
        this.firstDayAtSchool = firstDayAtSchool;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", studentMedicalCertificates=" + studentMedicalCertificates +
                ", studentCourse=" + studentCourse +
                ", studentTutorList=" + studentTutorList +
                ", attention_callList=" + attention_callList +
                '}';
    }
}
