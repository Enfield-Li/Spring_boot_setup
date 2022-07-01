package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );

    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
      "beans.xml"
    );
  }
}
