package com.example.springbasic.SingleTonScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class AA {
    public AA() {
        System.out.println("SingleTone Object Is Created");
    }
}
