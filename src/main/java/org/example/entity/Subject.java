package org.example.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Subject")
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

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", subjectName='" + subjectName + '\'' +
                ", lectureList=" + lectureList +
                '}';
    }
}
