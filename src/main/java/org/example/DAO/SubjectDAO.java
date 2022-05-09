package org.example.DAO;

import org.example.entity.Subject;
import org.example.service.IEntity_DAO;

import java.util.List;

public class SubjectDAO implements IEntity_DAO<Subject> {
    @Override
    public List<Subject> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Subject entity) {
        return 0;
    }

    @Override
    public Subject getEntityBYId(Subject entity) {
        return null;
    }

    @Override
    public int updateEntity(Subject entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Subject entity) {
        return 0;
    }
}
