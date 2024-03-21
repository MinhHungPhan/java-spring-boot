package com.kientree.crud.dao;

import com.kientree.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create a query to select all students
        TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName", Student.class);
        // Execute the query and return the result as a list of students
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        // Create a query to find a student by last name
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :theData", Student.class);

        // Set query parameters
        query.setParameter("theData", lastName);

        // Return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // Retrieve the student
        Student student = entityManager.find(Student.class, id);

        // Delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}
