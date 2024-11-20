package org.example.fhrms.service;

import java.util.Map;

public class ValidatorService {

    public static String validateUser(String fullname, String username, String password , String confirmPassword){
        if(fullname.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")){
            return "Fill in all required fields";
        }

        if(fullname.length() < 5){
            return "Full name should be at least 5 characters";
        }

        if(username.length() < 5){
            return "Username should be at least 5 characters";
        }
        if(password.length() < 5){
            return "Password should be at least 5 characters";
        }

        if(!password.equals(confirmPassword)){
            return "Passwords do not match";
        }

        return  null;
    }
}
