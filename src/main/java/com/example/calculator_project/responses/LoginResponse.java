package com.example.calculator_project.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
  private String token;

  private long expiresIn;
}
