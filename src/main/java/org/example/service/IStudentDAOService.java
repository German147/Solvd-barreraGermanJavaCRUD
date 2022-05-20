package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface IStudentDAOService {

   List<Student> listStudentSDAO();

    Student getStudentDAOById(Integer integer);

    void updateStudentDAO(Student student);

    void insertStudentDAO(Student student);

    void deleteStudentDAO(Student student);
}
