package org.example.fhrms.admin;

import org.example.fhrms.uicontroller.route.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.example.fhrms.db;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import org.example.fhrms.model.Inventory;

public class InventoryManagementController {

    @FXML
    private Button backButton;

    @FXML
    private Button createItemButton;

    @FXML
    private TableView<Inventory> inventoryTable;

    @FXML
    private TableColumn<Inventory, String> itemNameColumn;

    @FXML
    private TableColumn<Inventory, String> itemIdColumn;

    @FXML
    private TableColumn<Inventory, Integer> itemQuantityColumn;

    @FXML
    private TableColumn<Inventory, Double> itemPriceColumn;

    private final db database = db.getInstance();

    // public void handleAddItem(ActionEvent event) {
    // // Logic to add an item
    // }

    // public void handleEditItem(ActionEvent event) {
    // // Logic to edit an item
    // }

    // public void handleDeleteItem(ActionEvent event) {
    // // Logic to delete an item
    // }

    @FXML
    public void initialize() {
        // Initialize columns
        itemIdColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        itemNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        itemQuantityColumn
                .setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        itemPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()).asObject());

        // Load data
        loadInventoryItems();
    }

    private void loadInventoryItems() {
        ObservableList<Inventory> items = FXCollections.observableArrayList(database.getAllInventory());
        inventoryTable.setItems(items);
    }

    @FXML
    private void handleAddItem() {
        Inventory newItem = new Inventory("4", "New Item", 30, 3.0); // Example data
        database.addInventory(newItem);
        loadInventoryItems();
    }

    @FXML
    private void handleUpdateItem() {
        Inventory selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.setQuantity(100); // Example update
            database.updateInventory(selectedItem);
            loadInventoryItems();
        } else {
            showAlert("No Selection", "Please select an item to update.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleDeleteItem() {
        Inventory selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            database.deleteInventory(selectedItem.getId());
            loadInventoryItems();
        } else {
            showAlert("No Selection", "Please select an item to delete.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
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
