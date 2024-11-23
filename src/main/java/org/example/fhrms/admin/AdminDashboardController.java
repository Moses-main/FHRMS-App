package org.example.fhrms.admin;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdminDashboardController {

    @FXML
    private Button manageUsersButton;

    @FXML
    private Button manageRolesButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button inventoryManagementButton;

    @FXML
    private Button GenerateReportsButton;

    // Event handler for the "Manage Users" button
    @FXML
    private void handleManageUsers() {
        System.out.println("Manage Users clicked");
        showAlert("Manage Users", "You can now add, update, or delete user");
        // Add your logic for managing users
    }

    // Event handler for the "Manage Roles" button
    @FXML
    private void handleManageRoles() {
        System.out.println("Manage Roles clicked");
        showAlert("Manage Roles", "You can now manage inventory and stock");
        // Add your logic for managing roles
    }

    // Event handler for the "Inventory Management" button
    @FXML
    private void handleInventoryManagement() {
        // Placeholder: Navigate to the Inventory Management screen
        System.out.println("Inventory Management clicked");
        showAlert("Inventory Management", "You can now manage inventory and stock.");
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Event handler for the "Settings" button
    @FXML
    private void handleSettings() {
        // Placeholder: Navigate to the Inventory Management screen
        System.out.println("System Settings clicked");
        showAlert("System Settings", "You can now manage sytem settings.");
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Event handler for the "Logout" button
    @FXML
    private void handleLogout() {
        System.out.println("Logout clicked");
        showAlert("Logout", "You have been logged out");
        // Add your logic for logout
    }

    @FXML
    private void handleGenerateReport() {
        System.out.println("Generate Reports clicked");
        showAlert("Generate Reports", "You can now manage generated reports.");
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Utility method to show alerts for demonstration
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
