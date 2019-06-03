package com.example.adminecommerce.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subcatName;

    @ManyToOne
    @JoinColumn(name = "CatId",nullable = false)
    private Category category;

    public Subcategory() {
    }

    public Subcategory(String subcatName, Category category) {
        this.subcatName = subcatName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubcatName() {
        return subcatName;
    }

    public void setSubcatName(String subcatName) {
        this.subcatName = subcatName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(subcatName, that.subcatName) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subcatName, category);
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", subcatName='" + subcatName + '\'' +
                ", category=" + category +
                '}';
    }
}
