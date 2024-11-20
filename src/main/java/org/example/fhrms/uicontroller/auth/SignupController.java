package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.service.ValidatorService;
import org.example.fhrms.uicontroller.route.Navigation;

public class SignupController {

    public AnchorPane mainContainer;
    @FXML
    private Button signupButton;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;


    @FXML
    protected void goToLogin(){
        Stage stage = (Stage) signupButton.getScene().getWindow();
        Navigation.navigateTo("login",stage);
    }

    @FXML
    protected void signUp(){
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();
        String confirmPassword = confirmPasswordTextField.getText().trim();
        String fullName = fullNameTextField.getText().trim();
        String error= ValidatorService.validateUser(fullName,username,password,confirmPassword);
        if(error==null){
            AuthService.registerUser(fullName,username,password,confirmPassword);
            goToLogin();
        }
        else{
            errorMessageLabel.setText(error);
        }
    }


}
