package org.example.repositoryDAO.MySqlDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.*;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.IStudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

    private static final String SQL_SELECT_ALL = "SELECT id_student, name, surname, phoneNumber FROM students";
    private static final String SQL_INSERT = "INSERT INTO students(id_student, name, surname, phoneNumber) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE students SET name = ?, surname = ?, phoneNumber = ? WHERE id_student = ?";
    private static final String SQL_DELETE = "DELETE FROM students WHERE id_student = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM students WHERE id_student = ? ";
    private static final Logger LOGGER = LogManager.getLogger(StudentDAOImpl.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();


    private Student converInfo(ResultSet rs) throws DAO_exception {
        String name = null;
        Student student = null;

        try {
            name = rs.getString("name");
            String surname = rs.getString("surname");
            String phoneNumber = rs.getString("phoneNumber");
            student.setIdStudent(rs.getInt("id_student"));
            student = new Student(name, surname, phoneNumber);


        } catch (SQLException e) {
            throw new DAO_exception("The student could not be created. ", e);
        }
        return student;
    }

    @Override
    public List<Student> list() {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Student> student = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                student.add(converInfo(rs));
            }
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            //stmt.executeUpdate();
        } catch (SQLException | DAO_exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
            DBConnectionPool.getInstance().freeConnection(conn);
        }
        return student;
    }

    @Override
    public Student getById(Integer id) throws DAO_exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Student student = null;
        try {
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                student = converInfo(rs);
            } else {
                throw new DAO_exception("This register is not found ");
            }
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
           // stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error en esta sentencia SQL");
            LOGGER.debug(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAO_exception("There is an error at closing rs", e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new DAO_exception("There is an error at closing stmt", e);
                }
                DBConnectionPool.getInstance().freeConnection(conn);
            }
        }
        return student;
    }

    @Override
    public void update(Student student) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getPhoneNumber());
            stmt.setInt(4, student.getIdStudent());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The student was not updated  ");
            }
        } catch (SQLException e) {
            LOGGER.debug(e);
        } finally {
            DBConnectionPool.getInstance().freeConnection(conn);
        }

    }

    @Override
    public void insert(Student student) throws DAO_exception, SQLException {
        conn.setAutoCommit(false);
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        try {
            stmt.setInt(1, student.getIdStudent());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getSurname());
            stmt.setString(4, student.getPhoneNumber());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE

            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The student was not inserted ");
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.debug(e.getMessage());
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new DAO_exception("SQL Error ", ex);
                }
            DBConnectionPool.getInstance().freeConnection(conn);
        }
    }

    @Override
    public void delete(Student student) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, student.getIdStudent());
            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The delete could not be executed");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnectionPool.getInstance().freeConnection(conn);
        }
    }
}
