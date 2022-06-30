package com.factoryBean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import com.shape.Circle;
import com.shape.Shape;

@Data
public class MyBean implements FactoryBean<Shape> {

  @Override
  public Shape getObject() throws Exception {
    Circle circle = new Circle();
    return circle;
  }

  @Override
  public Class getObjectType() {
    return null;
  }
}
