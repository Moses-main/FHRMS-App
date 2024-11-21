package org.example.fhrms;

import org.example.fhrms.model2.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
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
        User newUser=new User(id,user.fullname(),user.username(),user.password(),null);
        DB.put(id,newUser);
        return newUser;
    }

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        for(User user:DB.values()) {
            if(user.username().equals(username) && user.password().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
