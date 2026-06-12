package com.example.calculator_project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalRepo extends JpaRepository<Display_table,Integer> {

}
