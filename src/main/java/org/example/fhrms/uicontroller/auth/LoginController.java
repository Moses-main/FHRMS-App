package org.example.fhrms.uicontroller.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import org.example.fhrms.HelloApplication;

public class LoginController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label errorMessageLabel;

    // This method will be called when the user clicks the "Login" button
    @FXML
    public void login() {
        // Get the values entered by the user
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Basic validation (you can expand this with actual login logic)
        if (username.isEmpty() || password.isEmpty()) {
            errorMessageLabel.setText("Username and Password cannot be empty.");
            return;
        }

        // Assuming we have a method to check user credentials (replace this with actual
        // authentication logic)
        if (checkCredentials(username, password)) {
            // Check user role and navigate to the respective dashboard
            String role = getUserRole(username); // This is a placeholder, fetch the role from your data source

            switch (role) {
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
                    errorMessageLabel.setText("Invalid role.");
                    break;
            }
        } else {
            errorMessageLabel.setText("Invalid username or password.");
        }
    }

    // Dummy method to check if the credentials are correct (replace with actual
    // logic)
    private boolean checkCredentials(String username, String password) {
        // For now, assume all users have the same password for testing
        return username.equals("user") && password.equals("password123");
    }

    // Dummy method to fetch user role (replace with actual logic)
    private String getUserRole(String username) {
        // This should return the role of the user from your database or storage
        return "Admin"; // Placeholder return value
    }

    // Load Admin Dashboard
    private void loadAdminDashboard() {
        System.out.println("Redirecting to Admin Dashboard...");
        loadDashboard("Admin");
    }

    // Load Waiter Dashboard
    private void loadWaiterDashboard() {
        System.out.println("Redirecting to Waiter Dashboard...");
        loadDashboard("Waiter");
    }

    // Load Chef Dashboard
    private void loadChefDashboard() {
        System.out.println("Redirecting to Chef Dashboard...");
        loadDashboard("Chef");
    }

    // Method to load the corresponding dashboard based on the role
    private void loadDashboard(String role) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("auth/login/" + role.toLowerCase() + "Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("Error loading the dashboard.");
        }
    }
}
