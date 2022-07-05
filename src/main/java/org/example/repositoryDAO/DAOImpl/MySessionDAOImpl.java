package org.example.repositoryDAO.DAOImpl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JDBC.MySessionFactory;
import org.example.repositoryDAO.IMySessionFactoryDAO;

public class MySessionDAOImpl implements IMySessionFactoryDAO {

    private static final MySessionFactory instance = MySessionFactory.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(MySessionDAOImpl.class);

    @Override
    public String getVersionMySql() {

        String version = " ";
        SqlSession session = null;
        try {
            session = instance.getFactory().openSession();
            version = session.selectOne("mySqlVersion");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return version;
    }

}
