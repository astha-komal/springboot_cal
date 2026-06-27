package com.example.calculator_project.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request_Signup {
  @NotBlank(message = "email is required")
  @Email(message = "Invalid email format")
  public String email;

  @NotBlank(message = "password is required")
  @Pattern(
      regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
      message = "Password must contain at least 8 characters, one letter and one number")
  public String password;

  @NotBlank(message = "conform password is required")
  public String conform_password;
}
