package com.cruddemo;

import com.cruddemo.dao.StudentDAO;
import com.cruddemo.dao.StudentDAOImpl;
import com.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO, 34);

			// queryForStudents(studentDAO);

			// queryForStudentsByFirstName(studentDAO);

			// updateStudent(studentDAO);

			// updateAllStudents(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudent(studentDAO);
		};

	}

	public void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Waldemar", "Hermann", "waldemar@mail.de");

		studentDAO.save(tempStudent);
	}

	public void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student objects...");
		Student tempStudent1 = new Student("Anna", "Hermann", "anna@gmail.de");
		Student tempStudent2 = new Student("Max", "Hermann", "max@gmail.de");
		Student tempStudent3 = new Student("Efimia", "Hermann", "efimia@gmail.de");
		Student tempStudent4 = new Student("Maria", "Hermann", "maria@gmail.de");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	public void readStudent(StudentDAO studentDAO, Integer id) {
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

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentID = 32;
		System.out.println("Getting student with id: " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		// changing first name to "HERMANN"
		System.out.println("Updating student...");
		myStudent.setLastName("HERMANN");

		// update the student
		studentDAO.updateStudent(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		int row = studentDAO.updateAllStudents();
		System.out.println(row + " students were updated");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(1);
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		Integer row = studentDAO.deleteAllStudent();
		System.out.println("Delted: " + row + " students.");
	}

}




