package com.inject_object;

import java.util.Objects;

public class Triangle {

  private Point pointA;
  private Point pointB;
  private Point pointC;

  public void draw() {}

  public Triangle() {}

  public Triangle(Point pointA, Point pointB, Point pointC) {
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
  }

  public Point getPointA() {
    return this.pointA;
  }

  public void setPointA(Point pointA) {
    this.pointA = pointA;
  }

  public Point getPointB() {
    return this.pointB;
  }

  public void setPointB(Point pointB) {
    this.pointB = pointB;
  }

  public Point getPointC() {
    return this.pointC;
  }

  public void setPointC(Point pointC) {
    this.pointC = pointC;
  }

  public Triangle pointA(Point pointA) {
    setPointA(pointA);
    return this;
  }

  public Triangle pointB(Point pointB) {
    setPointB(pointB);
    return this;
  }

  public Triangle pointC(Point pointC) {
    setPointC(pointC);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Triangle)) {
      return false;
    }
    Triangle triangle = (Triangle) o;
    return (
      Objects.equals(pointA, triangle.pointA) &&
      Objects.equals(pointB, triangle.pointB) &&
      Objects.equals(pointC, triangle.pointC)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(pointA, pointB, pointC);
  }

  @Override
  public String toString() {
    return (
      "{" +
      " pointA='" +
      getPointA() +
      "'" +
      ", pointB='" +
      getPointB() +
      "'" +
      ", pointC='" +
      getPointC() +
      "'" +
      "}"
    );
  }
}
