// package org.example.fhrms.chef;

// // public class ChefInventoryController {

// // }

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import com.yourproject.models.InventoryItem;
// import com.yourproject.services.InventoryService;

// public class ChefInventoryController {

// @FXML
// private TableView<InventoryItem> inventoryTable;

// @FXML
// private TableColumn<InventoryItem, String> itemNameColumn;

// @FXML
// private TableColumn<InventoryItem, Integer> stockLevelColumn;

// @FXML
// private TableColumn<InventoryItem, Double> unitPriceColumn;

// @FXML
// // private TableColumn<InventoryItem, Button> actionColumn;

// private ObservableList<InventoryItem> inventoryItems;
// private InventoryService inventoryService;

// public ChefInventoryController() {
// this.inventoryService = new InventoryService(); // Service for business logic
// }

// @FXML
// public void initialize() {
// // Initialize table columns
// itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
// stockLevelColumn.setCellValueFactory(new
// PropertyValueFactory<>("stockLevel"));
// unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
// actionColumn.setCellValueFactory(new PropertyValueFactory<>("actionButton"));

// // Load data
// loadInventoryData();
// }

// private void loadInventoryData() {
// inventoryItems =
// FXCollections.observableArrayList(inventoryService.getAllItems());
// inventoryTable.setItems(inventoryItems);
// }

// @FXML
// private void handleAddItem() {
// // Logic to open a modal for adding a new item
// inventoryService.addItem(new InventoryItem("New Item", 50, 10.0));
// loadInventoryData();
// }

// @FXML
// private void handleUpdateStock() {
// // Logic to update stock levels
// inventoryService.updateStock(1, 100); // Example ID and stock
// loadInventoryData();
// }

// @FXML
// private void handleRemoveItem() {
// // Logic to remove an item
// inventoryService.removeItem(1); // Example ID
// loadInventoryData();
// }
// }
