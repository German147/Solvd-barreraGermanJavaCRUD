package org.example.service.serviceImpl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Teacher;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.DAOImpl.TeacherDAOImpl;
import org.example.service.ITeacherService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements ITeacherService {

    private static final Logger LOGGER = LogManager.getLogger(TeacherServiceImpl.class);
    private static TeacherDAOImpl teacherDAO = new TeacherDAOImpl();

    @Override
    public List<Teacher> findAllTeachers() {
        TeacherDAOImpl teacherDAO = null;

        List<Teacher> teacherList = new ArrayList<>();
        if (teacherDAO == null) {
            teacherDAO = new TeacherDAOImpl();
            teacherList = teacherDAO.list();
        }
        return teacherList;
    }

    @Override
    public Teacher getTeacherById(Integer integer) {
        Teacher teacher = null;
        try {
            teacher = teacherDAO.getById(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try {
            teacherDAO.update(teacher);
        } catch (DAO_exception e) {
            LOGGER.info("The teacher was NOT updated ");
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        try {
            teacherDAO.insert(teacher);
        } catch (DAO_exception | SQLException e) {
         LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteTeacherById(Teacher integer) {
        try {
            teacherDAO.delete(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
