package com.example.springbasic.Test;

import com.example.springbasic.SingleTonScope.AA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class singletontest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("qualifierContext.xml");

        AA aa  =  context.getBean(AA.class);

        aa.getClass();
    }
}
