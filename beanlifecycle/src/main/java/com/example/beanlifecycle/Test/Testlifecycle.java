package com.example.beanlifecycle.Test;

import com.example.beanlifecycle.entity.SimpleBean;
import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testlifecycle {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SimpleBean simpleBean = (SimpleBean) context.getBean("sbean");
        System.out.println(simpleBean);

        SimpleBean simpleBean1 = (SimpleBean) context.getBean("sbean1");
        System.out.println(simpleBean1);

    }
}
