package com;

import com.person.Person;
import com.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );
    //   PersonRepository personRepo = configContext.getBean(PersonRepository.class);
    // Person person = new Person("fName", "lName", "emailhere", 20);
    // person.eat();
    // System.out.println(person.firstName);

  }
}
