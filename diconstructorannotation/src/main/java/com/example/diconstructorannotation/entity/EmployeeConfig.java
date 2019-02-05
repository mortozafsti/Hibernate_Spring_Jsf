package com.example.diconstructorannotation.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee employeeBean(){
        Employee employee = new Employee(100,"Kalam Sir");
        return employee;
    }
    @Bean
    public Address addressBean(){
      Address addd = new Address("ggg","ssss","llllll");
        return addd;
    }
}
