package org.example.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Tutor;
import org.example.exceptions.DAO_exception;
import org.example.repositoryDAO.MySqlDAOImpl.TutorDAOImpl;
import org.example.service.ITutorService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorServiceImpl implements ITutorService {

    private static final Logger LOGGER = LogManager.getLogger(TutorServiceImpl.class);
    private static TutorDAOImpl tutorDAOImpl = new TutorDAOImpl();

    @Override
    public List<Tutor> findAllTutors() {
        TutorDAOImpl tutor = null;
        List<Tutor> tutorList = new ArrayList<>();
        if (tutor == null) {
            tutor = new TutorDAOImpl();
            tutorList = tutorDAOImpl.list();
        }
        return tutorList;
    }

    @Override
    public Tutor getTutorById(Integer integer) {
        Tutor tutor = null;
        try {
            tutor = tutorDAOImpl.getById(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
        return tutor;
    }

    @Override
    public void updateTutor(Tutor tutor) {
        try {
            tutorDAOImpl.update(tutor);
        } catch (DAO_exception e) {
            LOGGER.info("The tutor could not be updated");
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void insertTutor(Tutor tutor) {
        try {
            tutorDAOImpl.insert(tutor);
        } catch (DAO_exception | SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteTutorById(Tutor integer) {
        try {
            tutorDAOImpl.delete(integer);
        } catch (DAO_exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
