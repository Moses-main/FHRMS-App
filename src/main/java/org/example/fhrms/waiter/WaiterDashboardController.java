package org.example.fhrms.waiter;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.db;
import org.example.fhrms.model.Order;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class WaiterDashboardController {

    @FXML
    private Label infoMessageLabel;

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
    private TableColumn<Order, String> priceColumn;

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
    private TextField priceField;

    @FXML
    private Button createOrderButton;

    @FXML
    private AnchorPane waiterAnchorPane;

    // Logout Button
    @FXML
    private Button logoutButton;

    @FXML
    private TextArea receiptTextArea;

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
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));

        // Completed Orders
        completedOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        completedCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        completedItemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        servedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("servedTime"));
    }

    private void loadPendingOrders() {
        // Dummy data
        pendingOrdersTable.getItems().addAll(
                db.getInstance().getAllOrders());
    }

    private void loadCompletedOrders() {
        // Dummy data
        completedOrdersTable.getItems().addAll(
                db.getInstance().getAllCompletedOrders());
    }

    private void addActionButtons() {
        actionsColumn.setCellFactory(column -> new TableCell<>() {
            private final Button serveButton = new Button("Mark as Served");
            {
                serveButton.setStyle(
                        "-fx-background-color: #27ae60; -fx-text-fill: white; -fx-background-radius: 5; -fx-font-size: 12px;");
                serveButton.setOnAction(event -> {
                    // Get the selected order
                    Order order = getTableView().getItems().get(getIndex());

                    // Move the order to completedOrdersTable
                    moveOrderToCompleted(order);
                    // Remove the order from pendingOrdersTable
                    pendingOrdersTable.getItems().remove(order);
                    db.getInstance().moveToCompleted(order);
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
                new Order(order.getOrderId(), order.getCustomerName(), order.getItems(), order.getPrice(),
                        currentTime));
    }

    @FXML
    private void createOrder() {
        String orderId = orderIdField.getText();
        String customerName = customerNameField.getText();
        String items = itemsField.getText();
        String itemPrice = priceField.getText();

        if (orderId.isEmpty() || customerName.isEmpty() || itemPrice.isEmpty() || items.isEmpty()
                || itemPrice.isEmpty()) {
            infoMessageLabel.setText("Please fill all fields!");

            return;
        }

        Order order = new Order(orderId, customerName, items, itemPrice);
        // Add order to pending orders
        pendingOrdersTable.getItems().add(order);

        // Clear inputs
        orderIdField.clear();
        customerNameField.clear();
        itemsField.clear();
        priceField.clear();
        db.getInstance().saveOrder(order);
        infoMessageLabel.setText("Order created successfully!");
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

    @FXML
    public void handleGenerateReceipt(ActionEvent actionEvent) {

        System.out.println("Generate Reciept Button Clicked");

        Order selectedOrder = completedOrdersTable.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            showAlert("No Order Selected", "Please select a completed order to generate a receipt.",
                    Alert.AlertType.WARNING);
            return;
        }

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("============ Food Heaven Restaurant ============\n");
        receiptBuilder.append("Order ID: ").append(selectedOrder.getOrderId()).append("\n");
        receiptBuilder.append("Customer Name: ").append(selectedOrder.getCustomerName()).append("\n");
        receiptBuilder.append("Cooked Time: ").append(selectedOrder.getCookedTime()).append("\n");
        receiptBuilder.append("------------------------------------------------\n");
        receiptBuilder.append("Items: ").append(selectedOrder.getItems()).append("\n");

        // double total = selectedOrder.getPrice();
        // for (Map.Entry<String, Integer> item : selectedOrder.getItems()) {
        // String itemName = item.getKey();
        // int quantity = item.getValue();
        // FoodItem foodItem = database.getFoodItemsById(itemName).orElse(null);
        // double price = foodItem != null ? foodItem.getPrice() : 0.0;

        // receiptBuilder.append(itemName).append(" (").append(quantity).append(" x
        // $").append(price).append(")\n");
        // total += price * quantity;
        // }

        receiptBuilder.append("------------------------------------------------\n");
        receiptBuilder.append("Total: $").append(selectedOrder.getPrice()).append("\n");
        receiptBuilder.append("================================================\n");

        receiptTextArea.setText(receiptBuilder.toString());
    }

    @FXML
    public void handlePrintReceipt(ActionEvent actionEvent) {

        System.out.println("Print reciept Button clicked");
    }
}
