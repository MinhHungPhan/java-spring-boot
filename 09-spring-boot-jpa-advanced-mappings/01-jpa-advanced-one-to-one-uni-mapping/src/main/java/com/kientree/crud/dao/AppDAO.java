package com.kientree.crud.dao;

import com.kientree.crud.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);
}
