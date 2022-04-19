package com;
import com.Person.Person;
import com.Person.PersonRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		PersonRepository personRepo = configContext.getBean(PersonRepository.class);

		Person newPerson = new Person("p1 firstName", "p1 lastName");
		personRepo.save(newPerson);	
		// personRepo.deleteAll();
	}
}
