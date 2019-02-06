package com.example.springbasic.SingleTonScope.request;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class EmployeDetails {

    private Employe employe;
    private int lastYearSalary;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public int getLastYearSalary() {
        return lastYearSalary;
    }

    public void setLastYearSalary(int lastYearSalary) {
        this.lastYearSalary = lastYearSalary;
    }

    @Override
    public String toString() {
        return "EmployeDetails{" +
                "employe=" + employe +
                ", lastYearSalary=" + lastYearSalary +
                '}';
    }
}
