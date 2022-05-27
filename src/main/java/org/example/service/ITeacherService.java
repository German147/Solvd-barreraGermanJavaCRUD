package org.example.service;

import org.example.entity.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAllTeachers();

    Teacher getTeacherById(Integer integer);

    void updateTeacher(Teacher teacher);

    void insertTeacher(Teacher teacher);

    void deleteTeacherById(Teacher integer);
}
