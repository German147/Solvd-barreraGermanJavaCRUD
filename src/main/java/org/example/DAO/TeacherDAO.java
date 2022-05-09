package org.example.DAO;

import org.example.entity.Tutor;
import org.example.service.IEntity_DAO;

import java.util.List;

public class TeacherDAO implements IEntity_DAO<Tutor> {
    @Override
    public List<Tutor> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Tutor entity) {
        return 0;
    }

    @Override
    public Tutor getEntityBYId(Tutor entity) {
        return null;
    }

    @Override
    public int updateEntity(Tutor entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Tutor entity) {
        return 0;
    }
}
