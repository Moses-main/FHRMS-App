package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SettingsController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailField;

    public void handleSaveSettings(ActionEvent event) {
        // Logic to save settings (e.g., validate and update password or email)
    }
}
