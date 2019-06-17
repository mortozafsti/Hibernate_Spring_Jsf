package com.example.adminecommerce.entity;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String brandName;
    private String brandLocation;
    private String categoryID;
    private String code;


}
