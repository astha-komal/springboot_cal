package com.example.calculator_project.Model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User_details")
public class User implements UserDetails {
  @Id
  @Column(unique = true, length = 100, nullable = false, name = "email")
  private String email;

  @Column(nullable = false, name = "password")
  private String password;

  @CreationTimestamp
  @Column(updatable = false, name = "created_at")
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

  @Override
  @NonNull
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  @NonNull
  public String getUsername() {
    return email;
  }
}
