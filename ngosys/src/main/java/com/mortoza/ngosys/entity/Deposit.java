package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deposit_brance",unique = true,nullable = false)
    private String deposit_brance;

    @Column(name = "deposit_date", nullable = false)
    private Date deposit_date;

    @Column(name = "deposit_amount", nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "m_id",nullable = false)
    private Member member;

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
}
