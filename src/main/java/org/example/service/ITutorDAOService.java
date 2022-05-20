package org.example.service;

import org.example.entity.Tutor;

import java.util.List;

public interface ITutorDAOService {

    List<Tutor> listTutorDAO();

    Tutor getTutorDAOById(Integer integer);

    Tutor updateTutorDAO(Tutor tutor);

    void insertTutorDAO(Tutor tutor);

    void deleteTutorById(Integer integer);
}
