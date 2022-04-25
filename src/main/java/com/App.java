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

    // String = a reference data type that can store one or more characters
    //          reference data types have access to useful methods

    //boolean result = name.equalsIgnoreCase("bro");
    //int result = name.length();
    //char result = name.charAt(0);
    //int result = name.indexOf("o");
    //boolean result = name.isEmpty();
    //String result = name.toUpperCase();
    //String result = name.toLowerCase();
    //String result = name.trim();
    //String result = name.replace('o', 'a');

    // *** wrapper class ***

    //	   provides a way to use primitive data types as reference data types
    //     reference data types contain useful methods
    //     can be used with collections (ex.ArrayList)

    // primitive  //wrapper
    // ---------  //-------
    // boolean    Boolean
    // char       Character
    // int        Integer
    // double     Double

    // autoboxing = the automatic conversion that
    //            	the Java compiler makes between the primitive types
    //            	and their corresponding object wrapper classes

    // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive

    Boolean a = true;
    Character b = '@';
    Integer c = 123;
    Double d = 3.14;
    String str = "bro";

    if (a == true) System.out.println("ture!");
  }
}
