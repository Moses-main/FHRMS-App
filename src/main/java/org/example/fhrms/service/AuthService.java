package org.example.fhrms.service;

import org.example.fhrms.db;
import org.example.fhrms.model2.Role;
import org.example.fhrms.model2.User;

import java.util.Optional;
import java.util.UUID;

public class AuthService {

    private User AuthenticatedUser;
    private boolean userAuthenticated = false;
    private String errorMessage = null;
    private static AuthService authService;

    private AuthService() {
    }

    public User getAuthenticatedUser() {
        return AuthenticatedUser;
    }

    public void setAuthenticatedUser(User user) {
        this.AuthenticatedUser = user;
        this.userAuthenticated = user != null;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }

    public static AuthService getAuthService() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;
    }

    public static void loginUser(String username, String password) {
        AuthService authService = getAuthService();
        Optional<User> user = db.getInstance().getUserByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            authService.setAuthenticatedUser(user.get());
            authService.setErrorMessage("");
        } else {
            authService.setAuthenticatedUser(null);
            authService.setErrorMessage("Invalid creditials");
        }
    }

    public static void registerUser(String fullname, String username, String password, Role role) {
        User user = new User(null, fullname, username, password,role);
        User savedUser = db.getInstance().saveUser(user);
        if (savedUser != null) {
            System.out.println("User registered successfully");
            System.out.println(savedUser.id());
        }
    }

    public static void logoutUser(){
        AuthService authService = getAuthService();
        authService.setAuthenticatedUser(null);
        authService.setErrorMessage("");
    }
}
