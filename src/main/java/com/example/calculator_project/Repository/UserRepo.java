package com.example.calculator_project.Repository;

import com.example.calculator_project.model.User_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User_table,String> {

}
