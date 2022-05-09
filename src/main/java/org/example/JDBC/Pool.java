package org.example.JDBC;

import com.mysql.cj.jdbc.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Custom connection pool  getInstance(), return Pool The only example of ,
 * The constructor is executed on the first call
 * *  Constructors Pool
 * Call driver load loadDrivers() function ,createPool() Function to create
 * a connection pool ,loadDriver() Loading drive
 * * getConnection()
 * Return a connection instance ,getConnection(long time) Add time limit
 * * freeConnection(Connection con)
 * take con The connection instance returns the connection pool ,
 * *getnum()
 * Returns the number of free connections
 * * getnumActive()
 * Returns the number of connections currently
 * in use
 */

public abstract class Pool {

    private static final Logger LOGGER = LogManager.getLogger(Pool.class);
    public String propertiesName = "connection-INF.properties";

    private static Pool instance = null; //Here I define a unique instance
    protected int maxConnect = 10;       //Maximum connection allowed
    protected int normalConnect = 5;     //keep connections or default size to be initialized?
    protected String driverName = null;  //Drive StringName
    protected Driver driver = null;      // Driving Variable

    protected Pool() {
        try {
            init();
            loadDrivers();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }

    //Here I  Initialize all member variables read from the configuration file
    private void init() throws IOException {
        InputStream inputStream = Pool.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.driverName = properties.getProperty("driver.class.name");
        this.maxConnect = Integer.valueOf(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.valueOf(properties.getProperty("normalConnect"));
    }

    //Here I  Load and register all JDBC The driver
    private void loadDrivers() {

        try {
            driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e.getMessage());
        }

    }

    // Create connection pool
    public static Pool getInstance() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        if (instance == null) {
            synchronized (Pool.class) {
                if (instance == null) {
                    instance = (Pool) Class.forName("org.example.JDBC.Pool").newInstance();
                    instance.init();
                }
            }
        }
        return instance;
    }

    //here I Get an available connection , If not, create a connection , And less than the maximum connection limit
    public abstract Connection getConnection();

    //Here I Get a connection , There is a time limit
    public abstract Connection getConnection(long time);


    // Return the connection to the connection pool
    public abstract void freeConnection(Connection conn);

    // Returns the current number of idle connections /NonActive connections
    public abstract int getNum();

    // Returns the number of connections for the current job
    public abstract int getNumActive();

    protected synchronized void release() {

        // Here I Undo drive
        try {
            DriverManager.deregisterDriver(driver);
            LOGGER.info(" I revoke JDBC The driver " + driver.getClass().getName());
        } catch (SQLException e) {
            LOGGER.info(" Can't undo JDBC Driver registration ：" + driver.getClass().getName());
            LOGGER.error(e.getMessage());
        }
    }

}
