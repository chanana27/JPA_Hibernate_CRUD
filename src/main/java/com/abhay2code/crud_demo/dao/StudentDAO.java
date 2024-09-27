package com.abhay2code.crud_demo.dao;

import com.abhay2code.crud_demo.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudent(int id);

    int deleteAllStudents();

}
