package com.kientree.crud.dao;

import com.kientree.crud.entity.Course;
import com.kientree.crud.entity.Instructor;
import com.kientree.crud.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);
}
