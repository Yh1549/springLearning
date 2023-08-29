package com.example.Cruddemo.service.impl;

import com.example.Cruddemo.dao.EmployeeDAO;
import com.example.Cruddemo.entity.Employee;
import com.example.Cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeSvcImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeSvcImpl() {
    }

    @Autowired
    public EmployeeSvcImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
