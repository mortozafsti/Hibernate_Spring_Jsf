package com.example.springaopone.Test;

import com.example.springaopone.Entity.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aoponetest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aopone_context.xml");

        Employee employee = (Employee) context.getBean("simpleServiceProxy");

        employee.printNameId();
        System.out.println("--------------------------------");
        try {
            employee.checkName();
        }catch (Exception e){
            System.out.println("Exception Throw");
        }
        System.out.println("--------------------------------");
        employee.sayHello("I AM Gandu Programming");
    }
}
