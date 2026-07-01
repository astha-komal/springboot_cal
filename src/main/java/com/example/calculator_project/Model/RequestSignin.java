package com.example.calculator_project.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestSignin {
  @NotBlank(message = "email is required")
  private String email;

  @NotBlank(message = "password is required")
  private String password;
}
