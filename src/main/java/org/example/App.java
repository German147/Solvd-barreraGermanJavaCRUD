package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Student;
import org.example.service.serviceImpl.StudentServiceImpl;

import java.util.List;


/**
 * Application for Practice Java CRUD
 */
public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        StudentServiceImpl service = new StudentServiceImpl();
        List<Student> studentList1 = service.listStudentSDAO();
        for (Student student : studentList1) {
            LOGGER.info(student.toString() + student.getName());
        }

        /**
         * Here I INSERT a new student to the DB
         */
//        Student student1 = new Student("Raul","Ibraimovich","789465");
//        service.insertStudentDAO(student1);
        /**
         * Here I UPDATE an existen element into the DB
         */
        // IStudentDAO studentDAO = new IStudentDAO();
//        Student modifyingStudent = new Student(7, "Patrick", "Schutts", "78946513");
//        IStudentDAO updateDAO1 = new IStudentDAO();
//        updateDAO1.updateEntity(modifyingStudent);

        /**
         * Here I DELETE an element
         */
//        Student student3 = new Student(21);
//        service.deleteStudentDAO(student3);

        /**
         * Here I find an element by ID
         */
//        Student student2 = new Student(7);
//        service.getStudentDAOById(7);
//        LOGGER.info(student2.toString() + student2.getName());

        /**
         * Here we create a list of student from the DB
         */
//        List<Student> studentList = service.listStudentSDAO();
//        for (Student student : studentList) {
//            LOGGER.info(student.toString() + student.getName());
//        }
    }
}

