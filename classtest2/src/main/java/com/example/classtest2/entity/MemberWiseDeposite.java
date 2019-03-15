package com.example.classtest2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "memberwisedeposite")
public class MemberWiseDeposite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "L_Branch", nullable = false)
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "M_Name", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "N_Name", nullable = false)
    private Nominee nominee;

    @ManyToOne
    @JoinColumn(name = "D_Amount", nullable = false)
    private Deposite deposite;

    public MemberWiseDeposite() {
    }

    public MemberWiseDeposite(Loan loan, Member member, Nominee nominee, Deposite deposite) {
        this.loan = loan;
        this.member = member;
        this.nominee = nominee;
        this.deposite = deposite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    public Deposite getDeposite() {
        return deposite;
    }

    public void setDeposite(Deposite deposite) {
        this.deposite = deposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberWiseDeposite that = (MemberWiseDeposite) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(loan, that.loan) &&
                Objects.equals(member, that.member) &&
                Objects.equals(nominee, that.nominee) &&
                Objects.equals(deposite, that.deposite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loan, member, nominee, deposite);
    }
}
