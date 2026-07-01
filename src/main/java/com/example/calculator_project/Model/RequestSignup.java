package com.example.calculator_project.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestSignup {
  @NotBlank(message = "email is required")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "password is required")
  @Pattern(
      regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
      message = "Password must contain at least 8 characters, one letter and one number")
  private String password;

  @NotBlank(message = "conform password is required")
  private String conform_password;
}
