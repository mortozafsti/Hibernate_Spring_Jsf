package com.example.springbasic.Test;

import com.example.springbasic.Qualifier.Vehicle;
import com.example.springbasic.Qualifier.VehicleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testQualifier {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.example.springbasic.Qualifier");
        context.refresh();

        VehicleService vehicle =  context.getBean(VehicleService.class);
        vehicle.byservice();
    }
}
