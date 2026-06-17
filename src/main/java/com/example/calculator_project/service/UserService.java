package com.example.calculator_project.service;

import com.example.calculator_project.Repository.UserRepo;
import com.example.calculator_project.model.User_table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public boolean checkEmail(String email){
        String emailReg="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailReg,email);
    }
    public boolean check(String email){
        boolean existing=userRepo.existsById(email);
        return existing;
    }

    public boolean checkPassword(String password){
        String passReg="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(passReg,password);
    }
    
    public boolean checkConformPassword(String password,String conform_password){
        if(password.equals(conform_password)){
            return true;
        }
        return false;
    }
    public String userSave(String email,String password,String conform_password){
        User_table ut=new User_table();
        if(checkEmail(email) && checkPassword(password) && checkConformPassword(password,conform_password) && !check(email)){
            ut.e=email;
            ut.p=password;
            userRepo.save(ut);
            return "Sign Up Successfully";
        }
        return "User other Credential";
    }

}
