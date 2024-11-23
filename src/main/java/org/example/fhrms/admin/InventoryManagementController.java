package org.example.fhrms.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InventoryManagementController {

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
}
