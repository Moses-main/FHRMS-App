package org.example.fhrms;

import org.example.fhrms.model.User;

import java.util.HashMap;
import java.util.UUID;

public class db {
    private final HashMap<String, User> DB=new HashMap<String,User>();

    private static db data=new db();

    private db() {}
    public static db getInstance() {
        if(data==null){
            data=new db();
        }
        return data;
    }

    public User saveUser(User user) {
        String id= UUID.randomUUID().toString();
        User newUser=new User(id,user.username(),user.password());
        DB.put(id,newUser);
        return newUser;
    }
}
