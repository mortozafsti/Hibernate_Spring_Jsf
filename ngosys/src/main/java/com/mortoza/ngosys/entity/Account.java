package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_create")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private Long accountNumber;
    @Column(nullable = false)

    private double primaryDepositAmount;
    private double totalWithdraw;
    private double balanceAmount;

    private String email;
    @Column(nullable = false, unique = true)
    private String mobile;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, unique = true)
    private String nid;
    @Column(nullable = false)
    private String profession;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;

    @ManyToOne
    @JoinColumn(name = "acc_type_id", nullable = false)
    private AccountType accountType;
}
