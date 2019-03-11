package com.example.classtest2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanCode;
    private String memberName;
    private Long nOfTotalKisti;
    private Long nOfTotalAmount;
    private Long nOfCollectedKisti;
    private Long nOfColectedamount;



    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    public Collection() {
    }

    public Collection(String loanCode, String memberName, Long nOfTotalKisti, Long nOfTotalAmount, Long nOfCollectedKisti, Long nOfColectedamount, Loan loan) {
        this.loanCode = loanCode;
        this.memberName = memberName;
        this.nOfTotalKisti = nOfTotalKisti;
        this.nOfTotalAmount = nOfTotalAmount;
        this.nOfCollectedKisti = nOfCollectedKisti;
        this.nOfColectedamount = nOfColectedamount;
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

    public Long getnOfTotalKisti() {
        return nOfTotalKisti;
    }

    public void setnOfTotalKisti(Long nOfTotalKisti) {
        this.nOfTotalKisti = nOfTotalKisti;
    }

    public Long getnOfTotalAmount() {
        return nOfTotalAmount;
    }

    public void setnOfTotalAmount(Long nOfTotalAmount) {
        this.nOfTotalAmount = nOfTotalAmount;
    }

    public Long getnOfCollectedKisti() {
        return nOfCollectedKisti;
    }

    public void setnOfCollectedKisti(Long nOfCollectedKisti) {
        this.nOfCollectedKisti = nOfCollectedKisti;
    }

    public Long getnOfColectedamount() {
        return nOfColectedamount;
    }

    public void setnOfColectedamount(Long nOfColectedamount) {
        this.nOfColectedamount = nOfColectedamount;
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
        return Objects.equals(id, that.id) &&
                Objects.equals(loanCode, that.loanCode) &&
                Objects.equals(memberName, that.memberName) &&
                Objects.equals(nOfTotalKisti, that.nOfTotalKisti) &&
                Objects.equals(nOfTotalAmount, that.nOfTotalAmount) &&
                Objects.equals(nOfCollectedKisti, that.nOfCollectedKisti) &&
                Objects.equals(nOfColectedamount, that.nOfColectedamount) &&
                Objects.equals(loan, that.loan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanCode, memberName, nOfTotalKisti, nOfTotalAmount, nOfCollectedKisti, nOfColectedamount, loan);
    }
}
