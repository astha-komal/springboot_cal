package com.example.calculator_project.controller;

import com.example.calculator_project.model.Request;
import com.example.calculator_project.service.AddService;
import com.example.calculator_project.service.DivideService;
import com.example.calculator_project.service.MulService;
import com.example.calculator_project.service.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cal")
public class Calculator {
  private final DivideService divideService;

  private final AddService addService;

  private final SubService subService;

  private final MulService mulService;

  @PostMapping("/add")
  public double cal_final(@RequestBody Request request) {
    return addService.add(request.num1, request.num2);
  }

  @PostMapping("/sub")
  public double cal_final2(@RequestBody Request request) {
    return subService.sub(request.num1, request.num2);
  }

  @PostMapping("/mul")
  public double cal_final3(@RequestBody Request request) {
    return mulService.mul(request.num1, request.num2);
  }

  @PostMapping("/div")
  public double cal_final4(@RequestBody Request request) {
    return divideService.div(request.num1, request.num2);
  }
}
