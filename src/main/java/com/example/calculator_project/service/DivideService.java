package com.example.calculator_project.service;

import com.example.calculator_project.model.CalRepo;
import com.example.calculator_project.model.Display_table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class DivideService {
    private final CalRepo calRepo;

    public double div(double num1,double num2){
        this.checkZero(num2);
        double ans=num1/num2;
        Display_table dp=new Display_table();
        dp.n1 = num1;
        dp.n2 = num2;
        dp.operation = "Mul";
        dp.result = num1 / num2;
        calRepo.save(dp);
        return ans;

    }
    public void checkZero(double num){
        if(num==0) {
            try{
                throw new ArithmeticException("replace 0");
            } catch (ArithmeticException e) {

            }
        }
    }

}
