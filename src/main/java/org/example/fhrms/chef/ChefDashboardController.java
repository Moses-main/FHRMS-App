package org.example.fhrms.chef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ChefDashboardController {

    @FXML
    private ListView<String> ordersList; // This will display pending orders

    @FXML
    private Button markInProgressButton;

    @FXML
    private Button markCompletedButton;

    @FXML
    private Button checkInventoryButton;

    @FXML
    private Button logoutButton;

    // This method is called when the chef clicks on "Mark as In Progress"
    @FXML
    private void markInProgress(ActionEvent event) {
        String selectedOrder = ordersList.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            showAlert("Order Updated", "Order " + selectedOrder + " is now in progress.");
            ordersList.getItems().remove(selectedOrder);
        } else {
            showAlert("Error", "Please select an order to mark as in progress.");
        }
    }

    // This method is called when the chef clicks on "Mark as Completed"
    @FXML
    private void markCompleted(ActionEvent event) {
        String selectedOrder = ordersList.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            showAlert("Order Completed", "Order " + selectedOrder + " is now completed.");
            ordersList.getItems().remove(selectedOrder);
        } else {
            showAlert("Error", "Please select an order to mark as completed.");
        }
    }

    // This method is called when the chef clicks on "Check Inventory"
    @FXML
    private void checkInventory(ActionEvent event) {
        // Placeholder functionality for checking inventory
        showAlert("Inventory", "Inventory check triggered. Implement API call here.");
    }

    // This method is called when the chef clicks on "Logout"
    @FXML
    private void logout(ActionEvent event) {
        // Placeholder functionality for logging out
        showAlert("Logout", "Logging out of the system.");
        // Implement actual logout logic (e.g., redirect to the login screen)
    }

    // Utility method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
