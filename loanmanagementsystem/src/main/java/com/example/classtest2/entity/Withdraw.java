package com.example.classtest2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "withdraw")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String w_branch;
    private Long w_amount;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date w_date;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    public Withdraw() {
    }

    public Withdraw(String w_branch, Long w_amount, Date w_date, Member member) {
        this.w_branch = w_branch;
        this.w_amount = w_amount;
        this.w_date = w_date;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getW_branch() {
        return w_branch;
    }

    public void setW_branch(String w_branch) {
        this.w_branch = w_branch;
    }

    public Long getW_amount() {
        return w_amount;
    }

    public void setW_amount(Long w_amount) {
        this.w_amount = w_amount;
    }

    public Date getW_date() {
        return w_date;
    }

    public void setW_date(Date w_date) {
        this.w_date = w_date;
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
        Withdraw withdraw = (Withdraw) o;
        return Objects.equals(id, withdraw.id) &&
                Objects.equals(w_branch, withdraw.w_branch) &&
                Objects.equals(w_amount, withdraw.w_amount) &&
                Objects.equals(w_date, withdraw.w_date) &&
                Objects.equals(member, withdraw.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, w_branch, w_amount, w_date, member);
    }
}
