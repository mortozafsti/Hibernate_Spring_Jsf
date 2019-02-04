package com.example.dixmlsetter.Test;

import com.example.dixmlsetter.entity.Address;
import com.example.dixmlsetter.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Tests {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        BeanFactory factory = new XmlBeanFactory(resource);

//        Address address = (Address) factory.getBean("a2");
//        System.out.println(address);

        Student student = (Student) factory.getBean("a3");
        System.out.println(student);
    }
}
