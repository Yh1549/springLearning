package com.example.Cruddemo.controller;

import com.example.Cruddemo.entity.Employee;
import com.example.Cruddemo.service.EmployeeService;
import com.example.Cruddemo.service.impl.EmployeeSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    //inject employee dao
    private EmployeeSvcImpl employeeSvc;

    @Autowired
    public EmployeeController(EmployeeSvcImpl employee) {
        this.employeeSvc = employee;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
         Employee emp = employeeSvc.findById(id);
         if(emp == null){
             throw new RuntimeException("employee not found : " + id);
         }
        return emp;
    }

    // add mapping for post - add new employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeSvc.save(theEmployee);
        return dbEmployee;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeSvc.findAll();
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeSvc.save(employee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee emp = employeeSvc.findById(id);
        if(emp == null){
            throw new RuntimeException("employee not found");
        }
        employeeSvc.delete(id);
        return "delete id : " + id;
    }
}
