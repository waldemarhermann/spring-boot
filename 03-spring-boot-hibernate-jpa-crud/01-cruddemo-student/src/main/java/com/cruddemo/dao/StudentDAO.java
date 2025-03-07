package com.cruddemo.dao;

import com.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student student);

     Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByFirstName(String lastName);

     void updateStudent(Student student);

     int updateAllStudents();

     void deleteStudent(Integer id);

     Integer deleteAllStudent();

}
