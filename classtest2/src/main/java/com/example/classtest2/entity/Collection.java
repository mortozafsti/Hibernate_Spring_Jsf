package com.example.classtest2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanCode;
    private String memberName;
    private int nOfTotalKisti;
    private double nOfTotalAmount;
    private int nOfCollectedKisti;
    private double nOfColectedamount;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cDate = new Date();



    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    public Collection() {
    }

    public Collection(String loanCode, String memberName, int nOfTotalKisti, double nOfTotalAmount, int nOfCollectedKisti, double nOfColectedamount, Date cDate, Loan loan) {
        this.loanCode = loanCode;
        this.memberName = memberName;
        this.nOfTotalKisti = nOfTotalKisti;
        this.nOfTotalAmount = nOfTotalAmount;
        this.nOfCollectedKisti = nOfCollectedKisti;
        this.nOfColectedamount = nOfColectedamount;
        this.cDate = cDate;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getnOfTotalKisti() {
        return nOfTotalKisti;
    }

    public void setnOfTotalKisti(int nOfTotalKisti) {
        this.nOfTotalKisti = nOfTotalKisti;
    }

    public double getnOfTotalAmount() {
        return nOfTotalAmount;
    }

    public void setnOfTotalAmount(double nOfTotalAmount) {
        this.nOfTotalAmount = nOfTotalAmount;
    }

    public int getnOfCollectedKisti() {
        return nOfCollectedKisti;
    }

    public void setnOfCollectedKisti(int nOfCollectedKisti) {
        this.nOfCollectedKisti = nOfCollectedKisti;
    }

    public double getnOfColectedamount() {
        return nOfColectedamount;
    }

    public void setnOfColectedamount(double nOfColectedamount) {
        this.nOfColectedamount = nOfColectedamount;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
