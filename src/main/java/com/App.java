package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

import com.money.Money;
import com.person.Person;
import com.person.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		PersonRepository personRepo = configContext.getBean(PersonRepository.class);

		Person person1 = new Person("person1");
		Person person2 = new Person("person2");

		Money money1 = new Money(10, person1);
		Money money2 = new Money(20, person1);

		List<Money> moneyForPerson1 = Arrays.asList(money1, money2);

		person1.setMoneys(moneyForPerson1);

		personRepo.save(person1);
		personRepo.save(person2);


	}
}
