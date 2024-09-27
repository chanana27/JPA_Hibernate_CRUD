package com.abhay2code.crud_demo;

import com.abhay2code.crud_demo.dao.StudentDAO;
import com.abhay2code.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			findStudent(studentDAO);
//			findAllStudent(studentDAO);
//			findStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};

	}

	private void findStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("chanana");

		for(Student it: theStudents){
			System.out.println(it);
		}
	}

	public void createMultipleStudents(StudentDAO studentDAO){
		// create multiple student
		Student tempStudent1 = new Student("Nupur", "Sharma", "nupur@gmail.com");
		Student tempStudent2 = new Student("kirti", "kamboj", "kirti@gmail.com");
		Student tempStudent3 = new Student("shreya", "rajan", "shreya@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Student saved with id "+ tempStudent1.getId());
		System.out.println("Student saved with id "+ tempStudent2.getId());
		System.out.println("Student saved with id "+ tempStudent3.getId());
	}

	public void createStudent(StudentDAO studentDAO){

		// create a new Student
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Abhay", "Chanana", "Hate2Code@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of saved student
		System.out.println("Student saved with id "+ tempStudent.getId());
	}

	public void findStudent(StudentDAO studentDAO){
		//create a student
		Student student = new Student("Lovish", "Sharma", "Lovish@gmail.com");

		// save the student
		studentDAO.save(student);

		int id = student.getId();

		Student tempStudent= studentDAO.findById(id);
		System.out.println(tempStudent);

	}

	public void findAllStudent(StudentDAO studentDAO){
		// get the students
		List<Student> allStudents = studentDAO.findAll();

		// display them
		for(Student it: allStudents){
			System.out.println(it);
		}
	}

	public void updateStudent(StudentDAO studentDAO){
		// get the student to update
		int id = 4;
		Student student = studentDAO.findById(id);

		// change the first name
		student.setFirstName("scooby");

		// update the entry in db
		studentDAO.updateStudent(student);

		//diplay the student
		System.out.println(student);

	}

	public void deleteStudent(StudentDAO studentDAO){
		// get the student to delete
		int id = 3;
		studentDAO.deleteStudent(id);
	}

	public void deleteAllStudents(StudentDAO studentDAO){
		int deletedRows = studentDAO.deleteAllStudents();
		System.out.println(deletedRows);
	}

}
