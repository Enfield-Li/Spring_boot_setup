package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBean implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println("Before init");

    return BeanPostProcessor.super.postProcessAfterInitialization(
      bean,
      beanName
    );
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println("After init");

    return BeanPostProcessor.super.postProcessBeforeInitialization(
      bean,
      beanName
    );
  }
}
