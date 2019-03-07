package com.example.classtest2.entity;

import javax.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long nOfKisti;
    private Long nOfAmount;
    private Long nO;


}
