package com;

import com.person.PersonRepository;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

  // private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext configContext = SpringApplication.run(
      App.class,
      args
    );
    // PersonRepository personRepo = configContext.getBean(PersonRepository.class);

    // Circle myCircle = new Circle();
    // myCircle.draw();

    // Shape myTriangle = new triangle();
    // myTriangle.draw();

    // drawMethod(myTriangle);

    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
      "beans.xml"
    );

    Shape myShape = appContext.getBean("triangle", Shape.class);
    myShape.draw();
    // Drawing myDraw = new Drawing();
    // myDraw.setShape(myShape);
    // myDraw.drawShape();
    // ************************************************************

    // ************************************************************

    // ************************************************************

    // without DI
    // App container = new App();
    // User user = container.new User(container.new PostgreSqlDatabase());
    // User user2 = container.new User(container.new PostgreSqlDatabase());
    // User user3 = container.new User(container.new PostgreSqlDatabase());
    // user.add("new user");

    //  with xml config:
    //  <bean id="MySql" class="com.java.MySql" />
    //  <bean id="PostgreSql" class="com.java.PostgreSql" />
    //  <bean id="user" class="com.java.user"/>
    //  <arg ref="MySql"/>
    //  <arg ref="Oracle"/>
    //  </bean>

    //  @Autowired
    //  User user;

    //  @Autowired
    //  User user2;

    //  @Autowired
    //  User user3;
  }

  public static void drawMethod(Shape shape) {
    shape.draw();
  }

  public class User {

    Database database;
    Database database2;

    public User(Database database, Database database2) {
      this.database = database;
      this.database2 = database2;
    }

    public void add(String data) {
      database.persist(data);
    }
  }

  public interface Database {
    void persist(String data);
  }

  public class MySqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Mysql has persisted: " + data);
    }
  }

  public class PostgreSqlDatabase implements Database {

    @Override
    public void persist(String data) {
      System.out.println("******************************");
      System.out.println("Postgres has persisted: " + data);
    }
  }
}
