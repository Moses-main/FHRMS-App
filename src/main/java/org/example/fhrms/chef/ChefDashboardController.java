package org.example.fhrms.chef;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.db;
import org.example.fhrms.model.Inventory;
import org.example.fhrms.model.Order;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChefDashboardController {

    @FXML
    private TableView<Order> pendingOrdersTable;
    @FXML
    private TableView<Order> completedOrdersTable;
    @FXML
    private TableView<Inventory> inventoryTable;

    // Columns for Pending Orders
    @FXML
    private TableColumn<Order, String> orderIdColumn;
    @FXML
    private TableColumn<Order, String> customerNameColumn;
    @FXML
    private TableColumn<Order, String> itemsColumn;
    @FXML
    private TableColumn<Order, Void> actionsColumn;

    // Columns for Completed Orders
    @FXML
    private TableColumn<Order, String> completedOrderIdColumn;
    @FXML
    private TableColumn<Order, String> completedCustomerNameColumn;
    @FXML
    private TableColumn<Order, String> completedItemsColumn;
    @FXML
    private TableColumn<Order, String> cookedTimeColumn;

    // Columns for Inventory Management
    @FXML
    private TableColumn<Inventory, String> inventoryItemIdColumn;
    @FXML
    private TableColumn<Inventory, String> inventoryItemNameColumn;
    @FXML
    private TableColumn<Inventory, Integer> inventoryItemQuantityColumn;
    @FXML
    private TableColumn<Inventory, Double> inventoryItemPriceColumn;

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane chefAnchorPane;

    private final db database = db.getInstance();

    @FXML
    public void initialize() {
        // Initialize order columns
        initializeOrderColumns();

        // Initialize inventory columns
        initializeInventoryColumns();

        // Load initial data
        loadPendingOrders();
        loadCompletedOrders();
        // loadInventoryItems();

        // Add actions to the pending orders
        addActionButtons();
    }

    private void initializeOrderColumns() {
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        itemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));

        completedOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        completedCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        completedItemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        cookedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cookedTime"));
    }

    private void initializeInventoryColumns() {
        inventoryItemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        inventoryItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        inventoryItemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        inventoryItemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void loadPendingOrders() {
        pendingOrdersTable.getItems().addAll(database.getAllOrders());
    }

    private void loadCompletedOrders() {
        completedOrdersTable.getItems().addAll(database.getAllCompletedOrders());
    }

    // private void loadInventoryItems() {
    // inventoryTable.getItems().add(database.getAllFoodItems());
    // }

    private void addActionButtons() {
        actionsColumn.setCellFactory(column -> new TableCell<>() {
            private final Button markCookedButton = new Button("Mark as Cooked");

            {
                markCookedButton
                        .setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
                markCookedButton.setOnAction(event -> {
                    Order order = getTableView().getItems().get(getIndex());
                    markOrderAsCooked(order);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(markCookedButton);
                }
            }
        });
    }

    private void markOrderAsCooked(Order order) {
        String cookedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
        completedOrdersTable.getItems()
                .add(new Order(order.getOrderId(), order.getCustomerName(), order.getItems(),
                        cookedTime));
        pendingOrdersTable.getItems().remove(order);
        database.moveToCompleted(order);
    }

    @FXML
    private void handleAddItem() {
        System.out.println("Add Item button clicked");
        // Implement add item logic
    }

    @FXML
    private void handleUpdateItem() {
        System.out.println("Update Item button clicked");
        // Implement update item logic
    }

    @FXML
    private void handleDeleteItem() {
        Inventory selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            inventoryTable.getItems().remove(selectedItem);
            System.out.println("Deleted item: " + selectedItem.getName());
        } else {
            System.out.println("No item selected for deletion");
        }
    }

    @FXML
    private void logout() {
        AuthService.logoutUser();
        Stage stage = (Stage) chefAnchorPane.getScene().getWindow();
        Navigation.navigateTo("login", stage);
    }
}

//////////////////////////////////////////////////////////

// package org.example.fhrms.chef;

// import javafx.beans.property.SimpleStringProperty;
// import javafx.fxml.FXML;
// import javafx.scene.control.*;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
// import org.example.fhrms.db;
// import org.example.fhrms.model.Order;
// import org.example.fhrms.service.AuthService;
// import org.example.fhrms.uicontroller.route.Navigation;

// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;

// public class ChefDashboardController {

// @FXML
// private TableView<Order> pendingOrdersTable;
// @FXML
// private TableView<Order> completedOrdersTable;

// // Columns for Pending Orders
// @FXML
// private TableColumn<Order, String> orderIdColumn;
// @FXML
// private TableColumn<Order, String> customerNameColumn;
// @FXML
// private TableColumn<Order, String> itemsColumn;
// @FXML
// private TableColumn<Order, Void> actionsColumn;

// // Columns for Completed Orders
// @FXML
// private TableColumn<Order, String> completedOrderIdColumn;
// @FXML
// private TableColumn<Order, String> completedCustomerNameColumn;
// @FXML
// private TableColumn<Order, String> completedItemsColumn;
// @FXML
// private TableColumn<Order, String> cookedTimeColumn;

// // Logout Button
// @FXML
// private Button logoutButton;

// // AnchorPane for Navigation
// @FXML
// private AnchorPane chefAnchorPane;

// @FXML
// public void initialize() {
// // Initialize columns for pending orders
// orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
// customerNameColumn.setCellValueFactory(new
// PropertyValueFactory<>("customerName"));
// itemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));

// // Initialize columns for completed orders
// completedOrderIdColumn.setCellValueFactory(new
// PropertyValueFactory<>("orderId"));
// completedCustomerNameColumn.setCellValueFactory(new
// PropertyValueFactory<>("customerName"));
// completedItemsColumn.setCellValueFactory(new
// PropertyValueFactory<>("items"));
// cookedTimeColumn.setCellValueFactory(new
// PropertyValueFactory<>("cookedTime"));

// // Load initial data
// loadPendingOrders();
// loadCompletedOrders();

// // Add the "Mark as Cooked"
// addActionButtons();
// }

// private void loadPendingOrders() {
// pendingOrdersTable.getItems().addAll(
// db.getInstance().getAllOrders());
// }

// private void loadCompletedOrders() {
// completedOrdersTable.getItems().addAll(
// db.getInstance().getAllCompletedOrders());
// }

// private void addActionButtons() {
// actionsColumn.setCellFactory(column -> new TableCell<>() {
// private final Button markCookedButton = new Button("Mark as Cooked");

// {
// markCookedButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill:
// white; -fx-font-weight: bold;");
// markCookedButton.setOnAction(event -> {
// Order order = getTableView().getItems().get(getIndex());
// markOrderAsCooked(order);
// });
// }

// @Override
// protected void updateItem(Void item, boolean empty) {
// super.updateItem(item, empty);
// if (empty) {
// setGraphic(null);
// } else {
// setGraphic(markCookedButton);
// }
// }
// });
// }

// private void markOrderAsCooked(Order order) {
// // Add the order to completed orders with cooked time
// String cookedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm
// a"));
// completedOrdersTable.getItems().add(new Order(order.getOrderId(),
// order.getCustomerName(), order.getItems(), cookedTime));

// // Remove from pending orders
// pendingOrdersTable.getItems().remove(order);
// db.getInstance().moveToCompleted(order);
// }

// @FXML
// private void logout() {
// AuthService.logoutUser();
// Stage stage = (Stage) chefAnchorPane.getScene().getWindow();
// Navigation.navigateTo("login", stage);
// }

// }
