package com;

import com.Operations.ConsolePrinter;
import com.Operations.Printer;
import com.animalClass.Fish;
import com.animalClass.Hawk;
import com.animalClass.Rabit;
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

    // https://www.youtube.com/watch?v=JFuMei9Wwk4&t=67s
    // greet(new ConsolePrinter());
    // or inner class/anonymous
    greet(
      new Printer() {
        @Override
        public void print(String message) {
          System.out.println(message);
        }
      }
    );
    // or lambda function
    greet(message -> System.out.println(message));
  }

  public static void greet(Printer printer) {
    printer.print("hello");
  }
}
