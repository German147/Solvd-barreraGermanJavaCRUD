package org.example.repositoryDAO.DAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.Tutor;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.ITutorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorDAOImpl implements ITutorDAO {
    private static final String SQL_SELECT_ALL = "SELECT id_tutor, name, surname, phoneNumber FROM tutors";
    private static final String SQL_INSERT = "INSERT INTO tutors (id_tutor, name, surname, phoneNumber) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tutors SET name = ?, surname = ?, phoneNumber = ? WHERE id_tutor = ?";
    private static final String SQL_DELETE = "DELETE FROM tutors WHERE id_tutor = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM tutors WHERE id_tutor = ? ";
    private static final Logger LOGGER = LogManager.getLogger(StudentDAOImpl.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();

    private Tutor converInfo(ResultSet rs) throws DAO_exception {
        String name = null;
        Tutor tutor = null;
        try {
            name = rs.getString("name");
            String surname = rs.getString("surname");
            String phoneNumber = rs.getString("phoneNumber");
             tutor= new Tutor(name, surname, phoneNumber); tutor.setIdTutor(rs.getInt("id_tutor"));
        } catch (SQLException e) {
            throw new DAO_exception("The tutor could not be created. ", e);
        }
        return tutor;
    }

    @Override
    public List<Tutor> list() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tutor> tutor = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tutor.add(converInfo(rs));
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
        return tutor;
    }

    @Override
    public Tutor getById(Integer id) throws DAO_exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tutor tutor = null;
        try {
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                tutor = converInfo(rs);
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
        return tutor;
    }

    @Override
    public void update(Tutor tutor) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tutor.getName());
            stmt.setString(2, tutor.getSurname());
            stmt.setString(3, tutor.getPhoneNumber());
            stmt.setInt(4, tutor.getIdTutor());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The tutor was not updated  ");
            }
        } catch (SQLException e) {
            LOGGER.debug(e);
        } finally {
            DBConnectionPool.getInstance().freeConnection(conn);
        }
    }

    @Override
    public void insert(Tutor tutor) throws DAO_exception, SQLException {
        conn.setAutoCommit(false);
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        try {
            stmt.setInt(1, tutor.getIdTutor());
            stmt.setString(2, tutor.getName());
            stmt.setString(3, tutor.getSurname());
            stmt.setString(4, tutor.getPhoneNumber());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE

            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The tutor was not inserted ");
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
    public void delete(Tutor tutor) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tutor.getIdTutor());
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
