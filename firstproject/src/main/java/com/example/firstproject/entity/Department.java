package com.example.firstproject.entity;

public class Department {

    private int deptId;
    private String depName;

    public Department(int deptId, String depName) {
        this.deptId = deptId;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", depName='" + depName + '\'' +
                '}';
    }
}
