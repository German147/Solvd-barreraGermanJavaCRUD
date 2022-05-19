package org.example.entity;



public class Exam {

    private int idExam;
    private int qualification;
    private String examTopic;

    public Exam() {
    }

    public Exam(int idExam, int qualification, String examTopic) {
        this.idExam = idExam;
        this.qualification = qualification;
        this.examTopic = examTopic;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
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

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExam +
                ", qualification=" + qualification +
                ", examTopic='" + examTopic + '\'' +
                '}';
    }
}
