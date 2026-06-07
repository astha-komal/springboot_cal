package com.example.calculator_project.calservice;

import org.springframework.stereotype.Service;

@Service
public class MainService {
     public double cal(int n1,int n2,String op){
         if(op.equals("+")){
             return n1+n2;
         }
         else if(op.equals("-")){
             return n1-n2;
         }
         else if(op.equals("*")){
             return n1*n2;
         }
         else if(op.equals("/")){
             if(n2==0){
                 throw new ArithmeticException("replace 0");
             }
             return n1/(double)n2;
         }
         else{
             return 0;
         }
     }
}
