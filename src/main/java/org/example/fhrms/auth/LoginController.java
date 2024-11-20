package org.example.fhrms.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.fhrms.route.Navigation;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    protected void loginUser(){
        System.out.println("Loggin user");
        Stage stage=(Stage) loginButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("auth/signup-view.fxml",stage);
    }

    @FXML
    protected void login(){

    }

}
