package com.example.springbasic.Test;

import com.example.springbasic.Autowired.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class testallexample {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(testallexample.class,args);

        Employee employee = context.getBean(Employee.class);
        employee.showDetails();
    }
}
