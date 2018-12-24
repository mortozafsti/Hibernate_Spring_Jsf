package com.mortoza.ngosys.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "m_name", nullable = false)
    private String m_name;

    @Column(name = "m_code",unique = true,nullable = false)
    private String m_code;

    @Column(name = "m_gender",nullable = false)
    private String m_gender;

    @Column(name = "m_mobile",nullable = false)
    private String m_mobile;

    @Column(name = "m_address",nullable = false)
    private String m_address;

    @Column(name = "m_nid",unique = true,nullable = false)
    private String m_nid;

    @Column(name = "m_admit_fee",nullable = false)
    private String m_admit_fee;

    @Temporal(TemporalType.DATE)
    private Date regi_date;

    @ManyToOne
    @JoinColumn(name = "ngo_id",nullable = false)
    private Ngo ngo;

    @ManyToOne
    @JoinColumn(name = "nominee_id",nullable = false)
    private Nominee nominee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_code() {
        return m_code;
    }

    public void setM_code(String m_code) {
        this.m_code = m_code;
    }

    public String getM_gender() {
        return m_gender;
    }

    public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
    }

    public String getM_mobile() {
        return m_mobile;
    }

    public void setM_mobile(String m_mobile) {
        this.m_mobile = m_mobile;
    }

    public String getM_address() {
        return m_address;
    }

    public void setM_address(String m_address) {
        this.m_address = m_address;
    }

    public String getM_nid() {
        return m_nid;
    }

    public void setM_nid(String m_nid) {
        this.m_nid = m_nid;
    }

    public String getM_admit_fee() {
        return m_admit_fee;
    }

    public void setM_admit_fee(String m_admit_fee) {
        this.m_admit_fee = m_admit_fee;
    }

    public Date getRegi_date() {
        return regi_date;
    }

    public void setRegi_date(Date regi_date) {
        this.regi_date = regi_date;
    }

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }
}
