package com.example.Cruddemo.service.impl;

import com.example.Cruddemo.dao.EmployeeDAO;
import com.example.Cruddemo.entity.Employee;
import com.example.Cruddemo.repository.EmployeeRepository;
import com.example.Cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSvcImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeSvcImpl() {
    }

    @Autowired
    public EmployeeSvcImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee emp = null;
        if(result.isPresent()){
            emp = result.get();
        }else{
            throw new RuntimeException("employee not found : "+ id);
        }

        return emp;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Employee> emp = null;
        emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            employeeRepository.delete(emp.get());
        }else{
            throw new RuntimeException("employee not found : "+ id);
        }
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
