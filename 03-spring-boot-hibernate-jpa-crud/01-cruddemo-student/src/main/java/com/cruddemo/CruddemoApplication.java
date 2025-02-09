package com.cruddemo;

import com.cruddemo.dao.StudentDAO;
import com.cruddemo.dao.StudentDAOImpl;
import com.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// queryForStudents(studentDAO);
			queryForStudentsByFirstName(studentDAO);
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
		System.out.println("The id of the student is: " + tempStudent2.getId());

		// retrieve student based on the id: primary key
		System.out.println("\nRetrieving student with id: " + id);

		Student myStudent = studentDAO.findById(id);

		System.out.println("Found the student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : students) {
			System.out.println("found student: " + tempStudent);
		}
	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findByFirstName("Waldemar");
		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}

	}
}




