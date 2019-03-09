package com.example.classtest2.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "loansummary")
public class LoanSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lcode", nullable = false)
    private String loanCode;

    private String l_branch;
    private Long l_amount;
    private Long no_total_amount;
    private Long no_collected_amount;
    private Long no_due_amount;
    private Long no_total_Kisti;
    private Long no_collected_Kisti;
    private Long no_due_Kisti;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date l_date;

    @OneToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;



    public LoanSummary() {
    }

    public LoanSummary(String loanCode, String l_branch, Long l_amount, Long no_total_amount, Long no_collected_amount, Long no_due_amount, Long no_total_Kisti, Long no_collected_Kisti, Long no_due_Kisti, Date l_date, Member member) {
        this.loanCode = loanCode;
        this.l_branch = l_branch;
        this.l_amount = l_amount;
        this.no_total_amount = no_total_amount;
        this.no_collected_amount = no_collected_amount;
        this.no_due_amount = no_due_amount;
        this.no_total_Kisti = no_total_Kisti;
        this.no_collected_Kisti = no_collected_Kisti;
        this.no_due_Kisti = no_due_Kisti;
        this.l_date = l_date;
        this.member = member;
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

    public String getL_branch() {
        return l_branch;
    }

    public void setL_branch(String l_branch) {
        this.l_branch = l_branch;
    }

    public Long getL_amount() {
        return l_amount;
    }

    public void setL_amount(Long l_amount) {
        this.l_amount = l_amount;
    }

    public Long getNo_total_amount() {
        return no_total_amount;
    }

    public void setNo_total_amount(Long no_total_amount) {
        this.no_total_amount = no_total_amount;
    }

    public Long getNo_collected_amount() {
        return no_collected_amount;
    }

    public void setNo_collected_amount(Long no_collected_amount) {
        this.no_collected_amount = no_collected_amount;
    }

    public Long getNo_due_amount() {
        return no_due_amount;
    }

    public void setNo_due_amount(Long no_due_amount) {
        this.no_due_amount = no_due_amount;
    }

    public Long getNo_total_Kisti() {
        return no_total_Kisti;
    }

    public void setNo_total_Kisti(Long no_total_Kisti) {
        this.no_total_Kisti = no_total_Kisti;
    }

    public Long getNo_collected_Kisti() {
        return no_collected_Kisti;
    }

    public void setNo_collected_Kisti(Long no_collected_Kisti) {
        this.no_collected_Kisti = no_collected_Kisti;
    }

    public Long getNo_due_Kisti() {
        return no_due_Kisti;
    }

    public void setNo_due_Kisti(Long no_due_Kisti) {
        this.no_due_Kisti = no_due_Kisti;
    }

    public Date getL_date() {
        return l_date;
    }

    public void setL_date(Date l_date) {
        this.l_date = l_date;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanSummary that = (LoanSummary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(loanCode, that.loanCode) &&
                Objects.equals(l_branch, that.l_branch) &&
                Objects.equals(l_amount, that.l_amount) &&
                Objects.equals(no_total_amount, that.no_total_amount) &&
                Objects.equals(no_collected_amount, that.no_collected_amount) &&
                Objects.equals(no_due_amount, that.no_due_amount) &&
                Objects.equals(no_total_Kisti, that.no_total_Kisti) &&
                Objects.equals(no_collected_Kisti, that.no_collected_Kisti) &&
                Objects.equals(no_due_Kisti, that.no_due_Kisti) &&
                Objects.equals(l_date, that.l_date) &&
                Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanCode, l_branch, l_amount, no_total_amount, no_collected_amount, no_due_amount, no_total_Kisti, no_collected_Kisti, no_due_Kisti, l_date, member);
    }
}
