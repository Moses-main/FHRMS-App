package org.example.fhrms.admin;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminDashboardController {

    @FXML
    private Button manageUsersButton;

    @FXML
    private Button manageRolesButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    // Event handler for the "Manage Users" button
    @FXML
    private void handleManageUsers() {
        System.out.println("Manage Users clicked");
        // Add your logic for managing users
    }

    // Event handler for the "Manage Roles" button
    @FXML
    private void handleManageRoles() {
        System.out.println("Manage Roles clicked");
        // Add your logic for managing roles
    }

    // Event handler for the "Settings" button
    @FXML
    private void handleSettings() {
        System.out.println("Settings clicked");
        // Add your logic for settings
    }

    // Event handler for the "Logout" button
    @FXML
    private void handleLogout() {
        System.out.println("Logout clicked");
        // Add your logic for logout
    }
}
