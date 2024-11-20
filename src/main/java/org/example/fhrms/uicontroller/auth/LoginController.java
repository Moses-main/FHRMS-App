package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void goToSignup(){
        Stage stage=(Stage) loginButton.getScene().getWindow();
        Navigation.navigateTo("signup",stage);
    }

    @FXML
    protected void login(){
        String username=usernameField.getText();
        String password=passwordField.getText();
        AuthService.registerUser(username,password);
        goToSignup();
    }

}
