package com;

public class Fish implements Predator, Prey {

  @Override
  public void flee() {
    System.out.println("*fish is hunting*");
  }

  @Override
  public void hunt() {
    System.out.println("*fish is fleeing*");
  }
}
