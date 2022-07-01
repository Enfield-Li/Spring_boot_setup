package com;

public class UserDaoImpl implements UserDao {

  @Override
  public Integer add(Integer a, Integer b) {
    System.out.println("add...");
    return a + b;
  }

  @Override
  public String update(String id) {
    System.out.println("update...");
    return id;
  }
}
