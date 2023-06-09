package com.kientree.crud.dao;

import com.kientree.crud.entity.Instructor;
import com.kientree.crud.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        // Retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // Delete the instructor
        entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        // Retrieve instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // Remove the associated object reference to break bi-directional link

        instructorDetail.getInstructor().setInstructorDetail(null);

        // Delete the instructor detail
        entityManager.remove(instructorDetail);
    }
}
