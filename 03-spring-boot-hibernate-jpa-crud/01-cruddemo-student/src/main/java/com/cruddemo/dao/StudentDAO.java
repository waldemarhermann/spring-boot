package com.cruddemo.dao;

import com.cruddemo.entity.Student;

public interface StudentDAO {

     void save(Student student);

     Student findById(Integer id);

}
