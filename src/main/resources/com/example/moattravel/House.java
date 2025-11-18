package com.example.moattravel.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer price;
    private String description;
    private String address;
}
