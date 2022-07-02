package com.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class UserProxy {

  @Pointcut("execution(* com.annotation.User.add(..))")
  public void pointCut() {}

  @Before("pointCut()")
  public void before() {
    System.out.println("before add");
  }

  @AfterReturning("execution(* com.annotation.User.add(..))")
  public void AfterReturning() {
    System.out.println("AfterReturning add");
  }

  @AfterThrowing("execution(* com.annotation.User.add(..))")
  public void AfterThrowing() {
    System.out.println("AfterThrowing add");
  }

  @Around("execution(* com.annotation.User.add(..))")
  public void around(ProceedingJoinPoint point) throws Throwable {
    System.out.println("around start");
    point.proceed();
    System.out.println("around end");
  }

  // finally
  @After("execution(* com.annotation.User.add(..))")
  public void after() {
    System.out.println("finally after add");
  }
}
