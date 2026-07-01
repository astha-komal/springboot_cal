package com.example.calculator_project.Repository;

import com.example.calculator_project.Model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);
}
