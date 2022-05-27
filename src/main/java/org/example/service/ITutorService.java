package org.example.service;

import org.example.entity.Tutor;

import java.util.List;

public interface ITutorService {

    List<Tutor> findAllTutors();

    Tutor getTutorById(Integer integer);

    void updateTutor(Tutor tutor);

    void insertTutor(Tutor tutor);

    void deleteTutorById(Tutor integer);
}
