package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import com.annotation.User;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  ConfigurableApplicationContext context;

  @Test
  public void testAopAnnotation() {
    System.out.println(context);
    User user = context.getBean(User.class);
    user.add();
  }
}
