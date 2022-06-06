package org.example.repositoryDAO.DAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.DBConnectionPool;
import org.example.entity.Course;
import org.example.entity.Course;
import org.example.entity.Course;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.ICourseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO {
    private static final String SQL_SELECT_ALL = "SELECT id_course, courseName, celatorName FROM courses";
    private static final String SQL_INSERT = "INSERT INTO courses(id_course, courseName, celatorName) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE courses SET  courseName = ?, celatorName = ? WHERE id_course = ?";
    private static final String SQL_DELETE = "DELETE FROM courses WHERE id_course = ? ";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM courses WHERE id_course = ? ";
    private static final Logger LOGGER = LogManager.getLogger(CourseDAOImpl.class);
    private Connection conn = DBConnectionPool.getInstance().getConnection();

    private Course converInfo(ResultSet rs) throws DAO_exception {
        String courseName = null;
        Course course = null;
        try {
            courseName = rs.getString("courseName");
            String celatorName = rs.getString("celatorName");
            course = new Course(courseName,celatorName);
            course.setIdCourse(rs.getInt("id_course"));

        } catch (SQLException e) {
            throw new DAO_exception("The course could not be created. ", e);
        }
        return course;
    }

    @Override
    public List<Course> list() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                courseList.add(converInfo(rs));
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
        return courseList;
    }

    @Override
    public Course getById(Integer id) throws DAO_exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Course course = null;
        try {
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                course = converInfo(rs);
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
        return course;
    }

    @Override
    public void update(Course course) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCelatorName());
            stmt.setInt(3, course.getIdCourse());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The course was not updated  ");
            }
        } catch (SQLException e) {
            LOGGER.debug(e);
        } finally {
            DBConnectionPool.getInstance().freeConnection(conn);
        }
    }

    @Override
    public void insert(Course course) throws DAO_exception, SQLException {
        conn.setAutoCommit(false);
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        try {
            stmt.setInt(1, course.getIdCourse());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getCelatorName());
            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE

            if (stmt.executeUpdate() == 0) {
                throw new DAO_exception("The course was not inserted ");
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
    public void delete(Course id) throws DAO_exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id.getIdCourse());
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
