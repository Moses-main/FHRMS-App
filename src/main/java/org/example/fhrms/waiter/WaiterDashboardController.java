package org.example.fhrms.waiter;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WaiterDashboardController {

    // TableViews
    @FXML
    private TableView<Order> pendingOrdersTable;

    @FXML
    private TableView<Order> completedOrdersTable;

    // Table Columns for Pending Orders
    @FXML
    private TableColumn<Order, String> orderIdColumn;

    @FXML
    private TableColumn<Order, String> customerNameColumn;

    @FXML
    private TableColumn<Order, String> itemsColumn;

    @FXML
    private TableColumn<Order, Void> actionsColumn; // Void because it holds a Button, not text

    // Table Columns for Completed Orders
    @FXML
    private TableColumn<Order, String> completedOrderIdColumn;

    @FXML
    private TableColumn<Order, String> completedCustomerNameColumn;

    @FXML
    private TableColumn<Order, String> completedItemsColumn;

    @FXML
    private TableColumn<Order, String> servedTimeColumn;

    // Create Order Section Fields
    @FXML
    private TextField orderIdField;

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField itemsField;

    @FXML
    private Button createOrderButton;

    @FXML
    private AnchorPane waiterAnchorPane;

    // Logout Button
    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        // Initialize columns
        initializeTableColumns();

        // Load data
        loadPendingOrders();
        loadCompletedOrders();

        // Add action buttons dynamically
        addActionButtons();
    }

    private void initializeTableColumns() {
        // Pending Orders
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        itemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));

        // Completed Orders
        completedOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        completedCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        completedItemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        servedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("servedTime"));
    }

    private void loadPendingOrders() {
        // Dummy data
        pendingOrdersTable.getItems().addAll(
                new Order("101", "Alice", "Pizza, Coke"),
                new Order("102", "Bob", "Burger, Fries"));
    }

    private void loadCompletedOrders() {
        // Dummy data
        completedOrdersTable.getItems().addAll(
                new Order("201", "Charlie", "Pasta", "12:30 PM"),
                new Order("202", "David", "Steak, Wine", "1:00 PM"));
    }

    private void addActionButtons() {
        actionsColumn.setCellFactory(column -> new TableCell<>() {
            private final Button serveButton = new Button("Mark as Served");

            {
                serveButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-background-radius: 5; -fx-font-size: 12px;");
                serveButton.setOnAction(event -> {
                    // Get the selected order
                    Order order = getTableView().getItems().get(getIndex());

                    // Move the order to completedOrdersTable
                    moveOrderToCompleted(order);

                    // Remove the order from pendingOrdersTable
                    pendingOrdersTable.getItems().remove(order);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(serveButton);
                }
            }
        });
    }

    private void moveOrderToCompleted(Order order) {
        // Add order to completedOrdersTable with served time
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
        completedOrdersTable.getItems().add(
                new Order(order.getOrderId(), order.getCustomerName(), order.getItems(), currentTime)
        );
    }

    @FXML
    private void createOrder() {
        String orderId = orderIdField.getText();
        String customerName = customerNameField.getText();
        String items = itemsField.getText();

        if (orderId.isEmpty() || customerName.isEmpty() || items.isEmpty()) {
            showAlert("Validation Error", "Please fill all fields!", Alert.AlertType.ERROR);
            return;
        }

        // Add order to pending orders
        pendingOrdersTable.getItems().add(new Order(orderId, customerName, items));

        // Clear inputs
        orderIdField.clear();
        customerNameField.clear();
        itemsField.clear();

        showAlert("Success", "Order created successfully!", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void logout() {
        AuthService.logoutUser();
        Stage stage = (Stage) waiterAnchorPane.getScene().getWindow();
        Navigation.navigateTo("login", stage);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Order {
        private final String orderId;
        private final String customerName;
        private final String items;
        private final SimpleStringProperty servedTime;

        // Constructor for pending orders
        public Order(String orderId, String customerName, String items) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = items;
            this.servedTime = new SimpleStringProperty("");
        }

        // Constructor for completed orders
        public Order(String orderId, String customerName, String items, String servedTime) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = items;
            this.servedTime = new SimpleStringProperty(servedTime);
        }

        public String getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getItems() {
            return items;
        }

        public String getServedTime() {
            return servedTime.get();
        }
    }
}
