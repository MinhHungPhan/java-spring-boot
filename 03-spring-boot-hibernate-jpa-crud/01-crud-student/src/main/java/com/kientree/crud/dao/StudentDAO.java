package com.kientree.crud.dao;

import com.kientree.crud.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
