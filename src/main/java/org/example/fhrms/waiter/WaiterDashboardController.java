package org.example.fhrms.waiter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.fhrms.service.AuthService;
import org.example.fhrms.uicontroller.route.Navigation;

public class WaiterDashboardController {

    @FXML
    private TableView<Order> pendingOrdersTable;

    @FXML
    private TableView<Order> completedOrdersTable;

    @FXML
    private TableColumn<Order, String> orderIdColumn;

    @FXML
    private AnchorPane waiterAnchorPane;
    @FXML
    private TableColumn<Order, String> customerNameColumn;

    @FXML
    private TableColumn<Order, String> itemsColumn;

    @FXML
    private TableColumn<Order, String> actionsColumn;

    @FXML
    private TableColumn<Order, String> completedOrderIdColumn;

    @FXML
    private TableColumn<Order, String> completedCustomerNameColumn;

    @FXML
    private TableColumn<Order, String> completedItemsColumn;

    @FXML
    private TableColumn<Order, String> servedTimeColumn;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        // Initialize columns for pending orders
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        itemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        actionsColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

        // Initialize columns for completed orders
        completedOrderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        completedCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        completedItemsColumn.setCellValueFactory(new PropertyValueFactory<>("items"));
        servedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("servedTime"));

        // Load data into tables
        loadPendingOrders();
        loadCompletedOrders();
    }

    private void loadPendingOrders() {
        // Replace with actual data retrieval logic
        pendingOrdersTable.getItems().addAll(
                new Order("101", "John Doe", "Burger, Fries", "Mark as Served"),
                new Order("102", "Jane Smith", "Pizza, Soda", "Mark as Served"));
    }

    private void loadCompletedOrders() {
        // Replace with actual data retrieval logic
        completedOrdersTable.getItems().addAll(
                new Order("201", "Alice Brown", "Pasta, Water", "12:30 PM"),
                new Order("202", "Bob White", "Steak, Wine", "1:00 PM"));
    }

    @FXML
    private void logout() {
        // Handle logout logic here
        System.out.println("Logging out...");
        AuthService.logoutUser();
        if(!AuthService.getAuthService().isUserAuthenticated()) goToLogin();
    }

    private void goToLogin() {
        Stage stage = (Stage) waiterAnchorPane.getScene().getWindow();
        Navigation.navigateTo("login",stage);
    }
    // Order class for table items
    public static class Order {
        private String orderId;
        private String customerName;
        private String items;
        private String action;

        public Order(String orderId, String customerName, String items, String action) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.items = items;
            this.action = action;
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

        public String getAction() {
            return action;
        }
    }
}
