package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.fhrms.model2.User;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.util.Timer;
import java.util.TimerTask;

public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessageLabel;

    protected void goToDashboard(String route) {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Navigation.navigateTo(route, stage);
            }
        }, 1000);
    }

    @FXML
    protected void goToSignup() {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Navigation.navigateTo("signup", stage);
    }

    @FXML
    protected void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        AuthService.loginUser(username, password);
        if (AuthService.getAuthService().isUserAuthenticated()) {
            errorMessageLabel.setText("User successfully logged in");
            User user = AuthService.getAuthService().getAuthenticatedUser();
            switch (user.userRole()) {
                case USER -> goToDashboard("user");
                case ADMIN -> goToDashboard("admin");
                case CHEF -> goToDashboard("chef");
                case WAITER -> goToDashboard("waiter");
            }
        } else {
            errorMessageLabel.setText(AuthService.getAuthService().getErrorMessage());
        }
    }

}
