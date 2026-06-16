package com.example.calculator_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="User_details")
public class User_table {

    @Id
    @Column(name="email")
    public String e;

    @Column(name="password")
    public String p;
}
