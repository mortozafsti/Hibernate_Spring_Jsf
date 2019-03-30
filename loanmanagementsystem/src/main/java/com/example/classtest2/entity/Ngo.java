package com.example.classtest2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ngo")
public class Ngo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String ownersName;
    private String email;
    private String mobile;
    private String address;
    private String service;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regiDate;

    public Ngo() {
    }

    public Ngo(String name, String ownersName, String email, String mobile, String address, String service, Date regiDate) {
        this.name = name;
        this.ownersName = ownersName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.service = service;
        this.regiDate = regiDate;
    }

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

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ngo ngo = (Ngo) o;
        return Objects.equals(id, ngo.id) &&
                Objects.equals(name, ngo.name) &&
                Objects.equals(ownersName, ngo.ownersName) &&
                Objects.equals(email, ngo.email) &&
                Objects.equals(mobile, ngo.mobile) &&
                Objects.equals(address, ngo.address) &&
                Objects.equals(service, ngo.service) &&
                Objects.equals(regiDate, ngo.regiDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownersName, email, mobile, address, service, regiDate);
    }
}
