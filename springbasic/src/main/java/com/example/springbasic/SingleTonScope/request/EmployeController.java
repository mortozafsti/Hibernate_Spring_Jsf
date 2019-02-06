package com.example.springbasic.SingleTonScope.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Provider;


@Controller
@RequestMapping()
public class EmployeController {

    private Provider<EmployeDetails> employeDetailsProvider;

}
