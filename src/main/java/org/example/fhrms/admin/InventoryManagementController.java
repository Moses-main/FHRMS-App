package org.example.fhrms.admin;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.example.fhrms.model.Inventory;

public class InventoryManagementController {

    @FXML
    private Button backButton;

    @FXML
    private Button createItemButton;

    @FXML
    private TableView<?> inventoryTable;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    public void handleAddItem(ActionEvent event) {
        // Logic to add an item
    }

    public void handleEditItem(ActionEvent event) {
        // Logic to edit an item
    }

    public void handleDeleteItem(ActionEvent event) {
        // Logic to delete an item
    }

    @FXML
    private void handleBackToDashboard() {
        // Navigate back to the admin dashboard
        System.out.println("Back to Dashboard clicked");

        Stage stage = (Stage) backButton.getScene().getWindow();
        // Navigation.navigateTo("admin/admin-dashboard.fxml", stage);
        Navigation.navigateTo("admin", stage);
        // Add your logic for managing users
    }

    @FXML
    private void createItem() {
        // Add logic to create new item
        System.out.println("New item create");
    }
}
