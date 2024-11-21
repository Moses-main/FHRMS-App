package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.model2.Role;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.service.ValidatorService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.util.Arrays;

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
    private ComboBox roleComboBox;

    @FXML
    public void initialize(){
        roleComboBox.getItems().addAll(Role.values());
        roleComboBox.setValue(Role.USER);
    }

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
        String role = roleComboBox.getSelectionModel().getSelectedItem().toString();
        String error= ValidatorService.validateUser(fullName,username,password,confirmPassword);
        if(error==null){
            AuthService.registerUser(fullName,username,password,Role.valueOf(role));
            goToLogin();
        }
        else{
            errorMessageLabel.setText(error);
        }
    }


}
