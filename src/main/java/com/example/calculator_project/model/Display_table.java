package com.example.calculator_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="Calculator_Table")
public class Display_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_no")
    public int num;

    @Column(name="val_1")
    public double n1;

    @Column(name="Val_2")
    public double n2;

    @Column(name="Operation")
    public String operation;

    @Column(name="Result")
    public double result;
}
