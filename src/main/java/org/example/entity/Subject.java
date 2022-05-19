package org.example.entity;

import java.util.List;

public class Subject {

    private int idSubject;
    private String subjectName;
    private List<Lecture> lectureList;

    public Subject() {
    }

    public Subject(int idSubject) {
        this.idSubject = idSubject;
    }

    public Subject(int idSubject, String subjectName, List<Lecture> lectureList) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.lectureList = lectureList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", subjectName='" + subjectName + '\'' +
                ", lectureList=" + lectureList +
                '}';
    }
}
