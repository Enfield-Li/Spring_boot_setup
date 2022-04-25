package com;

import com.person.Person;
import com.person.PersonRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    // ** Array **
    // Fixed length hold primitives or objects
    String[] arr = new String[4];
    String[] arr2 = { "arr0", "arr1" };

    System.out.println(arr.toString());

    // ** ArrayList **
    // Not fixed length hold only objects(Wrapper class) not primitives
    ArrayList<String> arrList = new ArrayList<>();
    ArrayList<String> arrList1 = new ArrayList<>(
      Arrays.asList("al1", "al2") // mutable list
    );

    // ** List **
    List<String> list = Arrays.asList("list1", "list2");

    // access
    System.out.println(arr[0] + arr.length);
    System.out.println(arrList1.get(1) + arrList1.size());

    // add
    arrList1.add("ar3");

    // update
    arr2[0] = "1";
    arrList1.set(0, "ar0");
    System.out.println(arrList1.get(0));

    // delete
    arrList1.remove(0);
    System.out.println(arrList1.get(0));

    System.out.println(arr2); // print memory
    System.out.println(arrList1); // print element with toString/loop
    // ArrayList<String> arrList2 = Arrays.asList("akldf", "skzdf"); // Immutable list
  }
}
