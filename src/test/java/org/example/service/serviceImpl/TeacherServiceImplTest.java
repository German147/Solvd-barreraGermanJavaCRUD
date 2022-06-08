package org.example.service.serviceImpl;

import org.example.entity.Teacher;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.DAOImpl.TeacherDAOImpl;
import org.junit.jupiter.api.Assertions;
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
        //given
        List<Teacher> teacherList = new ArrayList<>();

        //when
        teacherList = teacherUnderTest.list();
        boolean expected = false;
        if (!teacherList.isEmpty()) {
            expected = true;
        }

        //then
        assertTrue(expected);
    }

    @Test
    public void testGetTeacherById() {
        try {
            //given
            Teacher german = new Teacher(3, "German", "Barrera", "32165487");

            //when
            Teacher germanUnderTest = new Teacher();
            germanUnderTest = teacherUnderTest.getById(3);

            //then
            assertEquals(german, germanUnderTest);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateTeacher() {
        try {
            //given
            Teacher tomasToUpdate = new Teacher(1, "Tomas", "Frias", "456789");

            //when
            teacherUnderTest.update(tomasToUpdate);
            Teacher afterUpdated = new Teacher();
            afterUpdated = teacherUnderTest.getById(1);

            //then
            assertEquals(tomasToUpdate, afterUpdated);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertTeacher() {
        try {
            //given
            Teacher jose = new Teacher(9, "Jose", "Martinez", "123465");
            teacherUnderTest.insert(jose);

            //when
            Teacher joseUnderTest = new Teacher();
            joseUnderTest = teacherUnderTest.getById(9);

            //then
            assertEquals(jose, joseUnderTest);
        } catch (DAO_exception | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteTeacherById() {
        try {
            //given
            Teacher teacherToDelete = new Teacher(5);

            //when
            teacherUnderTest.delete(teacherToDelete);
            Teacher teacherDoesntExists = new Teacher();
            teacherDoesntExists = teacherUnderTest.getById(5);

            //then
            Assertions.assertNull(teacherDoesntExists);
        } catch (DAO_exception e) {
            e.printStackTrace();
        }

    }
}