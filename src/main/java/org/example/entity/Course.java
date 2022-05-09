package org.example.entity;

public class Course {
    private int idCourse;
    private String courseName;

    public Course(int idCourse, String courseName) {
        this.idCourse = idCourse;
        this.courseName = courseName;
    }

    public Course() {
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
