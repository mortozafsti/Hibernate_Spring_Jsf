package com.example.adminecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String scatName;
    private
}
