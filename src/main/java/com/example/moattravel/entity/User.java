package com.example.moattravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    private String furigana;

    private String postalCode;

    private String address;

    private String phoneNumber;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
