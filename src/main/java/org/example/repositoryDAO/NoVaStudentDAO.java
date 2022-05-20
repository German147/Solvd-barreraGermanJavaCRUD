//package org.example.repositoryDAO;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.JDBC.MyConectionToDB;
//import org.example.entity.Student;
//import org.example.service.IEntity_DAO;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//import java.util.List;
//
//import static org.example.JDBC.MyConectionToDB.*;
//
//public class IStudentDAOService implements IEntity_DAO<Student> {
//
//    private static final String SQL_SELECT = "SELECT id_student, name, surname, phoneNumber FROM students";
//    private static final String SQL_INSERT = "INSERT INTO students(name, surname, phoneNumber) VALUES (?,?,?)";
//    private static final String SQL_UPDATE = "UPDATE students SET name = ?, surname = ?, phoneNumber = ? WHERE id_student = ?";
//    private static final String SQL_DELETE = "DELETE FROM students WHERE id_student = ?";
//    private static final String SQL_FIND_BY_ID = "SELECT FROM students WHERE id_student = ?";
//    private static final Logger LOGGER = LogManager.getLogger(IStudentDAOService.class);
//
//    @Override
//    public List<Student> listEntity() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Student student = null;
//        List<Student> studentList = new ArrayList<>();
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int idStudent = rs.getInt("id_student");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String phoneNumber = rs.getString("phoneNumber");
//                student = new Student(idStudent, name, surname, phoneNumber);
//                studentList.add(student);
//            }
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//
//        } finally {
//            try {
//                MyConectionToDB.close(rs);
//                MyConectionToDB.close(stmt);
//                MyConectionToDB.close(conn);
//
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return studentList;
//    }
//
//    @Override
//    public int insertEntity(Student student) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registres = 0;
//        try {
//            conn = MyConectionToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_INSERT);
//            stmt.setString(1, student.getName());
//            stmt.setString(2, student.getSurname());
//            stmt.setString(3, student.getPhoneNumber());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            registres = stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return registres;
//    }
//
//    @Override
//    public Student getEntityBYId(Student student) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        student = null;
//        try {
//            conn = MyConectionToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
//            rs = stmt.executeQuery();
//            stmt.setInt(1, student.getIdStudent());
//            while (rs.next()) {
//                int idStudent = rs.getInt("id_student");
//                student = new Student(idStudent);
//            }
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return student;
//    }
//
//    @Override
//    public int updateEntity(Student student) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registres = 0;
//        try {
//            conn = MyConectionToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, student.getName());
//            stmt.setString(2, student.getSurname());
//            stmt.setString(3, student.getPhoneNumber());
//            stmt.setInt(4, student.getIdStudent());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            registres = stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return registres;
//    }
//
//    @Override
//    public int deleteEntity(Student student) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registres = 0;
//        try {
//            conn = MyConectionToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_DELETE);
//            stmt.setInt(1, student.getIdStudent());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            registres = stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            try {
//                close(stmt);
//                close(conn);
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return registres;
//    }
//}
