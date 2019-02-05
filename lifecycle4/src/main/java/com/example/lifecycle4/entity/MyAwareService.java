package com.example.lifecycle4.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class MyAwareService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware,
        BeanFactoryAware, BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader Called");
        System.out.println(
                "setBeanClassLoader:: Bean Definatiom Name=" +classLoader.getClass().getName()
        );
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory Called");
        System.out.println("setBeanFactory:: employee bean SignlTon="+ beanFactory.isSingleton("emp"));
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName Called");
        System.out.println(
                "setBeanName:: Bean Definatiom Name=" +beanName
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("setApplicationContext Called");
        System.out.println(
                "setApplicationContext:: Bean Definatiom Name=" + Arrays.toString(ctx.getBeanDefinitionNames())
        );
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher called");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment Called");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader called");
        Resource resource = resourceLoader.getResource("classpath:applicationContext.xml");
        System.out.println("setResourceLoader:: Resource File Name =" +resource.getFilename());
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata Called");
    }
}
