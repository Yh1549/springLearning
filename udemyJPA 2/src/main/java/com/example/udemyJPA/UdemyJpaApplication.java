package com.example.udemyJPA;

import com.example.udemyJPA.DAO.StudentDAO;
import com.example.udemyJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UdemyJpaApplication {

	private int theId;

	public static void main(String[] args) {
		SpringApplication.run(UdemyJpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//		createStudent(studentDAO);
//		createMultipleStudents(studentDAO);
//		readStudent(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Delete ALL");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Getting student id : " + studentId);
//		Student myStudent = studentDAO.findById(studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary Key
		int studentId = 1;
		System.out.println("Getting student id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name
		System.out.println("updating student ...");
		myStudent.setFirstName("Scooby");
		//update
		studentDAO.update(myStudent);
		//display
		System.out.println(myStudent);
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new Student Object...");
		Student tempStudent1 = new Student("neovim","Doe","neovim@mail.com");
		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		// display the id
		int theId = tempStudent1.getId();
		System.out.println("Saved student id:"+tempStudent1.getId());

		//retrieve the student based on id
		System.out.println("retrieve student id:"+tempStudent1.getId());
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("retrieve student id:"+myStudent.getId() +"name" + myStudent.getFirstName());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating new Student Object...");
		Student tempStudent1 = new Student("john","Doe","john@mail.com");
		Student tempStudent2 = new Student("mary","Doe","mary@mail.com");
		Student tempStudent3 = new Student("peter","Doe","peter@mail.com");
		//save the student Object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new Student Object...");
		Student tempStudent = new Student("Paul","Doe","mail.com");
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student id:"+tempStudent.getId());

	}

}
