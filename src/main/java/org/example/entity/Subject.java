package org.example.entity;

public class Subject {
    private int idSubject;
    private String subjectName;

    public Subject() {
    }

    public Subject(int idSubject, String subjectName) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
