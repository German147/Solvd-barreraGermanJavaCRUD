package org.example.JDBC;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Properties;


public class MyConectionToDB {

    private static String JDBC = null;
    private static String JDBC_USER = null;
    private static String JDBC_PASSWORD = null;


    public static final Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        JDBC = properties.getProperty("driver.class.name");
        JDBC_USER = properties.getProperty("datasource.username");
        JDBC_PASSWORD = properties.getProperty("datasource.password");
        return DriverManager.getConnection(JDBC, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(@NotNull Statement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }
    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
