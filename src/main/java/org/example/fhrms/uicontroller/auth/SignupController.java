package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

import org.example.fhrms.HelloApplication;

public class SignupController {

    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private Label errorMessageLabel;

    // This method will be called when the user clicks the "Sign Up" button
    @FXML
    public void signUp() {
        // Get values from input fields
        String fullName = fullNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        String selectedRole = roleComboBox.getValue();

        // Basic validation
        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                || selectedRole == null) {
            errorMessageLabel.setText("All fields must be filled in.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            errorMessageLabel.setText("Passwords do not match.");
            return;
        }

        // Here you would typically handle saving the user data to the database, but for
        // now, we just print it
        System.out.println("Full Name: " + fullName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Selected Role: " + selectedRole);

        // Redirect to login page after successful signup
        redirectToLogin();

        // Clear the fields after signup
        clearFields();
    }

    // Method to navigate to the Login Page after Signup
    private void redirectToLogin() {
        System.out.println("Redirecting to Login Page...");

        // Assuming you have a method to change the scene to login
        // This would typically load the login FXML for the Login page
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auth/login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) fullNameTextField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("Error navigating to the login page.");
        }
    }

    // This method will be called when the user clicks the "Already have an account?
    // Login" hyperlink
    @FXML
    public void goToLogin() {
        redirectToLogin();
    }

    // Clear the input fields after signup
    private void clearFields() {
        fullNameTextField.clear();
        usernameTextField.clear();
        passwordTextField.clear();
        confirmPasswordTextField.clear();
        roleComboBox.setValue(null);
    }

    // Initialize the ComboBox with available roles
    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll("Admin", "Waiter", "Chef");
    }
}
