package org.example.DAO;

import org.example.entity.Lecture;
import org.example.service.IEntity_DAO;

import java.util.List;

public class LectureDAO implements IEntity_DAO<Lecture> {
    @Override
    public List<Lecture> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Lecture entity) {
        return 0;
    }

    @Override
    public Lecture getEntityBYId(Lecture entity) {
        return null;
    }

    @Override
    public int updateEntity(Lecture entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Lecture entity) {
        return 0;
    }
}
