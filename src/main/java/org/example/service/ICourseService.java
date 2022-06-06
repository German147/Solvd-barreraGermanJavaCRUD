package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface ICourseService {

    List<Course> findAllCourses();

    Course getCourseById(Integer integer);

    void updateCourse(Course course);

    void insertCourse(Course course);

    void deleteCourse(Course course);
}
