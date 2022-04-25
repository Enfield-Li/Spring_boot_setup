package com;

public class Bicycle extends Vehicle {

  int wheels = 2;
  int pedals = 2;

  @Override
  void go() {
    System.out.println("peddeling");
  }

  @Override
  void stop() {
    System.out.println("bicycle stoped");
  }
}
