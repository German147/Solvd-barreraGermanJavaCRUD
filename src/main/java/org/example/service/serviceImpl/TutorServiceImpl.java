package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Tutor;
import org.example.repositoryDAO.DAOImpl.TutorDAOImpl;
import org.example.service.ITutorDAOService;

import java.util.List;

public class TutorServiceImpl implements ITutorDAOService {

    private static final Logger LOGGER = LogManager.getLogger(TutorServiceImpl.class);
    private static TutorDAOImpl tutorDAOImpl = new TutorDAOImpl();

    @Override
    public List<Tutor> listTutorDAO() {
        TutorDAOImpl tutorDAOimpl = null;
        return null;
    }

    @Override
    public Tutor getTutorDAOById(Integer integer) {
        return null;
    }

    @Override
    public Tutor updateTutorDAO(Tutor tutor) {
        return null;
    }

    @Override
    public void insertTutorDAO(Tutor tutor) {

    }

    @Override
    public void deleteTutorById(Integer integer) {

    }
}
