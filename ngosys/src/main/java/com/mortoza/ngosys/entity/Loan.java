package com.mortoza.ngosys.entity;

import javax.persistence.*;

@Entity
@Table( name = "deposit")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loan_brance;
    private String loan_date;
    private double loan_amount;

    private Member member;


}
