package com.example.springaopone.Test;

import com.example.springaopone.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

        Employee employee = (Employee) context.getBean("employeeBean");
        employee.getName();


//        System.out.println("---------------------");
//        try {
//            employee.checkName();
//        }catch (Exception e){
//            System.out.println("This is Exception");
//        }
//        System.out.println("---------------------");
//        employee.sayHello("Wow------------");
//        context.close();
    }
}
