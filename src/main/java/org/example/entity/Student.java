package org.example.entity;

import java.util.List;

public class Student extends Person{

    private int idStudent;
    private MedicalCertificates studentMedicalCertificates;
    private Course studentCourse;
    private List<Tutor> studentTutorList;
    private List<Subject> studentSubjectList;
    private List<BehaviourAttentionCall> attention_callList;

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
                   List<BehaviourAttentionCall> attention_callList) {
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

    public List<BehaviourAttentionCall> getAttention_callList() {
        return attention_callList;
    }

    public void setAttention_callList(List<BehaviourAttentionCall> attention_callList) {
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
