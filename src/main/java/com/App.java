package com;

import com.person.Person;
import com.person.PersonRepository;
import java.util.HashMap;
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

    // Person person = new Person("fName", "lName", "emailhere", 20);

    // person.eat();
    // System.out.println(person.firstName);

    HashMap<String, String> hMap = new HashMap<>();

    hMap.put("personOne", "name1");
    hMap.putIfAbsent("personThree", "name3");
    hMap.put("personTwo", "name2");

    // hMap.putIfAbsent("personTwo", "name222");

    hMap.replace("personTwo", "name222");
    // hMap.remove("personThree");

    // System.out.println(hMap);
    // System.out.println(hMap.get("personOne"));

    for (String i : hMap.keySet()) {
      System.out.println(i);
      System.out.println(hMap.get(i));
    }
  }
}
