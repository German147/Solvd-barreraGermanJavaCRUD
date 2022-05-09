package org.example.service;

import org.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    ICreateSomething<List<Student>> studentList();

     Optional<Student> getStudentById(Integer integer);

    void getBehaviourCallByStudentId();

    void getMedicalCertificateByStudentId();

    void getExamsByStudentId();

    void getTutorByStudentId();




}
