package com.example.firstproject.Test;

import com.example.firstproject.entity.Address;

import com.example.firstproject.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Testd {

    public static void main(String[] args) {

        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Address address =(Address) factory.getBean("a1");
        System.out.println(address);

        Student student =(Student) factory.getBean("a2");
        System.out.println(student);



    }
}
