//package org.example.DAO;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.JDBC.MyConnectionPool_ToDB;
//import org.example.entity.UserApp;
//import org.example.service.IDAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.example.JDBC.MyConnectionPool_ToDB.close;
//import static org.example.JDBC.MyConnectionPool_ToDB.getConnection;
//
//public class UserAppDAO implements IDAO<UserApp> {
//
//    private static final String SQL_SELECT = "SELECT id_user, username, password FROM users";
//    private static final String SQL_INSERT = "INSERT INTO users (username, password ) VALUES (?,?)";
//    private static final String SQL_UPDATE = "UPDATE users SET username = ?, password = ?  WHERE id_user = ?";
//    private static final String SQL_DELETE = "DELETE FROM users WHERE id_user = ?";
//    private static final String SQL_FIND_BY_ID = "SELECT FROM users WHERE id_user = ?";
//    private static final Logger LOGGER = LogManager.getLogger(UserAppDAO.class);
//
//    @Override
//    public List<UserApp> listEntity( ) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        UserApp userApp = null;
//        List<UserApp> userAppList = new ArrayList<>();
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int idUserApp = rs.getInt("id_user");
//                String userName = rs.getString("userName");
//                String password = rs.getString("password");
//                userApp = new UserApp(idUserApp, userName, password);
//                userApp.setId_userApp(idUserApp);
//                userApp.setUserName(userName);
//                userApp.setPassword(password);
//
//                userAppList.add(userApp);
//
//            }
//        } catch (SQLException e) {
//            LOGGER.debug(e);
//
//        } finally {
//            try {
//               // MyConnectionPool_ToDB.close(rs);
//                MyConnectionPool_ToDB.close(stmt);
//                MyConnectionPool_ToDB.close(conn);
//
//            } catch (SQLException e) {
//                LOGGER.debug(e);
//            }
//        }
//        return userAppList;
//    }
//
//    @Override
//    public int insertEntity(UserApp userApp) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = MyConnectionPool_ToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_INSERT);
//            stmt.setString(1, userApp.getUserName());
//            stmt.setString(2, userApp.getPassword());
//            LOGGER.info("Executing query: " + SQL_INSERT);
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            rows = stmt.executeUpdate();
//            LOGGER.info("Afected registers: " + rows);
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
//        return rows;
//    }
//
//    @Override
//    public UserApp getEntityBYId(UserApp userApp) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        userApp = null;
//        try {
//            conn = MyConnectionPool_ToDB.getConnection();
//            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
//            rs = stmt.executeQuery();
//            stmt.setInt(1, userApp.getId_userApp());
//            while (rs.next()) {
//                int idUserApp = rs.getInt("id_user");
//                userApp = new UserApp(idUserApp);
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
//        return userApp;
//    }
//
//    @Override
//    public int updateEntity(UserApp userApp) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = MyConnectionPool_ToDB.getConnection();
//            LOGGER.info("Executing query: " + SQL_UPDATE);
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, userApp.getUserName());
//            stmt.setString(2, userApp.getPassword());
//            stmt.setInt(3, userApp.getId_userApp());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            rows = stmt.executeUpdate();
//            LOGGER.info("Row affected: " + rows);
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
//        return rows;
//    }
//
//    @Override
//    public int deleteEntity(UserApp userApp) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = MyConnectionPool_ToDB.getConnection();
//            LOGGER.info("Executing query: " + SQL_DELETE);
//            stmt = conn.prepareStatement(SQL_DELETE);
//            stmt.setInt(1, userApp.getId_userApp());
//            //the next line update the state into the DB; used after-INSERT-UPDATE-DELETE
//            rows = stmt.executeUpdate();
//            LOGGER.info("Afected registers: " + rows);
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
//        return rows;
//    }
//}
