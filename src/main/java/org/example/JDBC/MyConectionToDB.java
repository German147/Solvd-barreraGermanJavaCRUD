package org.example.JDBC;

import org.jetbrains.annotations.NotNull;

import java.sql.*;


public class MyConectionToDB {

    private static final String JDBC = "jdbc:mysql://localhost:3306/barrera_german_crud";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
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
