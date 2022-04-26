package com.shape;

public class Triangle implements Shape {

  private String type;

  @Override
  public void draw() {
    System.out.println("draw a triangle and type is " + getType());
  }

  public String getType() {
    return this.type;
  }

  // setter injection
  public void setType(String type) {
    this.type = type;
  }
}
