package org.example.fhrms.model;

import javafx.beans.property.SimpleStringProperty;
import java.util.Map;

public class Order {
    private final String orderId;
    private final String customerName;
    private final String items; // Item name to quantity
    // private final String items;
    private final SimpleStringProperty cookedTime;
    private final String itemPrice;

    // Constructor for Pending Orders
    public Order(String orderId, String customerName, String items, String itemPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.itemPrice = itemPrice;
        this.cookedTime = new SimpleStringProperty("");
    }

    // Constructor for Completed Orders
    public Order(String orderId, String customerName, String items, String cookedTime, String itemPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.itemPrice = itemPrice;
        this.items = items;
        this.cookedTime = new SimpleStringProperty(cookedTime);
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

    public String getPrice() {
        return itemPrice;
    }

    public String getCookedTime() {
        return cookedTime.get();
    }
}