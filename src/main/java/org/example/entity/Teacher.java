package org.example.entity;


import java.util.Date;

public class Teacher extends Person{
    private int idTeacher;
    private String teacherSubject;
    private String teacherDepartment;

    public Teacher(){
    }
    public Teacher(int idTeacher){
        this.idTeacher = idTeacher;
    }
    public Teacher(int idTeacher, String teacherSubject, String teacherDepartment) {
        this.idTeacher = idTeacher;
        this.teacherSubject = teacherSubject;
        this.teacherDepartment = teacherDepartment;
    }

    public Teacher(String name, String surname, String phoneNumber, Date birthDate,  int idTeacher, String teacherSubject, String teacherDepartment) {
        this.idTeacher = idTeacher;
        this.teacherSubject = teacherSubject;
        this.teacherDepartment = teacherDepartment;
    }
}
