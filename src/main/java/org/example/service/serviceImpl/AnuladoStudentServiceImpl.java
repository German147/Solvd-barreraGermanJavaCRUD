//package org.example.service.serviceImpl;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.DAO.AnuladoStudentDAO;
//import org.example.entity.Student;
//import org.example.service.ICreateSomething;
//import org.example.service.IPrintSomething;
//import org.example.service.IStudentService;
//
//import java.util.List;
//import java.util.Optional;
//
//public class StudentServiceImpl implements IStudentService {
//
//    private static final Logger LOGGER = LogManager.getLogger(StudentServiceImpl.class);
//
//    @Override
//    public ICreateSomething<List<Student>> studentList() {
//        IPrintSomething print = () -> LOGGER.info("Let's create a list of student: ");
//        print.IPrintSomething();
//        ICreateSomething<List<Student>> studentList = () -> {
//            AnuladoStudentDAO anuladoStudentDAO = new AnuladoStudentDAO();
//            List<Student> listOfStudent = anuladoStudentDAO.listEntity();
//            return listOfStudent;
//        };
//        return studentList;
//    }
//
//    @Override
//    public Optional<Student> getStudentById(Integer integer) {
//        AnuladoStudentDAO anuladoStudentDAO = new AnuladoStudentDAO();
//        Student student1 = new Student("Lean","Barrera","7898452");
//        anuladoStudentDAO.getEntityBYId(3);
//
//    return Optional.of(student1);
//    }
//
//    @Override
//    public void getBehaviourCallByStudentId() {
//
//    }
//
//    @Override
//    public void getMedicalCertificateByStudentId() {
//
//    }
//
//    @Override
//    public void getExamsByStudentId() {
//
//    }
//
//    @Override
//    public void getTutorByStudentId() {
//
//    }
//}
