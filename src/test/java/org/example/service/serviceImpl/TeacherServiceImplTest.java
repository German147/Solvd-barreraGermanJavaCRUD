package org.example.service.serviceImpl;

import junit.framework.TestCase;
import org.example.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImplTest extends TestCase {

    public void testFindAllTeachers() {
//        given
        List<Teacher> teacherList = new ArrayList<>();
        Teacher jose = new Teacher(1, "Jose", "Martinez", "123465", 4);
        Teacher martin = new Teacher(2, "Martin", "Rodriguez", "457891", 4);
        teacherList.add(jose);
        teacherList.add(martin);
//        when
        TeacherServiceImpl service = new TeacherServiceImpl();
        teacherList = service.findAllTeachers();

//        after

    }

    public void testGetTeacherById() {
    }

    public void testUpdateTeacher() {
    }

    public void testInsertTeacher() {
    }

    public void testDeleteTeacherById() {
    }
}