package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Student extends Person{

    private int idStudent;

    @JsonProperty("studentMedicalCertificates")
    private MedicalCertificates studentMedicalCertificates;
    @JsonProperty("studentCourse")
    private Course studentCourse;
    @JsonProperty
    private List<Tutor> studentTutorList;
    @JsonProperty
    private List<Subject> studentSubjectList;
    @JsonProperty
    private List<Behaviour_Attention_Call> attention_callList;

    public Student() {
    }
    public Student(int idStudent) {
        this.idStudent = idStudent;
    }
    public Student(int idStudent,String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.idStudent = idStudent;
    }
    public Student(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
    }

    public Student(String name, String surname, String phoneNumber, int idStudent,
                   MedicalCertificates studentMedicalCertificates, Course studentCourse,
                   List<Tutor> studentTutorList, List<Subject> studentSubjectList,
                   List<Behaviour_Attention_Call> attention_callList) {
        super(name, surname, phoneNumber);
        this.idStudent = idStudent;
        this.studentMedicalCertificates = studentMedicalCertificates;
        this.studentCourse = studentCourse;
        this.studentTutorList = studentTutorList;
        this.studentSubjectList = studentSubjectList;
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

    public List<Subject> getStudentSubjectList() {
        return studentSubjectList;
    }

    public void setStudentSubjectList(List<Subject> studentSubjectList) {
        this.studentSubjectList = studentSubjectList;
    }

    public List<Behaviour_Attention_Call> getAttention_callList() {
        return attention_callList;
    }

    public void setAttention_callList(List<Behaviour_Attention_Call> attention_callList) {
        this.attention_callList = attention_callList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", studentMedicalCertificates=" + studentMedicalCertificates +
                ", studentCourse=" + studentCourse +
                ", studentTutorList=" + studentTutorList +
                ", studentSubjectList=" + studentSubjectList +
                ", attention_callList=" + attention_callList +
                '}';
    }
}
