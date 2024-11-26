package org.example.fhrms.admin;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

import org.example.fhrms.db;
import org.example.fhrms.model.Order;
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

    @FXML
    private Button analyticsButton;

    @FXML
    private Label totalUsersLabel;

    @FXML
    private Label activeSessionsLabel;

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label pendingRequestsLabel;

    @FXML
    private AnchorPane admiAnchorPane;

    private final db database = db.getInstance();

     @FXML
     public void initialize() {
     loadDashboardData();
     }

     private void loadDashboardData() {
     // fetch total users
     int totalUsers = database.getAllUsers().size();
     totalUsersLabel.setText("Total Users: " + totalUsers);

     // Fetch active sessions (this requires session tracking logic; using dummy
     // value here)
     int activeSessions = 10; // Placeholder value for active sessions
     activeSessionsLabel.setText("Active Sessions: " + activeSessions);

//     // Fetch total revenue
//     double totalRevenue = calculateTotalRevenue();
//     totalRevenueLabel.setText("Total Revenue: $" + totalRevenue);

     long pendingRequests = database.getAllOrders().size();
     pendingRequestsLabel.setText("Pending Requests: " + pendingRequests);
     }

    // private double calculateTotalRevenue() {
    // List<Order> completedOrders = database.getAllCompletedOrders();
    // return completedOrders.stream()
    // .mapToDouble(order ->
    // order.getFoodItemAndNumberContainer().getKey().getPrice()
    // * order.getFoodItemAndNumberContainer().getValue())
    // .sum();
    // }

    @FXML
    private void handleAnalytics() {
        Stage stage = (Stage) analyticsButton.getScene().getWindow();
        Navigation.navigateTo("admin/analytics", stage);
        // Add your logic for managing users
    }

    // Event handler for the "Manage Users" button
    @FXML
    private void handleManageUsers() {
        System.out.println("Manage Users clicked");
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
        Navigation.navigateTo("admin/manage-roles", stage);
        // Add your logic for managing roles
    }

    // Event handler for the "Inventory Management" button
    @FXML
    private void handleInventoryManagement() {
        Stage stage = (Stage) inventoryManagementButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-inventory", stage);
        // Add your logic for managing roles
        // Integrate with your Inventory Management system (e.g., Square API) here.
    }

    // Event handler for the "Settings" button
    @FXML
    private void handleSettings() {
        System.out.println("System Settings clicked");
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin/manage-settings", stage);
        // Add your logic for managing roles
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
        Stage stage = (Stage) GenerateReportsButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-reports", stage);
        // Add your logic for managing roles
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
