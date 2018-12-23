package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "l_brance",nullable = false)
    private String l_brance;

    @Column(name = "l_date",nullable = false)
    private Date l_date;

    @Column(name = "l_amount",nullable = false)
    private String l_amount;

    @Column(name = "l_kisti",nullable = false)
    private String l_kisti;

    @Column(name = "l_payable_kisti",nullable = false)
    private String l_payable_kisti;

    @ManyToOne
    @JoinColumn(name = "m_id",nullable = false)
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getL_brance() {
        return l_brance;
    }

    public void setL_brance(String l_brance) {
        this.l_brance = l_brance;
    }

    public Date getL_date() {
        return l_date;
    }

    public void setL_date(Date l_date) {
        this.l_date = l_date;
    }

    public String getL_amount() {
        return l_amount;
    }

    public void setL_amount(String l_amount) {
        this.l_amount = l_amount;
    }

    public String getL_kisti() {
        return l_kisti;
    }

    public void setL_kisti(String l_kisti) {
        this.l_kisti = l_kisti;
    }

    public String getL_payable_kisti() {
        return l_payable_kisti;
    }

    public void setL_payable_kisti(String l_payable_kisti) {
        this.l_payable_kisti = l_payable_kisti;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
