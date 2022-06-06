package org.example.entity;

import java.util.List;

public class Course {

    private int idCourse;
    private String courseName;
    private String celatorName;
    private List<Student> courseStudentList;
    private List<Teacher> courseTeacherList;
    private List<Subject> courseSubjectList;

    public Course() {
    }

    public Course(int idCourse) {
        this.idCourse = idCourse;
    }

    public Course(int idCourse, String courseName, String celatorName) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.celatorName = celatorName;
    }

    public Course(String courseName, String celatorName) {
        this.courseName = courseName;
        this.celatorName = celatorName;
    }

    public Course(int idCourse,
                  String courseName,
                  String celatorName,
                  List<Student> courseStudentList,
                  List<Teacher> courseTeacherList,
                  List<Subject> courseSubjectList) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.celatorName = celatorName;
        this.courseStudentList = courseStudentList;
        this.courseTeacherList = courseTeacherList;
        this.courseSubjectList = courseSubjectList;
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

    public String getCelatorName() {
        return celatorName;
    }

    public void setCelatorName(String celatorName) {
        this.celatorName = celatorName;
    }

    public List<Student> getCourseStudentList() {
        return courseStudentList;
    }

    public void setCourseStudentList(List<Student> courseStudentList) {
        this.courseStudentList = courseStudentList;
    }

    public List<Teacher> getCourseTeacherList() {
        return courseTeacherList;
    }

    public void setCourseTeacherList(List<Teacher> courseTeacherList) {
        this.courseTeacherList = courseTeacherList;
    }

    public List<Subject> getCourseSubjectList() {
        return courseSubjectList;
    }

    public void setCourseSubjectList(List<Subject> courseSubjectList) {
        this.courseSubjectList = courseSubjectList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", courseName='" + courseName + '\'' +
                ", celatorName='" + celatorName + '\'' +
                '}';
    }
}
