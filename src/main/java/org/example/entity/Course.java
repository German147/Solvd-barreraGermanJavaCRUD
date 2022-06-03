package org.example.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

public class Course {

    private int idCourse;
    private String courseName;
    private List<Student> courseStudentList;
    private List<Teacher> courseTeacherList;
    private List<Subject> courseSubjectList;

    public Course() {
    }

    public Course(int idCourse) {
        this.idCourse = idCourse;
    }

    public Course(int idCourse, String courseName,
                  List<Student> courseStudentList,
                  List<Teacher> courseTeacherList,
                  List<Subject> courseSubjectList) {
        this.idCourse = idCourse;
        this.courseName = courseName;
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
                ", courseStudentList=" + courseStudentList +
                ", courseTeacherList=" + courseTeacherList +
                ", courseSubjectList=" + courseSubjectList +
                '}';
    }
}
