package org.example.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Lecture {

    @JsonProperty
    private int idLecture;
    @JsonProperty
    private String lectureTopic;

    public Lecture() {
    }

    public Lecture(int idLecture, String lectureTopic) {
        this.idLecture = idLecture;
        this.lectureTopic = lectureTopic;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getLectureTopic() {
        return lectureTopic;
    }

    public void setLectureTopic(String lectureTopic) {
        this.lectureTopic = lectureTopic;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "idLecture=" + idLecture +
                ", lectureTopic='" + lectureTopic + '\'' +
                '}';
    }
}
