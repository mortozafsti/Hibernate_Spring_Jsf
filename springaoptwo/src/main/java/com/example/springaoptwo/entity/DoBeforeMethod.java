package com.example.springaoptwo.entity;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DoBeforeMethod implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Executing Before Method");
    }
}
