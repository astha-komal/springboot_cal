package com.example.calculator_project.controller;

import com.example.calculator_project.model.CalRepo;
import com.example.calculator_project.model.Display_table;
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

    @Autowired
    private CalRepo req;

   @PostMapping("/add")
    public double cal_final(@RequestBody Request tk){
      // req.save(tk);
       double ans=tk.n1+tk.n2;
       Display_table dp=new Display_table();
       dp.n1 = tk.n1;
       dp.n2 = tk.n2;
       dp.operation = "ADD";
       dp.result = tk.n1 + tk.n2;
       req.save(dp);
       return ans;
    }
    @PostMapping("/sub")
    public double cal_final2(@RequestBody Request tk){
         // req.save(tk);
        double ans1=tk.n1-tk.n2;
        Display_table dp=new Display_table();
        dp.n1 = tk.n1;
        dp.n2 = tk.n2;
        dp.operation = "sub";
        dp.result = tk.n1-tk.n2;
        req.save(dp);
        return ans1;
    }
    @PostMapping("/mul")
    public double cal_final3(@RequestBody Request tk){
        //req.save(tk);
        double ans2=tk.n1*tk.n2;
        Display_table dp=new Display_table();
        dp.n1 = tk.n1;
        dp.n2 = tk.n2;
        dp.operation = "Mul";
        dp.result = tk.n1* tk.n2;
        req.save(dp);
        return ans2;
    }
    @PostMapping("/div")
    public double cal_final4(@RequestBody Request tk){
        if(tk.n2==0){
            ms.div_exp();
        }
        //req.save(tk);
        double ans3=tk.n1/tk.n2;
        Display_table dp=new Display_table();
        dp.n1 = tk.n1;
        dp.n2 = tk.n2;
        dp.operation = "Div";
        dp.result = tk.n1/tk.n2;
        req.save(dp);
        return ans3;
    }
}
