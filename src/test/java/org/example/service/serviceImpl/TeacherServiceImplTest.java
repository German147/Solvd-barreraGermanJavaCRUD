package org.example.service.serviceImpl;

import junit.framework.TestCase;
import org.example.entity.Teacher;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.DAOImpl.TeacherDAOImpl;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherServiceImplTest {


    TeacherDAOImpl teacherUnderTest = new TeacherDAOImpl();

    @Test
    public void testFindAllTeachers() {
//        given
        List<Teacher> teacherList = new ArrayList<>();
//        when
        teacherList = teacherUnderTest.list();
        boolean expected = false;
        if (!teacherList.isEmpty()) {
            expected = true;
        }
//        then
        assertTrue(expected);
    }

    @Test
    public void testGetTeacherById() {
//        given
        Teacher german = new Teacher(3);
//        when
        Teacher germanUnderTest = new Teacher();
        try {
            germanUnderTest = teacherUnderTest.getById(3);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
//        then
        assertEquals(german,germanUnderTest);
    }

    public void testUpdateTeacher() {
    }

    public void testInsertTeacher() {
        //given
        Teacher jose = new Teacher(1, "Jose", "Martinez", "123465");
        Teacher martin = new Teacher(2, "Martin", "Rodriguez", "457891");

        try {
            teacherUnderTest.insert(jose);
            teacherUnderTest.insert(martin);
        } catch (DAO_exception | SQLException e) {
            e.printStackTrace();
        }
        //when
        try {
            teacherUnderTest.getById(1);


        } catch (DAO_exception e) {
            e.printStackTrace();
        }
        //then


    }

    public void testDeleteTeacherById() {
    }
}