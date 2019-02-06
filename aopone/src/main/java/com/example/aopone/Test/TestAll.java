package com.example.aopone.Test;

import com.example.aopone.Service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configEmpService.xml");
        EmpService empService = context.getBean("empservice",EmpService.class);
        empService.getManager();
//        System.out.println(empService.getManager().getName());
    }
}
