package org.example.DAO;

import org.example.service.IEntity_DAO;

import java.util.List;

public class Tutor implements IEntity_DAO<org.example.entity.Tutor> {
    @Override
    public List<org.example.entity.Tutor> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(org.example.entity.Tutor entity) {
        return 0;
    }

    @Override
    public org.example.entity.Tutor getEntityBYId(org.example.entity.Tutor entity) {
        return null;
    }

    @Override
    public int updateEntity(org.example.entity.Tutor entity) {
        return 0;
    }

    @Override
    public int deleteEntity(org.example.entity.Tutor entity) {
        return 0;
    }
}
