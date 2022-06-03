package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Student;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.MySqlDAOImpl.StudentDAOImpl;
import org.example.service.IStudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements IStudentService {

    private static final Logger LOGGER = LogManager.getLogger(StudentServiceImpl.class);
    private static StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

    @Override
    public List<Student> findAllStudents() {
        StudentDAOImpl studentDAO = null;

        List<Student> studentList = new ArrayList<>();
        if (studentDAO == null) {
            studentDAO = new StudentDAOImpl();
            studentList = studentDAO.list();
        }
        return studentList;
    }

    @Override
    public Student getStudentById(Integer integer) {
        Student student = null;
        try {
            student = studentDAOImpl.getById(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        try {
            studentDAOImpl.update(student);
        } catch (DAO_exception e) {
            LOGGER.info("The student was NOT updated ");
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void insertStudent(Student student) {
        try {
            studentDAOImpl.insert(student);
        } catch (DAO_exception | SQLException e) {
          LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteStudentById(Student student) {
        try {
            studentDAOImpl.delete(student);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
