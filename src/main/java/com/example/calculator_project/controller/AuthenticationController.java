package com.example.calculator_project.controller;

import com.example.calculator_project.model.Request_Signup;
import com.example.calculator_project.model.Request_signin;
import com.example.calculator_project.model.User;
import com.example.calculator_project.responses.LoginResponse;
import com.example.calculator_project.service.AuthenticationService;
import com.example.calculator_project.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
  private final JwtService jwtService;

  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<User> register(@Valid @RequestBody Request_Signup request) {
    User registeredUser = authenticationService.signup(request);

    return ResponseEntity.ok(registeredUser);
  }

  @PostMapping("/signin")
  public ResponseEntity<LoginResponse> authenticate(@RequestBody Request_signin request) {
    User authenticatedUser = authenticationService.authenticate(request);

    String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);

    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setToken(jwtToken);
    loginResponse.setExpiresIn(jwtService.getExpirationTime());

    return ResponseEntity.ok(loginResponse);
  }
}
