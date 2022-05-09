package org.example.DAO;

import org.example.entity.Country;
import org.example.service.IEntity_DAO;

import java.util.List;

public class CountryDAO implements IEntity_DAO<Country> {
    @Override
    public List<Country> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Country entity) {
        return 0;
    }

    @Override
    public Country getEntityBYId(Country entity) {
        return null;
    }

    @Override
    public int updateEntity(Country entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Country entity) {
        return 0;
    }
}
