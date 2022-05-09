package org.example.JDBC;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public final class DBConnectionPool extends Pool {

    private static final Logger LOGGER = LogManager.getLogger(DBConnectionPool.class);
    private int checkedOutConnInUse;
    // Here I declare a  Vector as a container for storing the generated connection objects
    private Vector<Connection> freeConnections = new Vector<>();
    private String username = null;
    private String password = null;
    private String db_url = null;
    private static int numIdleNonActiveConnNum = 0;
    private static int numActiveConnections = 0;
    private static DBConnectionPool pool = null; //Connection pool instance variable

    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    //Here I declare the connection pool constructor
    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection conn = newConnection();
                if (conn != null) {
                    //Here I add a connection object to the Vector container
                    freeConnections.addElement(conn);
                    //now I have to record the total number of connection
                    numActiveConnections++;
                }
            }
            LOGGER.info("Core connection pool initialization completed , The size is " + numActiveConnections);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void init() throws IOException {
        InputStream inputStream = DBConnectionPool.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.db_url = properties.getProperty("datasource.url");
        this.username = properties.getProperty("datasource.username");
        this.password = properties.getProperty("datasource.password");
        this.driverName = properties.getProperty("driver.class.name");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    private Connection newConnection() {
        Connection conn = null;
        try {
            if (username == null) {
                conn = DriverManager.getConnection(db_url);
            } else {
                conn = DriverManager.getConnection(db_url, username, password);
            }
            LOGGER.info("Here a new connection was created successfully");
        } catch (SQLException e) {
            LOGGER.info(" Unable to create this URL The connection of " + db_url);
            LOGGER.error(e.getMessage());
        }
        return conn;
    }

    /**
     * A brief explanation of The singleton pattern ,to get an available connection.
     * The logical steps to get the connection
     * * 1, First determine whether there is a connection in the container ,
     * If there is, take... From the first place of the container , Remove and remove from the container ,
     * If an invalid connection is obtained, it will be rejected
     * * 2, If there is no connection in the container ,
     * Determine whether the maximum number of connections is,
     * Judge whether the current number of
     * connections is less than the maximum number of connections , If it is , Create a new connection
     */

    @Override
    public synchronized Connection getConnection() {

        Connection conn = null;
        if (freeConnections.size() > 0) {
            //I free connections
            numIdleNonActiveConnNum--;
            conn = freeConnections.firstElement();
            freeConnections.removeElement(0);
            LOGGER.info("Get connections from the core connection pool , Current connection pool empty remainder : " + numIdleNonActiveConnNum);
            try {
                if (conn.isClosed()) {
                    LOGGER.info(" Remove an invalid connection from the connection pool ");
                    conn = getConnection();
                }
            } catch (SQLException e) {
                LOGGER.info(" Remove an invalid connection from the connection pool ");
                LOGGER.error(e.getMessage());
                conn = getConnection();
            }
        } else if (maxConnect == 0 || checkedOutConnInUse < maxConnect) {
            // There is no idle connection and the current connection is less than the maximum allowed value ,
            // The maximum value is 0 There is no limit to
            conn = newConnection();
        }
        if (conn != null) {
            //Current connection +1
            checkedOutConnInUse++;
        }
        numActiveConnections++;

        return conn;
    }

    @Override
    public Connection getConnection(long timeOut) {

        long startTime = System.currentTimeMillis();
        Connection conn;
        while ((conn = getConnection()) == null) {
            try {
                wait(timeOut); // Thread waiting
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
            if ((System.currentTimeMillis() - startTime) >= timeOut) {
                //Here if the timeOut , then return to .
                return null;
            }
        }
        return conn;
    }

    @Override
    protected synchronized void release() {
        try {
            //Here I store the current connections to the enumeration
            Enumeration<Connection> allConnections = freeConnections.elements();

            //Now I use a loop to close all connections
            while (allConnections.hasMoreElements()) {
                // Here, if this enumeration object has at least one element available ,
                // Returns the next element of this enumeration object
                Connection connection = allConnections.nextElement();
                try {
                    connection.close();
                    //and here I take out by one,  the active connections
                    numIdleNonActiveConnNum--;
                } catch (SQLException e) {
                    LOGGER.info(" Unable to close connection in connection pool ");
                    LOGGER.error(e.getMessage());
                }
            }
            freeConnections.removeAllElements();
            numActiveConnections = 0;
        } finally {
            super.release();
        }
    }

    // If I no longer use a connection object , This method can be called
    // to release the object to the connection pool
    @Override
    public void freeConnection(Connection conn) {
        freeConnections.addElement(conn);
        numIdleNonActiveConnNum++;
        checkedOutConnInUse--;
        numActiveConnections--;
        //notifyAll();
        LOGGER.info(" Return connection to connection pool," +
                " now the number of free connections in the connection pool is ："
                + numIdleNonActiveConnNum +
                ", The active connection is ："
                + numActiveConnections +
                " , The connection in use is "
                + checkedOutConnInUse);
    }

    @Override
    public int getNum() {
        return numIdleNonActiveConnNum;
    }

    @Override
    public int getNumActive() {
        return numActiveConnections;
    }
}
