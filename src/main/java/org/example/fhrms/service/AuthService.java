package org.example.fhrms.service;

import org.example.fhrms.db;
import org.example.fhrms.model.User;

import java.util.UUID;

public class AuthService {

    public static void registerUser(String username,String password){
        User user=new User(null,username,password);
        User savedUser=db.getInstance().saveUser(user);
        if(savedUser!=null){
            System.out.println("User registered successfully");
            System.out.println(savedUser.id());
        }
    }

    public static void loginUser(){

    }
}
