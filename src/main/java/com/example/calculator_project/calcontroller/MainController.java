package com.example.calculator_project.calcontroller;

import com.example.calculator_project.TakeInput;
//import com.example.calculator_project.calservice.MainService;
import com.example.calculator_project.calservice.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cal")
public class MainController {
    @Autowired
    MainService ms;
    @GetMapping("/add")
    public double cal_final(@RequestBody TakeInput tk){
           return tk.n1+tk.n2;
    }
    @GetMapping("/sub")
    public double cal_final2(@RequestBody TakeInput tk){
        return tk.n1-tk.n2;
    }
    @GetMapping("/mul")
    public double cal_final3(@RequestBody TakeInput tk){
        return tk.n1*tk.n2;
    }
    @GetMapping("/div")
    public double cal_final4(@RequestBody TakeInput tk){
        return tk.n1/tk.n2;
    }
}
