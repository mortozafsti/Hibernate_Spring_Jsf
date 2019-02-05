package com.example.diconstructorannotation.Test;

import com.example.diconstructorannotation.entity.Employee;
import com.example.diconstructorannotation.entity.EmployeeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testdicons {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        Employee emp = (Employee) context.getBean(Employee.class);
        emp.show();
    }
}
