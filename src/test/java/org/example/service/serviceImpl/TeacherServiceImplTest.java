package org.example.service.serviceImpl;

import junit.framework.TestCase;
import org.example.entity.Course;
import org.example.entity.MedicalCertificates;
import org.example.entity.Subject;
import org.example.entity.Teacher;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.DAOImpl.TeacherDAOImpl;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherServiceImplTest extends TestCase {


    TeacherDAOImpl teacherUnderTest;

    @Test
    public void testFindAllTeachers() {
//        given
        List<Teacher> teacherList = new ArrayList<>();
        TeacherServiceImpl service = new TeacherServiceImpl();

//        when
        teacherList = service.findAllTeachers();
        boolean expected = false;
        if (!teacherList.isEmpty()) {
            expected = true;
        }
//        then
        assertTrue(expected);

    }

    public void testGetTeacherById() {
//        given
        MedicalCertificates germanCertificate = new MedicalCertificates(4,"Graciela Coni",new Date(2023-04-07));
        Subject maths = new Subject();
        List<Course> courseList = new ArrayList<>();
        Course thirdA = new Course();
        Course secondB = new Course();
        courseList.add(thirdA);
        courseList.add(secondB);


        Teacher german = new Teacher(3,"German","Barrera","'32165487",
                "Maths",4,germanCertificate,maths,courseList);
        TeacherServiceImpl service = new TeacherServiceImpl();

//        when
       assertEquals(german,service.getTeacherById(3));

//        then

    }

    public void testUpdateTeacher() {
    }

    public void testInsertTeacher() {
        //given
        Teacher jose = new Teacher(1, "Jose", "Martinez", "123465", 4);
        Teacher martin = new Teacher(2, "Martin", "Rodriguez", "457891", 4);

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