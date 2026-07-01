package com.example.calculator_project.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalRepo extends JpaRepository<Display_table, Integer> {}
