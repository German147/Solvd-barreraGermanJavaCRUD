package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DAO.DAOImpl.StudentDAOImpl;
import org.example.entity.Student;
import org.example.exceptions.DAO_exception;
import org.example.service.IStudentDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements IStudentDAO {

    private static final Logger LOGGER = LogManager.getLogger(StudentServiceImpl.class);
    private static StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

    @Override
    public List<Student> listStudentSDAO() {
        StudentDAOImpl studentDAO = null;

        List<Student> studentList = new ArrayList<>();
        if (studentDAO == null) {
            studentDAO = new StudentDAOImpl();
            studentList = studentDAO.list();
        }
        return studentList;
    }

    @Override
    public Student getStudentDAOById(Integer integer) {
        Student student = null;
        try {
            student = studentDAOImpl.getById(integer);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudentDAO(Student student) {
        try {
            studentDAOImpl.update(student);
        } catch (DAO_exception e) {
            LOGGER.info("The student was NOT updated ");
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void insertStudentDAO(Student student) {
        try {
            studentDAOImpl.insert(student);
        } catch (DAO_exception | SQLException e) {
          LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteStudentDAO(Student student) {
        try {
            studentDAOImpl.delete(student);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
