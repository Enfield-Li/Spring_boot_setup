package com.shape;

import org.springframework.beans.factory.annotation.Autowired;

public class Triangle implements Shape {

  private String type;
  private Integer height;

  // No args constructor for spring reflect api
  public Triangle() {}

  public Triangle(String type) {
    this.type = type;
  }

  public Triangle(Integer height) {
    this.height = height;
  }

  public Triangle(String type, Integer height) {
    this.type = type;
    this.height = height;
  }

  public Integer getHeight() {
    return this.height;
  }

  public String getType() {
    return this.type;
  }

  // setter injection
  // public void setType(String type) {
  //   this.type = type;
  // }

  @Override
  public void draw() {
    System.out.println(
      "draw a triangle and type is " + getType() + " of height: " + getHeight()
    );
  }
}
