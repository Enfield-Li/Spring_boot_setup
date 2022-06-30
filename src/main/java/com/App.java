package com;

import com.shape.Circle;
import com.shape.Drawing;
import com.shape.Shape;
import com.shape.Triangle;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

  // private static final Logger log = LoggerFactory.getLogger(App.class);
  @Autowired
  User user;

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

    Shape myShape = appContext.getBean("shape", Circle.class);
    myShape.draw();

    Drawing myDraw = new Drawing();
    myDraw.setShape(myShape);
    myDraw.drawShape();

    /*
     * Example 2
     */
    // without DI
    App container = new App();
    User user = new User(new PostgreSqlDatabase());
    User user2 = new User(new MySqlDatabase());
    user.add("new user");
    user2.add("new user2");
    //  with xml config:
    //  <bean id="MySql" class="com.java.MySql" />
    //  <bean id="PostgreSql" class="com.java.PostgreSql" />
    //  <bean id="user" class="com.java.user"/>
    //  <arg ref="MySql"/>
    //  <arg ref="Oracle"/>
    //  </bean>

    //  @Autowired
    //  User user2;

    //  @Autowired
    //  User user3;
  }

  public static void drawMethod(Shape shape) {
    shape.draw();
  }

  public static class User {

    Database database;

    public User(Database database) {
      this.database = database;
    }

    public void add(String data) {
      database.persist(data);
    }
  }

  public interface Database {
    void persist(String data);
  }

  public static class MySqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Mysql has persisted: " + data);
    }
  }

  public static class PostgreSqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Postgres has persisted: " + data);
    }
  }
}
