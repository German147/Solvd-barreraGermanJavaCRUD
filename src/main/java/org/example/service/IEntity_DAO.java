package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface IEntity_DAO<T> {

    List<T> listEntity();


    int insertEntity(T entity);

    T getEntityBYId(T entity);

    int updateEntity(T entity);

    int deleteEntity(T entity);
}
