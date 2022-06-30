package com;

import com.shape.Circle;
import com.shape.Drawing;
import com.shape.Shape;
import com.shape.Triangle;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App {

  // private static final Logger log = LoggerFactory.getLogger(App.class);
  @Autowired
  static User user2;

  public App(User user2) {
    this.user2 = user2;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );
    // Circle myCircle = new Circle();
    // myCircle.draw();

    // Shape myTriangle = new triangle();
    // myTriangle.draw();

    // drawMethod(myTriangle);

    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
      "beans.xml"
    );

    Shape myShape = appContext.getBean("shape", Shape.class);
    myShape.draw();

    // Drawing myDraw = new Drawing();
    // myDraw.setShape(myShape);
    // myDraw.drawShape();

    /*
     * Example 2
     */
    // without DI
    User user = configContext.getBean(User.class);
    user.add("1");
    user2.add("2");
    // User user = new User(new PostgreSqlDatabase());
    // User user2 = new User(new MySqlDatabase());
    // user.add("new user");
    // user2.add("new user2");
    //  with xml config:
    //  <bean id="MySql" class="com.java.MySql" />
    //  <bean id="PostgreSql" class="com.java.PostgreSql" />
    //  <bean id="user" class="com.java.user"/>
    //  <arg ref="MySql"/>
    //  <arg ref="Oracle"/>
    //  </bean>

    // @Autowired
    // User user;

    //  @Autowired
    //  User user2;

    //  @Autowired
    //  User user3;
  }

  public static void drawMethod(Shape shape) {
    shape.draw();
  }

  @Component
  public static class User {

    Database database;

    public User(@Qualifier("postgreSql") Database database) {
      this.database = database;
    }

    public void add(String data) {
      database.persist(data);
    }
  }

  public interface Database {
    void persist(String data);
  }

  @Component("mySql")
  public static class MySqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Mysql has persisted: " + data);
    }
  }

  @Component("postgreSql")
  public static class PostgreSqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Postgres has persisted: " + data);
    }
  }
}
