package com.inject_object;

import java.util.List;
import java.util.Objects;

public class Triangle {

  private List<Point> points;

  public void draw() {
    for (Point point : points) {
      System.out.println("Point " + point.getX() + " + " + point.getY());
    }
  }

  public Triangle() {}

  public Triangle(List<Point> points) {
    this.points = points;
  }

  public List<Point> getPoints() {
    return this.points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }

  public Triangle points(List<Point> points) {
    setPoints(points);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Triangle)) {
      return false;
    }
    Triangle triangle = (Triangle) o;
    return Objects.equals(points, triangle.points);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(points);
  }

  @Override
  public String toString() {
    return "{" + " points='" + getPoints() + "'" + "}";
  }
}
