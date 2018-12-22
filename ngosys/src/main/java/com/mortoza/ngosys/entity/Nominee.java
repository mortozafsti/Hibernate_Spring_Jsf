package com.mortoza.ngosys.entity;

import javax.persistence.*;

@Entity
@Table(name = "nominee")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "n_name",nullable = false)
    private String n_name;

    @Column(name = "n_address",nullable = false)
    private String n_address;

    @Column(name = "n_mobile",nullable = false)
    private String n_mobile;

    @Column(name = "n_dob",nullable = false)
    private String n_dob;

    @Column(name = "n_nid",nullable = false)
    private String n_nid;

    @Column(name = "n_gender",nullable = false)
    private String n_gender;

    @Column(name = "n_relation",nullable = false)
    private String n_relation;
}
