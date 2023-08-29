package com.example.Cruddemo.dao;

import com.example.Cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // dao 需要一個jpa EntityManager(create by spring boot)
    // define dao interface
    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(Integer id);
    void delete(int id);
    int deleteAll();
    // create dao 實作
}
