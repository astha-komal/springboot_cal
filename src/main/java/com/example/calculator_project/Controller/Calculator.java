package com.example.calculator_project.Controller;

import com.example.calculator_project.Model.Request;
import com.example.calculator_project.Service.AddService;
import com.example.calculator_project.Service.DivideService;
import com.example.calculator_project.Service.MulService;
import com.example.calculator_project.Service.SubService;
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
  public double addOperation(@RequestBody Request request) {


    System.out.println("111");
    return addService.add(request.getNum1(), request.getNum2());
  }

  @PostMapping("/sub")
  public double subtractionOperation(@RequestBody Request request) {
    return subService.sub(request.getNum1(), request.getNum2());
  }

  @PostMapping("/mul")
  public double multiplicationOperation(@RequestBody Request request) {
    return mulService.mul(request.getNum1(), request.getNum2());
  }

  @PostMapping("/div")
  public double divisionOperation(@RequestBody Request request) {
    return divideService.div(request.getNum1(), request.getNum2());
  }

}
