package com.example.springaopone.entity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DoBeforeMethod implements MethodBeforeAdvice {


    @Before("execution(public String getName())")
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("This is DoBeforeMethod");

    }
}
