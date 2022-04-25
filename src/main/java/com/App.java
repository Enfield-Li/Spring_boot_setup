package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ioc.Airtel;
import com.ioc.Sim;
import com.ioc.Vodaphone;
import com.person.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class App {

	// private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);
		// PersonRepository personRepo = configContext.getBean(PersonRepository.class);

		// Airtel airtel = new Airtel();
		// airtel.calling();
		// airtel.data();

		// interface reference
		Sim sim = new Airtel();

		sim.calling();
		sim.data();
		

	}
}
