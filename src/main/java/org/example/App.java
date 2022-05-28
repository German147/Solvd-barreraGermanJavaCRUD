package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Application for Practice Java CRUD
 */
public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(7, "Michael", "Johanssen", "1345678");
        Student student2 = new Student(14, "Hoogart", "Tfany", "132465");
        Student student3 = new Student(24, "Lucas", "George", "45674125");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        List<Lecture> lectureList = new ArrayList<>();
        Lecture lecture = new Lecture(45, "How to implement JaxB");
        Lecture lecture2 = new Lecture(40, "Marshilling JaxB");
        Lecture lecture3 = new Lecture(42, "UnMarshalling JaxB");
        lectureList.add(lecture);
        lectureList.add(lecture2);
        lectureList.add(lecture3);

        List<Lecture> jacsonLectures = new ArrayList<>();
        Lecture jacLecture1 = new Lecture(21, "Jacson Class1");
        Lecture jacLecture2 = new Lecture(22, "JacsonFolderst 2");
        Lecture jacLecture3 = new Lecture(23, "Parsing Jacso 2");
        jacsonLectures.add(jacLecture1);
        jacsonLectures.add(jacLecture2);
        jacsonLectures.add(jacLecture3);

        List<Subject> subjectList = new ArrayList<>();
        Subject subject1 = new Subject(21, "Xml Lecture", lectureList);
        Subject subject2 = new Subject(21, "Jacson Lecture", jacsonLectures);
        subjectList.add(subject1);
        subjectList.add(subject2);

        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher(61, "Tomas", "Burgetti", "457812");
        Teacher teacher1 = new Teacher(62, "Jim", "Parrel", "457812");
        Teacher teacher2 = new Teacher(63, "Ciro", "Pachiarenni", "457812");
        teacherList.add(teacher);
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        Course course = new Course();
        course.setCourseName("3er A");
        course.setIdCourse(001);
        course.setCourseStudentList(studentList);
        course.setCourseSubjectList(subjectList);
        course.setCourseTeacherList(teacherList);


        MedicalCertificates md = new MedicalCertificates();
        md.setDoctorName("Lucas");
        md.setExpireDate(new Date(22 - 02 - 2005));
        md.setIdMedicalCertificate(0024);

        List<Behaviour_Attention_Call> attention_callList = new ArrayList<>();
        Behaviour_Attention_Call bhCall = new Behaviour_Attention_Call();
        bhCall.setIdBehaviourCall(91);
        bhCall.setDateOfBehaviourCall("14-05-07");
        bhCall.setNumberOfCall(1);
        bhCall.setTutorAwareOf(true);
        Behaviour_Attention_Call bhCall1 = new Behaviour_Attention_Call();
        bhCall.setIdBehaviourCall(992);
        bhCall.setDateOfBehaviourCall("27-08-2021");
        bhCall.setNumberOfCall(2);
        bhCall.setTutorAwareOf(false);

        attention_callList.add(bhCall);
        attention_callList.add(bhCall1);

        List<Tutor> tutorList = new ArrayList<>();
        Tutor tutor = new Tutor(81, "Marcos", "Thomlinson", "457812");
        Tutor tutor1 = new Tutor(82, "Tim", "Addams", "465124578");
        Tutor tutor2 = new Tutor(83, "Judy", "Cunnington", "963568923");

        tutorList.add(tutor);
        tutorList.add(tutor1);
        tutorList.add(tutor2);

        Student student = new Student();
        student.setIdStudent(68);
        student.setName("Leandro");
        student.setSurname("Sanchex");
        student.setPhoneNumber("123456");
        student.setStudentMedicalCertificates(md);
        student.setStudentCourse(course);
        student.setFirstDayAtSchool(new Date(02 - 03 - 2022));
        student.setAttention_callList(attention_callList);
        student.setStudentTutorList(tutorList);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
          //  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(student,new File("result7.XML"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


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

