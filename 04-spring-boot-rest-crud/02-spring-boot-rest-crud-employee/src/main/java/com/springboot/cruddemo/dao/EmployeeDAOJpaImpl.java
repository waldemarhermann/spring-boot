package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery typedQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = typedQuery.getResultList();

        return employees;
    }

}
