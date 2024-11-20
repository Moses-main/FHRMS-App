package org.example.fhrms.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.fhrms.route.Navigation;

public class SignupController {

    @FXML
    private Button signupButton;

    @FXML
    protected void goToLogin(){
        Stage stage = (Stage) signupButton.getScene().getWindow();
        Navigation.navigateTo("auth/login-view.fxml",stage);
    }
}
