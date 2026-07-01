package com.example.calculator_project.Service;

import com.example.calculator_project.Exception.UserAlreadyExistsException;
import com.example.calculator_project.Repository.UserRepo;
import com.example.calculator_project.Model.RequestSignin;
import com.example.calculator_project.Model.RequestSignup;
import com.example.calculator_project.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public User signup(RequestSignup request) {

    if (userRepo.existsByEmail(request.getEmail())) {
      throw new UserAlreadyExistsException("Email is already exists");
    }
    if (!request.getPassword().equals(request.getConform_password())) {
      throw new IllegalArgumentException("password do not match");
    }
    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    return userRepo.save(user);
  }

  public User signin(RequestSignin request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    return userRepo.findByEmail(request.getEmail()).orElseThrow();
  }
}
