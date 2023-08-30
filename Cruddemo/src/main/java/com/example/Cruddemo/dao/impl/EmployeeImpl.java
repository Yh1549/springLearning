package com.example.Cruddemo.dao.impl;

import com.example.Cruddemo.dao.EmployeeDAO;
import com.example.Cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// with JPA
@Repository
public class EmployeeImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeImpl(EntityManager entityManager){
        //注入entity manager(constructor injection)
        this.entityManager = entityManager;
    };

    //Handles transaction management

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        //execute query and get result
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }
    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }
    @Override
    public Employee save(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
