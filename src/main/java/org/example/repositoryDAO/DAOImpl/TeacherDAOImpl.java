package org.example.repositoryDAO.DAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.Teacher;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.ITeacherDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements ITeacherDAO {

    private static final String SQL_SELECT_ALL = "SELECT id_teacher, name, surname, phoneNumber, fk_id_address FROM teachers";
    private static final String SQL_INSERT = "INSERT INTO teachers (id_teacher, name, surname, phoneNumber,fk_id_address) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE teachers SET name = ?, surname = ?, phoneNumber = ?, fk_id_address = ? WHERE id_teacher = ?";
    private static final String SQL_DELETE = "DELETE FROM teachers WHERE id_teacher = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM teachers WHERE id_teacher = ? ";
    private static final Logger LOGGER = LogManager.getLogger(TeacherDAOImpl.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();

    private Teacher convertInfo(ResultSet rs) throws DAO_exception {
        Teacher teacher = null;

        try {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phoneNumber");
            int fkAdress = rs.getInt("fk_id_address");
            teacher = new Teacher(name, surname, phone, fkAdress);
            teacher.setIdTeacher(rs.getInt("id_teacher"));

        } catch (SQLException e) {
            throw new DAO_exception("The teacher could not be created. ");
        }
        return teacher;
    }

    @Override
    public List<Teacher> list() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Teacher> teacher = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                teacher.add(convertInfo(rs));
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
        return teacher;
    }

    @Override
    public Teacher getById(Integer id) throws DAO_exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Teacher teacher = null;
        try {
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                teacher = convertInfo(rs);
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
        return teacher;
    }

    @Override
    public void update(Teacher teacher) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSurname());
            stmt.setString(3, teacher.getPhoneNumber());
            stmt.setInt(4, teacher.getTeacherAddress(5));
            stmt.setInt(5, teacher.getIdTeacher());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The teacher was not updated  ");
            }
        } catch (SQLException e) {
            LOGGER.debug(e);
        } finally {
            DBConnectionPool.getInstance().freeConnection(conn);
        }
    }

    @Override
    public void insert(Teacher teacher) throws DAO_exception, SQLException {
        conn.setAutoCommit(false);
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        try {
            stmt.setInt(1, teacher.getIdTeacher());
            stmt.setString(2, teacher.getName());
            stmt.setString(3, teacher.getSurname());
            stmt.setString(4, teacher.getPhoneNumber());
            stmt.setInt(5, teacher.getTeacherAddress(3));
            // stmt.setObject(5, teacher.getTeacherAddress();
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE

            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The teacher was not inserted ");
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
    public void delete(Teacher teacher) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, teacher.getIdTeacher());
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
