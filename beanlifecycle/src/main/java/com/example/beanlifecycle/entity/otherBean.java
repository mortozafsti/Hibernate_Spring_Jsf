package com.example.beanlifecycle.entity;

public class otherBean {

    private int depId;
    private String depName;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "otherBean{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }
}
