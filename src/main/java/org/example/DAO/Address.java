package org.example.DAO;

import org.example.entity.Adress;
import org.example.service.IEntity_DAO;

import java.util.List;

public class Address implements IEntity_DAO<Adress> {
    @Override
    public List<Adress> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Adress entity) {
        return 0;
    }

    @Override
    public Adress getEntityBYId(Adress entity) {
        return null;
    }

    @Override
    public int updateEntity(Adress entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Adress entity) {
        return 0;
    }
}
