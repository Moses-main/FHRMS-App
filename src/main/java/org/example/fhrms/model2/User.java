package org.example.fhrms.model2;


public record User(String id, String fullname, String username, String password,Role userRole) {
    public String getId(){
        return id;
    }

    public String getFullname(){
        return fullname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Role getUserRole(){
        return userRole;
    }
}
