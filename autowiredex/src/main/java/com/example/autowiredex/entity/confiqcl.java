package com.example.autowiredex.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class confiqcl {

    @Bean
    public SpeelChecker speelChecker(){

        return new SpeelChecker();
    }
    @Bean
    public TextEditor textEditor(){

        return new TextEditor();
    }

}
