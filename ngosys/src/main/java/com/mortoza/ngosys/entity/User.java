package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "user_name",unique = true,nullable = false)
    private String userName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "mobile",unique = true)
    private String mobile;

    @Column(name = "firstName",unique = true)
    private String firstName;

    @Column(name = "lastName",unique = true)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date regiDate;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role  role;

    @ManyToOne
    @JoinColumn(name = "ngo_id",nullable = false)
    private Ngo  ngo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    
}
