package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.uicontroller.route.Navigation;

public class SignupController {

    public AnchorPane mainContainer;
    @FXML
    private Button signupButton;

    @FXML
    protected void goToLogin(){
        Stage stage = (Stage) signupButton.getScene().getWindow();
        Navigation.navigateTo("login",stage);
    }
}
