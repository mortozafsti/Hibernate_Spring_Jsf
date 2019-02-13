package com.example.springevidence.Entity;

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
    private String deposit_brance;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deposit_date;

    @Column(name = "deposit_amount", nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    public Deposite() {
    }

    public Deposite(String deposit_brance, Date deposit_date, Long amount, Member member) {
        this.deposit_brance = deposit_brance;
        this.deposit_date = deposit_date;
        this.amount = amount;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeposit_brance() {
        return deposit_brance;
    }

    public void setDeposit_brance(String deposit_brance) {
        this.deposit_brance = deposit_brance;
    }

    public Date getDeposit_date() {
        return deposit_date;
    }

    public void setDeposit_date(Date deposit_date) {
        this.deposit_date = deposit_date;
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
                Objects.equals(deposit_brance, deposite.deposit_brance) &&
                Objects.equals(deposit_date, deposite.deposit_date) &&
                Objects.equals(amount, deposite.amount) &&
                Objects.equals(member, deposite.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deposit_brance, deposit_date, amount, member);
    }
}
