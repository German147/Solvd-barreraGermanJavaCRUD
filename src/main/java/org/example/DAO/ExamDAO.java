package org.example.DAO;

import org.example.entity.Exam;
import org.example.service.IEntity_DAO;

import java.util.List;

public class ExamDAO implements IEntity_DAO<Exam> {
    @Override
    public List<Exam> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Exam entity) {
        return 0;
    }

    @Override
    public Exam getEntityBYId(Exam entity) {
        return null;
    }

    @Override
    public int updateEntity(Exam entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Exam entity) {
        return 0;
    }
}
