package com.example.autowiredex.Test;

import com.example.autowiredex.entity.SpeelChecker;
import com.example.autowiredex.entity.SpeelEditor;
import com.example.autowiredex.entity.TextEditor;
import com.example.autowiredex.entity.confiqcl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class autowiredtest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(confiqcl.class);

        TextEditor textEditor = (TextEditor) context.getBean(TextEditor.class);
        textEditor.speelCheck();

    }
}
