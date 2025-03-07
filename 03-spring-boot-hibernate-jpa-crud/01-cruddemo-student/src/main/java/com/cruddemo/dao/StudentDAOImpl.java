package com.cruddemo.dao;

import com.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    @Autowired
    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE firstName=:theData", Student.class);  // warum muss hier nicht .executeUpdate() gemacht werdeb

        // set query parameters
        theQuery.setParameter("theData", firstName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateAllStudents() {
        int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Hermann'").executeUpdate();  // hier dagegen schon?
        return numRowsUpdated;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Integer deleteAllStudent() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}




