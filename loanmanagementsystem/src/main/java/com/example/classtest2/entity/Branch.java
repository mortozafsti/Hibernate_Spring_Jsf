package com.example.classtest2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchName;
    private String branchAddress;

    public Branch() {
    }
    public Branch(Long id) {
        this.id=id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id) &&
                Objects.equals(branchName, branch.branchName) &&
                Objects.equals(branchAddress, branch.branchAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchName, branchAddress);
    }
}
