package org.example.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {

    @XmlAttribute(name = "idSubject")
    private int idSubject;

    @XmlElement(name = "subjectName",type = String.class)
    private String subjectName;

    @XmlElementWrapper(name = "lectureList")
    @XmlElement(name = "Lecture",type = Lecture.class)
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

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
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
