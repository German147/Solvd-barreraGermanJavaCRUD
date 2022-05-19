package org.example.repositoryDAO.DAOImpl;


import org.example.entity.Tutor;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.ITutorDAO;

import java.sql.SQLException;
import java.util.List;

public class TutorDAOImpl implements ITutorDAO {


    @Override
    public List<Tutor> list() {
        return null;
    }

    @Override
    public Tutor getById(Integer v) throws DAO_exception {
        return null;
    }

    @Override
    public void update(Tutor v) throws DAO_exception {

    }

    @Override
    public void insert(Tutor v) throws DAO_exception, SQLException {

    }

    @Override
    public void delete(Tutor v) throws DAO_exception {

    }
}
