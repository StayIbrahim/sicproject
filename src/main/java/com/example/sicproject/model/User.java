package com.example.sicproject.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ourusers")
@Data
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true, length = 100, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;



}