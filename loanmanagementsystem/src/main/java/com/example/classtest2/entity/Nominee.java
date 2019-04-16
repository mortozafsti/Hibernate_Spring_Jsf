package com.example.classtest2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "nominee")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "n_name", nullable = false)
    private String n_name;

    @Column(name = "n_address", nullable = false)
    private String n_address;

    @Column(name = "n_mobile", nullable = false)
    private String n_mobile;

    @Column(name = "n_age", nullable = false)
    private int age;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date n_dob;

    @Column(name = "n_nid", nullable = false)
    private String n_nid;

    @Column(name = "n_gender", nullable = false)
    private String n_gender;

    @Column(name = "n_relation", nullable = false)
    private String n_relation;


    public Nominee() {
    }

    public Nominee(String n_name, String n_address, String n_mobile, int age, Date n_dob, String n_nid, String n_gender, String n_relation) {
        this.n_name = n_name;
        this.n_address = n_address;
        this.n_mobile = n_mobile;
        this.age = age;
        this.n_dob = n_dob;
        this.n_nid = n_nid;
        this.n_gender = n_gender;
        this.n_relation = n_relation;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nominee nominee = (Nominee) o;
        return age == nominee.age &&
                Objects.equals(id, nominee.id) &&
                Objects.equals(n_name, nominee.n_name) &&
                Objects.equals(n_address, nominee.n_address) &&
                Objects.equals(n_mobile, nominee.n_mobile) &&
                Objects.equals(n_dob, nominee.n_dob) &&
                Objects.equals(n_nid, nominee.n_nid) &&
                Objects.equals(n_gender, nominee.n_gender) &&
                Objects.equals(n_relation, nominee.n_relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, n_name, n_address, n_mobile, age, n_dob, n_nid, n_gender, n_relation);
    }
}
