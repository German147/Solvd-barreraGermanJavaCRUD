//package org.example.DAO;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.JDBC.DBConnectionPool;
//import org.example.entity.Student;
//import org.example.repositoryDAO.IDAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AnuladoStudentDAO implements IDAO<Student> {
//
//    private static final String SQL_SELECT = "SELECT id_student, name, surname, phoneNumber FROM students";
//    private static final String SQL_INSERT = "INSERT INTO students(id_student, name, surname, phoneNumber) VALUES (?,?,?,?)";
//    private static final String SQL_UPDATE = "UPDATE students SET name = ?, surname = ?, phoneNumber = ? WHERE id_student = ?";
//    private static final String SQL_DELETE = "DELETE FROM students WHERE id_student = ?";
//    private static final String SQL_FIND_BY_ID = "SELECT FROM students WHERE id_student = ?";
//    private static final Logger LOGGER = LogManager.getLogger(AnuladoStudentDAO.class);
//
//    @Override
//    public List<Student> listEntity() {
//        ResultSet rs = null;
//        Student student = null;
//        Connection conn = DBConnectionPool.getInstance().getConnection();
//        List<Student> studentList = new ArrayList<>();
//        try {
//            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int idStudent = rs.getInt("id_student");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String phoneNumber = rs.getString("phoneNumber");
//                student = new Student(idStudent, name, surname, phoneNumber);
//                studentList.add(student);
//            }
//        } catch (SQLException sqle) {
//            LOGGER.error(sqle.getMessage());
//        } finally {
//            DBConnectionPool.getInstance().freeConnection(conn);
//        }
//        return studentList;
//    }
//
//    @Override
//    public int insertEntity(Student entity) throws SQLException {
//        Student student = null;
//        Connection conn = DBConnectionPool.getInstance().getConnection();
//        conn.setAutoCommit(false);
//        int registres = 0;
//        try {
//            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
//            stmt.setInt(1, 12);
//            stmt.setString(2, "Jose");
//            stmt.setString(3, "Barrera");
//            stmt.setString(4, "45456879");
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            registres = stmt.executeUpdate();
//            conn.commit();
//        } catch (SQLException e) {
//            conn.rollback();
//            LOGGER.debug(e.getMessage());
//        } finally {
//            DBConnectionPool.getInstance().freeConnection(conn);
//        }
//        return registres;
//    }
//
//    @Override
//    public Student getEntityBYId(Integer integer) {
//
//        Connection conn = DBConnectionPool.getInstance().getConnection();
//        ResultSet rs = null;
//        Student student = null;
//        try {
//            PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_ID);
//            rs = stmt.executeQuery();
//            stmt.setInt(1, student.getIdStudent());
//            while (rs.next()) {
//                int idStudent = rs.getInt("id_student");
//                student = new Student(idStudent);
//
//            }
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            DBConnectionPool.getInstance().freeConnection(conn);
//        }
//        return student;
//    }
//
//    @Override
//    public int updateEntity(Student entity) {
//        Connection conn = DBConnectionPool.getInstance().getConnection();
//        Student student = null;
//        int registres = 0;
//        try {
//            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
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
//            DBConnectionPool.getInstance().freeConnection(conn);
//        }
//        return registres;
//    }
//
//    @Override
//    public int deleteEntity(Student student) {
//        Connection conn = DBConnectionPool.getInstance().getConnection();
//        int registres = 0;
//        try {
//            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
//            stmt.setInt(1, student.getIdStudent());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            registres = stmt.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//        } finally {
//            DBConnectionPool.getInstance().freeConnection(conn);
//        }
//        return registres;
//    }
//}
