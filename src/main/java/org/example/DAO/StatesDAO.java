package org.example.DAO;

import org.example.entity.States;
import org.example.service.IEntity_DAO;

import java.util.List;

public class StatesDAO implements IEntity_DAO<States> {
    @Override
    public List<States> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(States entity) {
        return 0;
    }

    @Override
    public States getEntityBYId(States entity) {
        return null;
    }

    @Override
    public int updateEntity(States entity) {
        return 0;
    }

    @Override
    public int deleteEntity(States entity) {
        return 0;
    }
}
