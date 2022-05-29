package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Subject {

    @JsonProperty
    private int idSubject;
    @JsonProperty
    private String subjectName;
    @JsonProperty
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
