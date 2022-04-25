package com;

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
    // PersonRepository personRepo = configContext.getBean(PersonRepository.class);

    // Interface = a template that can be applied to a class.
    // 			   similar to inheritance, but specifies what a class has/must do.
    // 			   classes can apply more than one interface, inheritance is limited to 1 super

    Rabit rabit = new Rabit();
    rabit.flee();

    Hawk hawk = new Hawk();
    hawk.hunt();

    Fish fish = new Fish();
    fish.hunt();
    fish.flee();
  }
}
