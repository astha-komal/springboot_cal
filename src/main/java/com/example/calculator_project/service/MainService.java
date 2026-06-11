package com.example.calculator_project.service;

import com.example.calculator_project.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MainService {
   // @PutMapping("add")
      public void add_exp(){

      }
    //@PutMapping("sub")
    public void sub_exp(){

    }
    //@PutMapping("mul")
    public void mul_exp(){

    }
    public void div_exp(){
              throw new ArithmeticException("replace 0");

    }

}
