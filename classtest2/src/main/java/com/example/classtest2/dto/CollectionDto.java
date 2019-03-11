package com.example.classtest2.dto;

public class CollectionDto {
    private double monthlyCollectedAmount;

    private double yearlyCollectedAmount;

    private Long totalAmount;
    private Long totalloanAmount;

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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalloanAmount() {
        return totalloanAmount;
    }

    public void setTotalloanAmount(Long totalloanAmount) {
        this.totalloanAmount = totalloanAmount;
    }
}
