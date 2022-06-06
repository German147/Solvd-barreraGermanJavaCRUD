package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Course;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.DAOImpl.CourseDAOImpl;
import org.example.service.ICourseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {

    private static final Logger LOGGER  = LogManager.getLogger(CourseServiceImpl.class);
    private static final CourseDAOImpl courseDAOImpl = new CourseDAOImpl();

    @Override
    public List<Course> findAllCourses() {
       List<Course> courseList = new ArrayList<>();
       courseList = courseDAOImpl.list();
        return courseList;
    }

    @Override
    public Course getCourseById(Integer integer) {
       Course course = new Course();
        try {
            course = courseDAOImpl.getById(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        try {
            courseDAOImpl.update(course);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCourse(Course course) {
        try {
            courseDAOImpl.insert(course);
        } catch (DAO_exception | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Course course) {
        try {
            courseDAOImpl.delete(course);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
    }
}
