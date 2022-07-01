package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);

    Class[] interfaces = { UserDao.class };
    // Proxy.newProxyInstance(
    //   App.class.getClassLoader(),
    //   interfaces,
    //   new InvocationHandler() {
    //     @Override
    //     public Object invoke(Object arg0, Method arg1, Object[] arg2)
    //       throws Throwable {
    //       // TODO Auto-generated method stub
    //       return null;
    //     }
    //   }
    // );
    // Proxy.newProxyInstance( App.class.getClassLoader(), interfaces, new InvocationHandler());

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    UserDao userDao = (UserDao) Proxy.newProxyInstance(
      App.class.getClassLoader(),
      interfaces,
      new UserDaoProxy(userDaoImpl)
    );
    Integer res = userDao.add(1, 2);
    System.out.println("res: " + res);
  }
}

class UserDaoProxy implements InvocationHandler {

  private Object obj;

  public UserDaoProxy(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable {
    // before method
    System.out.println(
      "before method: \n method name: " +
      method.getName() +
      " args: " +
      Arrays.toString(args)
    );

    // enhancememt
    Object res = method.invoke(obj, args);

    // after method
    System.out.println("after method: \n obj: " + obj);

    return res;
  }
}
