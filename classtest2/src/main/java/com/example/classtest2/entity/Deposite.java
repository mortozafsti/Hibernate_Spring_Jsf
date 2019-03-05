package com.example.classtest2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "deposite")
public class Deposite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deposit_brance", unique = true, nullable = false)
    private String depositNbrance;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date depositDate;

    @Column(name = "deposit_amount", nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    public Deposite() {
    }

    public Deposite(String depositNbrance, Date depositDate, Long amount, Member member) {
        this.depositNbrance = depositNbrance;
        this.depositDate = depositDate;
        this.amount = amount;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepositNbrance() {
        return depositNbrance;
    }

    public void setDepositNbrance(String depositNbrance) {
        this.depositNbrance = depositNbrance;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
        Deposite deposite = (Deposite) o;
        return Objects.equals(id, deposite.id) &&
                Objects.equals(depositNbrance, deposite.depositNbrance) &&
                Objects.equals(depositDate, deposite.depositDate) &&
                Objects.equals(amount, deposite.amount) &&
                Objects.equals(member, deposite.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, depositNbrance, depositDate, amount, member);
    }
}
