package com.example.classtest2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "member")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "m_name", nullable = false)
    private String m_name;

    @Column(name = "m_code", unique = true, nullable = false)
    private String m_code;

    @Column(name = "m_gender", nullable = false)
    private String m_gender;

    @Column(name = "m_mobile", nullable = false)
    private String m_mobile;

    @Column(name = "m_address", nullable = false)
    private String m_address;

    @Column(name = "m_nid", unique = true, nullable = false)
    private String m_nid;

    @Column(name = "m_admit_fee", nullable = false)
    private double m_admit_fee;




    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regi_date;

    @ManyToOne
    @JoinColumn(name = "ngo_id", nullable = false)
    private Ngo ngo;


    @ManyToOne
    @JoinColumn(name = "nominee_id", nullable = false)
    private Nominee nominee;

    @ManyToOne
    @JoinColumn(name = "B_Id", nullable = false)
    private Branch branch;

    public Member() {
    }

    public Member(Long id) {
        this.id=id;
    }
    public Member(String m_name, String m_code, String m_gender, String m_mobile, String m_address, String m_nid, double m_admit_fee, Date regi_date, Ngo ngo, Nominee nominee, Branch branch) {
        this.m_name = m_name;
        this.m_code = m_code;
        this.m_gender = m_gender;
        this.m_mobile = m_mobile;
        this.m_address = m_address;
        this.m_nid = m_nid;
        this.m_admit_fee = m_admit_fee;
        this.regi_date = regi_date;
        this.ngo = ngo;
        this.nominee = nominee;
        this.branch = branch;
    }

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

    public double getM_admit_fee() {
        return m_admit_fee;
    }

    public void setM_admit_fee(double m_admit_fee) {
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Double.compare(member.m_admit_fee, m_admit_fee) == 0 &&
                Objects.equals(id, member.id) &&
                Objects.equals(m_name, member.m_name) &&
                Objects.equals(m_code, member.m_code) &&
                Objects.equals(m_gender, member.m_gender) &&
                Objects.equals(m_mobile, member.m_mobile) &&
                Objects.equals(m_address, member.m_address) &&
                Objects.equals(m_nid, member.m_nid) &&
                Objects.equals(regi_date, member.regi_date) &&
                Objects.equals(ngo, member.ngo) &&
                Objects.equals(nominee, member.nominee) &&
                Objects.equals(branch, member.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, m_name, m_code, m_gender, m_mobile, m_address, m_nid, m_admit_fee, regi_date, ngo, nominee, branch);
    }
}
