package com;

public abstract class Vehicle {

  double speed;

  abstract void go();

  void stop() {
    System.out.println("This vehicle is stopped");
  }
}
