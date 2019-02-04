package com.mortoza.ngosys.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ngo")
public class Ngo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngo_name", unique = true, nullable = false)
    private String name;

    @Column(name = "ngo_owner", unique = true, nullable = false)
    private String owner;

    @Column(name = "mobile", unique = true, nullable = false)
    private String mobile;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "ngo_service", unique = true)
    private String ngo_service;

    @Temporal(TemporalType.DATE)
    private Date n_regi_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNgo_service() {
        return ngo_service;
    }

    public void setNgo_service(String ngo_service) {
        this.ngo_service = ngo_service;
    }

    public Date getN_regi_date() {
        return n_regi_date;
    }

    public void setN_regi_date(Date n_regi_date) {
        this.n_regi_date = n_regi_date;
    }
}
