package org.example.DAO;

import org.example.entity.City;
import org.example.service.IEntity_DAO;

import java.util.List;

public class CityDAO implements IEntity_DAO<City> {
    @Override
    public List<City> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(City entity) {
        return 0;
    }

    @Override
    public City getEntityBYId(City entity) {
        return null;
    }

    @Override
    public int updateEntity(City entity) {
        return 0;
    }

    @Override
    public int deleteEntity(City entity) {
        return 0;
    }
}
