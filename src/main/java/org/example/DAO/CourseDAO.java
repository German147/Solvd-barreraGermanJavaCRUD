package org.example.DAO;

import org.example.entity.Course;
import org.example.service.IEntity_DAO;

import java.util.List;

public class CourseDAO implements IEntity_DAO<Course> {
    @Override
    public List<Course> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(Course entity) {
        return 0;
    }

    @Override
    public Course getEntityBYId(Course entity) {
        return null;
    }

    @Override
    public int updateEntity(Course entity) {
        return 0;
    }

    @Override
    public int deleteEntity(Course entity) {
        return 0;
    }
}
