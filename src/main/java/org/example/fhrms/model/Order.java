package org.example.fhrms.model;

import javafx.beans.property.SimpleStringProperty;
import java.util.Map;

public class Order {
    private final String orderId;
    private final String customerName;
    private final Map<String, Integer> items; // Item name to quantiy
    // private final String items;
    private final SimpleStringProperty cookedTime;

    // Constructor for Pending Orders
    public Order(String orderId, String customerName, Map<String, Integer> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.cookedTime = new SimpleStringProperty("");
    }

    // Constructor for Completed Orders
    public Order(String orderId, String customerName, Map<String, Integer> items, String cookedTime) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.cookedTime = new SimpleStringProperty(cookedTime);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public String getCookedTime() {
        return cookedTime.get();
    }
}