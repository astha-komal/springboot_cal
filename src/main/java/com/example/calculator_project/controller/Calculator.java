package com.example.calculator_project.controller;

import com.example.calculator_project.model.Request;
//import com.example.calculator_project.calservice.MainService;
import com.example.calculator_project.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cal")
public class Calculator {
    @Autowired
    MainService ms;

   @GetMapping("/add")
    public double cal_final(@RequestBody Request tk){
           return tk.n1+tk.n2;
    }
    @GetMapping("/sub")
    public double cal_final2(@RequestBody Request tk){
        return tk.n1-tk.n2;
    }
    @GetMapping("/mul")
    public double cal_final3(@RequestBody Request tk){
        return tk.n1*tk.n2;
    }
    @GetMapping("/div")
    public double cal_final4(@RequestBody Request tk){
        if(tk.n2==0){
            ms.div_exp();
        }
        return tk.n1/tk.n2;
    }
}
