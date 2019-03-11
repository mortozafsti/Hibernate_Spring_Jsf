package com.example.classtest2.entity;

import javax.persistence.*;
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
    private double nOfTotalKisti;
    private double nOfTotalAmount;
    private double nOfCollectedKisti;
    private double nOfColectedamount;
    private Date cDate;



    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    public Collection() {
    }

    public Collection(String loanCode, String memberName, double nOfTotalKisti, double nOfTotalAmount, double nOfCollectedKisti, double nOfColectedamount, Date cDate, Loan loan) {
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

    public double getnOfTotalKisti() {
        return nOfTotalKisti;
    }

    public void setnOfTotalKisti(double nOfTotalKisti) {
        this.nOfTotalKisti = nOfTotalKisti;
    }

    public double getnOfTotalAmount() {
        return nOfTotalAmount;
    }

    public void setnOfTotalAmount(double nOfTotalAmount) {
        this.nOfTotalAmount = nOfTotalAmount;
    }

    public double getnOfCollectedKisti() {
        return nOfCollectedKisti;
    }

    public void setnOfCollectedKisti(double nOfCollectedKisti) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return Double.compare(that.nOfTotalKisti, nOfTotalKisti) == 0 &&
                Double.compare(that.nOfTotalAmount, nOfTotalAmount) == 0 &&
                Double.compare(that.nOfCollectedKisti, nOfCollectedKisti) == 0 &&
                Double.compare(that.nOfColectedamount, nOfColectedamount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(loanCode, that.loanCode) &&
                Objects.equals(memberName, that.memberName) &&
                Objects.equals(cDate, that.cDate) &&
                Objects.equals(loan, that.loan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanCode, memberName, nOfTotalKisti, nOfTotalAmount, nOfCollectedKisti, nOfColectedamount, cDate, loan);
    }
}
