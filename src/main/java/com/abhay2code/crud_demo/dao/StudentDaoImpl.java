package com.abhay2code.crud_demo.dao;

import com.abhay2code.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        // create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){
        // create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        // set Query Parameter
        theQuery.setParameter("theData", lastName);

        // return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id){
        // retrieve the student
        Student student = findById(id);

        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents(){
        int numOfRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numOfRowsDeleted;
    }

}
