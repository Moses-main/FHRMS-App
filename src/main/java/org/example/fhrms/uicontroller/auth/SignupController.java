package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
// import org.example.fhrms.MainApp;  // Assuming you have a MainApp class to handle scene switching

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

        // Redirect to a different dashboard based on the selected role
        switch (selectedRole) {
            case "Admin":
                loadAdminDashboard();
                break;
            case "Waiter":
                loadWaiterDashboard();
                break;
            case "Chef":
                loadChefDashboard();
                break;
            default:
                errorMessageLabel.setText("Invalid role selected.");
        }

        // Clear the fields after signup
        clearFields();
    }

    // Method to navigate to Admin Dashboard
    private void loadAdminDashboard() {
        System.out.println("Redirecting to Admin Dashboard...");
        // You can create a new scene here for the Admin dashboard or handle the logic
        // specific to the Admin role
        // For now, just print a message or navigate to the Admin dashboard
        showDashboard("Admin");
    }

    // Method to navigate to Waiter Dashboard
    private void loadWaiterDashboard() {
        System.out.println("Redirecting to Waiter Dashboard...");
        showDashboard("Waiter");
    }

    // Method to navigate to Chef Dashboard
    private void loadChefDashboard() {
        System.out.println("Redirecting to Chef Dashboard...");
        showDashboard("Chef");
    }

    // This method handles the generic dashboard logic
    private void showDashboard(String role) {
        // You can load a new scene for the specific role's dashboard.
        // For example, this could load a new FXML file for each dashboard.
        System.out.println(role + " Dashboard loaded.");

        // Assuming you have a method to change the scene based on the role
        // For now, just print the role for debugging
        // Replace this with actual scene switching logic
        // Example: load the specific FXML for the selected role's dashboard
    }

    // This method will be called when the user clicks the "Already have an account?
    // Login" hyperlink
    @FXML
    public void goToLogin() {
        // Here you can handle navigation to the login screen
        System.out.println("Navigating to login screen...");
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
