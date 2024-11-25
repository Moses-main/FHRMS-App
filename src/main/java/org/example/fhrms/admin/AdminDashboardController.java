package org.example.fhrms.admin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.example.fhrms.db;
import org.example.fhrms.model.Order;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.util.List;

public class AdminDashboardController {

    @FXML
    private Label totalUsersLabel;

    @FXML
    private Label activeSessionsLabel;

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label pendingRequestsLabel;

    @FXML
    private Button analyticsButton;

    @FXML
    private Button manageUsersButton;

    @FXML
    private Button manageRolesButton;

    @FXML
    private Button inventoryManagementButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button GenerateReportsButton;

    @FXML
    private AnchorPane adminAnchorPane;

    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, String> orderIdColumn;

    @FXML
    private TableColumn<Order, String> foodItemColumn;

    @FXML
    private TableColumn<Order, Integer> quantityColumn;

    @FXML
    private TableColumn<Order, String> statusColumn;

    private void loadOrders() {
        List<Order> orders = database.getAllOrders();

        // Populate table columns
        orderIdColumn.setCellValueFactory(order -> new SimpleStringProperty(order.getValue().getId()));
        foodItemColumn.setCellValueFactory(
                order -> new SimpleStringProperty(order.getValue().getFoodItemAndNumberContainer().getKey().getName()));
        quantityColumn.setCellValueFactory(
                order -> new SimpleIntegerProperty(order.getValue().getFoodItemAndNumberContainer().getValue())
                        .asObject());
        statusColumn.setCellValueFactory(
                order -> new SimpleStringProperty(order.getValue().isCompleted() ? "Completed" : "Pending"));

        // Populate table data
        orderTableView.getItems().setAll(orders);
    }

    private final db database = db.getInstance();

    @FXML
    public void initialize() {
        loadDashboardData();
        loadOrders();
    }

    private void loadDashboardData() {
        // Fetch total users
        int totalUsers = database.getDB().size();
        totalUsersLabel.setText("Total Users: " + totalUsers);

        // Fetch active sessions (dummy implementation for now)
        int activeSessions = 25; // You could integrate session tracking logic here.
        activeSessionsLabel.setText("Active Sessions: " + activeSessions);

        // Fetch total revenue (assuming each order has a cost, calculate it)
        double totalRevenue = calculateTotalRevenue();
        totalRevenueLabel.setText("Total Revenue: $" + totalRevenue);

        // Fetch pending requests (orders not yet fulfilled)
        long pendingRequests = database.getAllOrders().stream().filter(order -> !order.isCompleted()).count();
        pendingRequestsLabel.setText("Pending Requests: " + pendingRequests);
    }

    private double calculateTotalRevenue() {
        List<Order> orders = database.getAllOrders();
        return orders.stream()
                .mapToDouble(order -> order.getFoodItemAndNumberContainer().getKey().getPrice()
                        * order.getFoodItemAndNumberContainer().getValue())
                .sum();
    }

    @FXML
    private void handleAnalytics() {
        Stage stage = (Stage) analyticsButton.getScene().getWindow();
        Navigation.navigateTo("admin/analytics", stage);
    }

    @FXML
    private void handleManageUsers() {
        Stage stage = (Stage) manageUsersButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-users", stage);
    }

    @FXML
    private void handleManageRoles() {
        Stage stage = (Stage) manageRolesButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-roles", stage);
    }

    @FXML
    private void handleInventoryManagement() {
        Stage stage = (Stage) inventoryManagementButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-inventory", stage);
    }

    @FXML
    private void handleSettings() {
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-settings", stage);
    }

    @FXML
    private void handleGenerateReport() {
        Stage stage = (Stage) GenerateReportsButton.getScene().getWindow();
        Navigation.navigateTo("admin/manage-reports", stage);
    }

    @FXML
    private void handleLogout() {
        AuthService.logoutUser();
        if (!AuthService.getAuthService().isUserAuthenticated()) {
            goToLogin();
        }
    }

    private void goToLogin() {
        Stage stage = (Stage) adminAnchorPane.getScene().getWindow();
        Navigation.navigateTo("login", stage);
    }
}
