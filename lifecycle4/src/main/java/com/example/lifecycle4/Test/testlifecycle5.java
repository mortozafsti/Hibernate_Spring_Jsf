package com.example.lifecycle4.Test;

import com.example.lifecycle4.entity.MyAwareService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testlifecycle5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.getBean("myAwareServices", MyAwareService.class);
        ctx.close();
    }
}
