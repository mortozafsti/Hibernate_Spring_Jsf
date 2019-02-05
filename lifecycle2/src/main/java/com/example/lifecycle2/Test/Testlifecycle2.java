package com.example.lifecycle2.Test;

import com.example.lifecycle2.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testlifecycle2 {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee employee = (Employee) context.getBean("emp");
        System.out.println(employee);
        context.close();

    }
}
