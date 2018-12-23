package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    private Date n_dob;

    @Column(name = "n_nid",nullable = false)
    private String n_nid;

    @Column(name = "n_gender",nullable = false)
    private String n_gender;

    @Column(name = "n_relation",nullable = false)
    private String n_relation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getN_address() {
        return n_address;
    }

    public void setN_address(String n_address) {
        this.n_address = n_address;
    }

    public String getN_mobile() {
        return n_mobile;
    }

    public void setN_mobile(String n_mobile) {
        this.n_mobile = n_mobile;
    }

    public Date getN_dob() {
        return n_dob;
    }

    public void setN_dob(Date n_dob) {
        this.n_dob = n_dob;
    }

    public String getN_nid() {
        return n_nid;
    }

    public void setN_nid(String n_nid) {
        this.n_nid = n_nid;
    }

    public String getN_gender() {
        return n_gender;
    }

    public void setN_gender(String n_gender) {
        this.n_gender = n_gender;
    }

    public String getN_relation() {
        return n_relation;
    }

    public void setN_relation(String n_relation) {
        this.n_relation = n_relation;
    }
}
