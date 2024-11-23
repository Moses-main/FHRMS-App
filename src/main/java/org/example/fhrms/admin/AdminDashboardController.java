package org.example.fhrms.admin;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

public class AdminDashboardController {

    @FXML
    private Button manageUsersButton;

    @FXML
    private Button manageRolesButton;

    @FXML
    private AnchorPane adminAnchorPane;
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
        // showAlert("Manage Users", "You can now add, update, or delete user");

        Stage stage = (Stage) manageUsersButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin/manage-users", stage);
        // Add your logic for managing users
    }

    // Event handler for the "Manage Roles" button
    @FXML
    private void handleManageRoles() {
        System.out.println("Manage Roles clicked");
        Stage stage = (Stage) manageRolesButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin/manageRoles-view.fxml", stage);
        // Add your logic for managing roles
    }

    // Event handler for the "Inventory Management" button
    @FXML
    private void handleInventoryManagement() {
        // Placeholder: Navigate to the Inventory Management screen
        Stage stage = (Stage) inventoryManagementButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin/manageInventory-view.fxml", stage);
        // Add your logic for managing roles
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Event handler for the "Settings" button
    @FXML
    private void handleSettings() {
        // Placeholder: Navigate to the Inventory Management screen
        System.out.println("System Settings clicked");
        showAlert("System Settings", "You can now manage system settings.");
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Event handler for the "Logout" button
    @FXML
    private void handleLogout() {
        AuthService.logoutUser();
        if (!AuthService.getAuthService().isUserAuthenticated())
            goToLogin();
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

    private void goToLogin() {
        Stage stage = (Stage) adminAnchorPane.getScene().getWindow();
        Navigation.navigateTo("login", stage);
    }
}
