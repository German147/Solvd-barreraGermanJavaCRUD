package org.example.entity;

import java.util.Date;

public class Exam {
    private int idExam;
    private Date examDate;
    private int qualification;
    private String examTopic;

    public Exam() {
    }

    public Exam(int idExam, Date examDate, int qualification, String examTopic) {
        this.idExam = idExam;
        this.examDate = examDate;
        this.qualification = qualification;
        this.examTopic = examTopic;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getExamTopic() {
        return examTopic;
    }

    public void setExamTopic(String examTopic) {
        this.examTopic = examTopic;
    }
}
