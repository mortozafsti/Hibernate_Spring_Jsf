package com.example.classtest2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String BranchName;
    private String BranchAddress;

    public Branch() {
    }

    public Branch(String branchName, String branchAddress) {
        BranchName = branchName;
        BranchAddress = branchAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchAddress() {
        return BranchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        BranchAddress = branchAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id) &&
                Objects.equals(BranchName, branch.BranchName) &&
                Objects.equals(BranchAddress, branch.BranchAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, BranchName, BranchAddress);
    }
}
