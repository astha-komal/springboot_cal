package com.example.calculator_project.Controller;

import com.example.calculator_project.Model.RequestSignin;
import com.example.calculator_project.Model.RequestSignup;
import com.example.calculator_project.Model.User;
import com.example.calculator_project.Responses.LoginResponse;
import com.example.calculator_project.Service.AuthenticationService;
import com.example.calculator_project.Service.JwtService;
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
  public ResponseEntity<User> signup(@Valid @RequestBody RequestSignup request) {
    User registeredUser = authenticationService.signup(request);
    return ResponseEntity.ok(registeredUser);
  }

  @PostMapping("/signin")
  public ResponseEntity<LoginResponse> signin(@Valid @RequestBody RequestSignin request) {
    User authenticatedUser = authenticationService.signin(request);

    String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);

    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setToken(jwtToken);
    loginResponse.setExpiresIn(jwtService.getExpirationTime());
    return ResponseEntity.ok(loginResponse);
  }
}
