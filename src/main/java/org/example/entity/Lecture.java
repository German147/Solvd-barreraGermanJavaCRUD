package org.example.entity;

import java.util.Date;

public class Lecture {
    private int idLecture;
    private Date lectureDate;
    private String lectureTopic;

    public Lecture() {
    }

    public Lecture(int idLecture, Date lectureDate, String lectureTopic) {
        this.idLecture = idLecture;
        this.lectureDate = lectureDate;
        this.lectureTopic = lectureTopic;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public Date getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(Date lectureDate) {
        this.lectureDate = lectureDate;
    }

    public String getLectureTopic() {
        return lectureTopic;
    }

    public void setLectureTopic(String lectureTopic) {
        this.lectureTopic = lectureTopic;
    }
}
