package org.example.fhrms.waiter;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.fhrms.db;
import org.example.fhrms.model.Order;
import org.example.fhrms.model.FoodItem;

import java.util.List;
import java.util.Map;

public class ReceiptController {

        @FXML
        private TableView<Order> completedOrdersTable;

        @FXML
        private TableColumn<Order, String> orderIdColumn;

        @FXML
        private TableColumn<Order, String> customerNameColumn;

        @FXML
        private TableColumn<Order, String> cookedTimeColumn;

        @FXML
        private TextArea receiptTextArea;

        private final db database = db.getInstance();

        @FXML
        public void initialize() {
                orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
                customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
                cookedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cookedTime"));

                loadCompletedOrders();
        }

        private void loadCompletedOrders() {
                List<Order> completedOrders = database.getAllCompletedOrders();
                completedOrdersTable.getItems().setAll(completedOrders);
        }

        @FXML
        private void handleGenerateReceipt() {
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
                receiptBuilder.append("Items:\n");

                double total = 10.0;
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
                receiptBuilder.append("Total: $").append(total).append("\n");
                receiptBuilder.append("================================================\n");

                receiptTextArea.setText(receiptBuilder.toString());
        }

        private void showAlert(String title, String content, Alert.AlertType alertType) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setContentText(content);
                alert.showAndWait();
        }
}
