package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.student.Student;
import com.student.StudentRepository;
import com.university.University;
import com.university.UniversityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		UniversityRepository universityRepo = configContext.getBean(UniversityRepository.class);
		StudentRepository studentRepo = configContext.getBean(StudentRepository.class);

		Student newStudent1 = new Student("1111");
		Student newStudent2 = new Student("2222");
		Student newStudent3 = new Student("3333");

		// studentRepo.deleteAll();
		// studentRepo.save(newStudent1);
		studentRepo.save(newStudent3);
		
		List<Student> students = Arrays.asList(newStudent1, newStudent2);
		
		University newUni = new University("first uni", students);
		universityRepo.save(newUni);
	
		universityRepo.deleteAll();

	}
}
