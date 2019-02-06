package com.example.springbasic.SingleTonScope.request;

import org.springframework.stereotype.Service;

import javax.xml.ws.Provider;


@Service
public class AppService {

    private Provider<EmployeDetails> employeDetailsProvider;

    public void findemployeeSalary(){
//        EmployeDetails employeDetails = employeDetailsProvider
    }
}
