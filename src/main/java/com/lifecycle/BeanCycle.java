package com.lifecycle;

import lombok.Data;

public class BeanCycle {

  private String name;

  public BeanCycle() {
    System.out.println("Step 1: no args construct");
  }

  public BeanCycle(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    System.out.println("Step 2 init setter");
    this.name = name;
  }

  public void initMethod() {
    System.out.println("Step 3 init method");
  }

  public void destroyMethod() {
    System.out.println("Step 4 destroyMethod method");
  }

  public BeanCycle name(String name) {
    setName(name);
    return this;
  }

  @Override
  public String toString() {
    return "{" + " name='" + getName() + "'" + "}";
  }
}
