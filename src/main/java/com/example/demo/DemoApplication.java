package com.example.demo;

import com.example.demo.Student.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		printL();
	}

	@GetMapping(path = "/helloworld")
	public static String[] helloWorld() {
		// return List.of("hello", "world");

		String[] res = {" hello", "world"} ;
		return res;
	}
	
	public static void printL() {
		Student studentOne = new Student("name1", "name1@gmail.com", "name1password");

		System.out.println("name _________________________________");
		System.out.println(studentOne.getId());
	}
}
