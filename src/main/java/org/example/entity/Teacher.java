package org.example.entity;

import java.util.List;

public class Teacher extends Person {

    private int idTeacher;
    private String teacherDepartment;
    private Address teacherAddress;
    private MedicalCertificates teacherMedicalCertificate;
    private Subject teacherSubject;
    private List<Course> courseList;

    public Teacher() {
    }

    public Teacher(int idTeacher, String teacherDepartment, Address teacherAddress,
                   MedicalCertificates teacherMedicalCertificate, Subject teacherSubject,
                   List<Course> courseList) {
        this.idTeacher = idTeacher;
        this.teacherDepartment = teacherDepartment;
        this.teacherAddress = teacherAddress;
        this.teacherMedicalCertificate = teacherMedicalCertificate;
        this.teacherSubject = teacherSubject;
        this.courseList = courseList;
    }

    public Teacher(String name, String surname, String phoneNumber, int idTeacher,
                   String teacherDepartment, Address teacherAddress,
                   MedicalCertificates teacherMedicalCertificate, Subject teacherSubject, List<Course> courseList) {
        super(name, surname, phoneNumber);
        this.idTeacher = idTeacher;
        this.teacherDepartment = teacherDepartment;
        this.teacherAddress = teacherAddress;
        this.teacherMedicalCertificate = teacherMedicalCertificate;
        this.teacherSubject = teacherSubject;
        this.courseList = courseList;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getTeacherDepartment() {
        return teacherDepartment;
    }

    public void setTeacherDepartment(String teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }

    public Address getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(Address teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public MedicalCertificates getTeacherMedicalCertificate() {
        return teacherMedicalCertificate;
    }

    public void setTeacherMedicalCertificate(MedicalCertificates teacherMedicalCertificate) {
        this.teacherMedicalCertificate = teacherMedicalCertificate;
    }

    public Subject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(Subject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                ", teacherDepartment='" + teacherDepartment + '\'' +
                ", teacherAddress=" + teacherAddress +
                ", teacherMedicalCertificate=" + teacherMedicalCertificate +
                ", teacherSubject=" + teacherSubject +
                ", courseList=" + courseList +
                '}';
    }
}
