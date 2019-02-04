package com.mortoza.ngosys.entity;

import javax.persistence.*;

@Entity
@Table(name = "withdraw")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "withdraw_brance", nullable = false)
    private String withdraw_brance;

    @Column(name = "withdraw_date", nullable = false)
    private String withdraw_date;

    @Column(name = "withdraw_amount", nullable = false)
    private String withdraw_amount;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;


}
