package com.example.lifecycle3.test;

import com.example.lifecycle3.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testlifecycle3 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Employee employee = (Employee) context.getBean("s");
        System.out.println(employee.toString());
        ((ClassPathXmlApplicationContext) context).close();

    }

}
