package com.example.udemyJPA.DAO;


import com.example.udemyJPA.entity.Student;

public interface StudentDAO {
void save(Student student);
Student findById(Integer id);
void update(Student student);
void delete(Integer id);
int deleteAll();
}
