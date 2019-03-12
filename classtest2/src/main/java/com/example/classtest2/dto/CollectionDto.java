package com.example.classtest2.dto;

public class CollectionDto {

    private double monthlyCollectedAmount;
    private double yearlyCollectedAmount;
    private double totalAmount;
    private double totalloanAmount;
    private double totalDueAmount;




    public double getMonthlyCollectedAmount() {
        return monthlyCollectedAmount;
    }

    public void setMonthlyCollectedAmount(double monthlyCollectedAmount) {
        this.monthlyCollectedAmount = monthlyCollectedAmount;
    }

    public double getYearlyCollectedAmount() {
        return yearlyCollectedAmount;
    }

    public void setYearlyCollectedAmount(double yearlyCollectedAmount) {
        this.yearlyCollectedAmount = yearlyCollectedAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalloanAmount() {
        return totalloanAmount;
    }

    public void setTotalloanAmount(double totalloanAmount) {
        this.totalloanAmount = totalloanAmount;
    }

    public double getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }
}
