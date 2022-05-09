package org.example.DAO;

import org.example.entity.Neighborhood;
import org.example.service.IEntity_DAO;

import java.util.List;

public class NeighborhoodDAO implements IEntity_DAO<Neighborhood> {
    @Override
    public List<Neighborhood> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Neighborhood entity) {
        return 0;
    }

    @Override
    public Neighborhood getEntityBYId(Neighborhood entity) {
        return null;
    }

    @Override
    public int updateEntity(Neighborhood entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Neighborhood entity) {
        return 0;
    }
}
