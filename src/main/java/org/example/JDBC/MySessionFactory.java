package org.example.JDBC;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MySessionFactory {

    private static MySessionFactory instance;
    private SqlSessionFactory factory;


    private MySessionFactory() {
        /**
         * In this file I get the resource already stated in that XML file
         */
        String resource = "MyBatis-config.XML";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resource);
            //this factory builds a new connection to my DATABASE
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MySessionFactory getInstance() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }

}
