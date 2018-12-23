package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "loansummary")
public class LoanSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_brance",unique = true, nullable = false)
    private String loan_brance;

    @Temporal(TemporalType.DATE)
    private Date loan_date;

    @Column(name = "loan_amount",nullable = false)
    private double loan_amount;

    @Column(name = "number_of_T_loan_amount", nullable = false)
    private double number_of_loan_amount;

    @Column(name = "number_of_cllected_amount",nullable = false)
    private double number_of_cllected_amount;

    @Column(name = "number_of_due_amount", nullable = false)
    private double number_of_due_amount;

    @Column(name = "number_of_collected_kisti", nullable = false)
    private double number_of_collected_kisti;

    @Column(name = "number_of_due_Kisti", nullable = false)
    private double number_of_due_Kisti;


    @ManyToOne
    @JoinColumn(name = "m_id",nullable = false)
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoan_brance() {
        return loan_brance;
    }

    public void setLoan_brance(String loan_brance) {
        this.loan_brance = loan_brance;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public double getNumber_of_loan_amount() {
        return number_of_loan_amount;
    }

    public void setNumber_of_loan_amount(double number_of_loan_amount) {
        this.number_of_loan_amount = number_of_loan_amount;
    }

    public double getNumber_of_cllected_amount() {
        return number_of_cllected_amount;
    }

    public void setNumber_of_cllected_amount(double number_of_cllected_amount) {
        this.number_of_cllected_amount = number_of_cllected_amount;
    }

    public double getNumber_of_due_amount() {
        return number_of_due_amount;
    }

    public void setNumber_of_due_amount(double number_of_due_amount) {
        this.number_of_due_amount = number_of_due_amount;
    }

    public double getNumber_of_collected_kisti() {
        return number_of_collected_kisti;
    }

    public void setNumber_of_collected_kisti(double number_of_collected_kisti) {
        this.number_of_collected_kisti = number_of_collected_kisti;
    }

    public double getNumber_of_due_Kisti() {
        return number_of_due_Kisti;
    }

    public void setNumber_of_due_Kisti(double number_of_due_Kisti) {
        this.number_of_due_Kisti = number_of_due_Kisti;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
