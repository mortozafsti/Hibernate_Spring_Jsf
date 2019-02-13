package com.example.springaopone.Entity;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DoBeforeMethod implements MethodBeforeAdvice, AfterReturningAdvice,ThrowsAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("***Spring AOP***  DoBeforeMethod : Executing before Method!");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] args1, Object target1) throws Throwable {
        System.out.println("***Spring AOP***  DoBeforeMethod : Executing After Method!");
    }

    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("DoAfterThrowing: After Throwing Method");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Do Around Method: Method Name: "+ methodInvocation.getMethod().getName());
        System.out.println("Do Around Method: Method Arguments: "+ Arrays.toString(methodInvocation.getArguments()));
        System.out.println("Do Around Method: Before Method Execution: ");
        try {
            Object result = methodInvocation.proceed();
            System.out.println("Do Around Method: After Method Execution: ");
            return result;

        }catch (IllegalArgumentException e){
            System.out.println("Do Around Method: When Method Throws Execution: ");
            throw e;
        }

    }
}
