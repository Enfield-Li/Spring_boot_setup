package com.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class UserSecProxy {

  @Before("execution(* com.annotation.User.add(..))")
  public void whoComesFirst() {
    System.out.println("this comes first for before add");
  }
}
