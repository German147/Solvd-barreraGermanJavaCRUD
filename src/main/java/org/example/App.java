package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;
import org.example.util.StudentBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Application for Practice Java CRUD
 */
public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        StudentBuilder student1 = new StudentBuilder();
        Student student = student1.buildStudent();

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(student,new File("result8.XML"));
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(student, xmlWriter);
            System.out.println(xmlWriter.toString());

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader xmlReader = new StringReader(xmlWriter.toString());
            Student outStudent = (Student) unmarshaller.unmarshal(xmlReader);
            System.out.println("This is the unmarshall " + outStudent);
        } catch (JAXBException e) {
            e.printStackTrace();
        }





//ANDREW APPROACH
//            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//          //  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(student,new File("result7.XML"));









//        TutorServiceImpl service = new TutorServiceImpl();
//        Tutor miguel = new Tutor(4,"Brandon","Ferreira","78946512");
//        service.insertTutorDAO(miguel);
//
//        List<Tutor> tutorList = new ArrayList<>();
//        tutorList = service.listTutorDAO();
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

