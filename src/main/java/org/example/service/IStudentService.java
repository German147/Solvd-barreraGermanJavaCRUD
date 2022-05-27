package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface IStudentService {

   List<Student> findAllStudents();

    Student getStudentById(Integer integer);

    void updateStudent(Student student);

    void insertStudent(Student student);

    void deleteStudentById(Student student);
}
