package org.example.fhrms.model;

import javafx.beans.property.SimpleStringProperty;
import java.util.Map;

public class Order {
    private final String orderId;
    private final String customerName;
    private final String items; // Item name to quantity
    // private final String items;
    private final SimpleStringProperty cookedTime;
    private Integer price;

    // Constructor for Pending Orders
    public Order(String orderId, String customerName, String items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.cookedTime = new SimpleStringProperty("");
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Constructor for Completed Orders
    public Order(String orderId, String customerName, String items, String cookedTime) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.cookedTime = new SimpleStringProperty(cookedTime);
    }

    public String getOrderId() {
        return orderId;
    }

    public Integer getPrice(){
        return price;
    }
    public String getCustomerName() {
        return customerName;
    }

    public String getItems() {
        return items;
    }

    public String getCookedTime() {
        return cookedTime.get();
    }
}