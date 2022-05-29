package org.example;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Student;
import org.example.entity.Tutor;
import org.example.service.serviceImpl.TutorServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Application for Practice Java CRUD
 */
public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        ObjectMapper om = new ObjectMapper();


        List<Student> studentList =
        File file = new File("reultJSON_1");
        if(!file.exists()){
            try {
                file.createNewFile();
                om.writeValue(file,studentList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        
//        JavaType type = om.getTypeFactory().constructCollectionType(List.class, Student.class);

//        try {
//            List<Student> studentList = om.readValue(new File("reultJSON_1"),type);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        TutorServiceImpl service = new TutorServiceImpl();
//        Tutor miguel = new Tutor(4,"Brandon","Ferreira","78946512");
//        service.insertTutorDAO(miguel);
//
//        List<Tutor> tutorList = new ArrayList<>();
//        tutorList = service.findAllTutors();
//        for (Tutor tutor : tutorList) {
//            LOGGER.info(tutor.toString()+tutor.getName()+tutor.getSurname()+tutor.getPhoneNumber());
//        }
//                StudentServiceImpl service = new StudentServiceImpl();
//                Student student1 = new Student("Sebastian","Kulfprit","789465");
//        service.insertStudentDAO(student1);

//        StudentServiceImpl service = new StudentServiceImpl();
//        List<Student> studentList1 = service.listStudentSDAO();
//        for (Student student : studentList1) {
//            LOGGER.info(student.toString() + student.getName());
//        }

        /**
         * Here I INSERT a new student to the DB
         */
//        StudentServiceImpl service = new StudentServiceImpl();
//        Student student1 = new Student("Tim","Ibraimovich","789465");
//        service.insertStudentDAO(student1);
        /**
         * Here I UPDATE an existen element into the DB
         */
        // IStudentService studentDAO = new IStudentService();
//        Student modifyingStudent = new Student(7, "Patrick", "Schutts", "78946513");
//        IStudentService updateDAO1 = new IStudentService();
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

