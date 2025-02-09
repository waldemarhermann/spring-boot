package com.cruddemo;

import com.cruddemo.dao.StudentDAO;
import com.cruddemo.dao.StudentDAOImpl;
import com.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			readStudent(studentDAO, 2);
		};

	}

	public void readStudent(StudentDAO studentDAO, int id) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Waldemar", "Hermann", "hermann.waldemar1995@gmail.com");
		Student tempStudent2 = new Student("Anna", "Hermann", "hermann.anna@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);

		//display id of the student
		System.out.println("The id of the student is: " + tempStudent.getId());

		// retrieve student based on the id: primary key
		System.out.println("\nRetrieving student with id: " + id);

		Student myStudent = studentDAO.findById(id);

		System.out.println("Found the student: " + myStudent);
	}

}




