package com.example.Cruddemo.service;

import com.example.Cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(Integer id);
    void delete(int id);
    int deleteAll();
}
