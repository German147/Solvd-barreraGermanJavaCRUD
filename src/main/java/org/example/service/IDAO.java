package org.example.service;

import org.example.exceptions.DAO_exception;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T,K> {

    List<T> list();

    T getById(K v)throws DAO_exception;

    void update(T v)throws DAO_exception;

    void insert(T v) throws DAO_exception, SQLException;

    void delete(T v)throws DAO_exception;
}
