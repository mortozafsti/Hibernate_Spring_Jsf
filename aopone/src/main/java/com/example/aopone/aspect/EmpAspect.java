package com.example.aopone.aspect;


import com.example.aopone.entity.Manager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmpAspect {


    @Before("allManager()")
    public void beforeAspect(JoinPoint jointPoint){
       // System.out.println("Aspect Run ");
        Manager manager =(Manager) jointPoint.getTarget();
    }
    @After("args(name)")
    public void StringargsMethod(String name){
        System.out.println("Methods run with String Args " +name);
    }
    @Before("Allgetter()")
    public void secondAdvice(){
        System.out.println("Second Run");
    }

    @Pointcut("execution(* get*(..))")
    public void Allgetter(){

    }

    @Pointcut("within(com.example.aopone.entity.Manager)")
    public void allManager(){

    }

    @Around("Allgetter()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
       try {
           System.out.println("Before Returning");
           proceedingJoinPoint.proceed();
           System.out.println("After Returning");
       }catch (Throwable throwable){
           System.out.println("After Throwable");
       }
        System.out.println("Finally");
    }

}
