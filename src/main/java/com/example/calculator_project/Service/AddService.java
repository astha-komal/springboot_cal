package com.example.calculator_project.Service;

import com.example.calculator_project.Model.CalRepo;
import com.example.calculator_project.Model.Display_table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddService {

  private final CalRepo calRepo;

  public double add(double num1, double num2) {
    double ans = num1 + num2;
    Display_table dp = new Display_table();
    dp.n1 = num1;
    dp.n2 = num2;
    dp.operation = "ADD";
    dp.result = num1 + num2;
    calRepo.save(dp);
    return ans;
  }
}
