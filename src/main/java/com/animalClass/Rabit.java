package com.animalClass;

import com.animalInterface.Prey;

public class Rabit implements Prey {

  @Override
  public void flee() {
    System.out.println("*Rabit fleeing*");
  }
}
