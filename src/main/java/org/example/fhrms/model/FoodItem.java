package org.example.fhrms.model;

import javafx.beans.property.*;

public class FoodItem {
    private final StringProperty foodName;
    private final DoubleProperty price;
    private final IntegerProperty quantity;

    public FoodItem(String foodName, double price, int quantity) {
        this.foodName = new SimpleStringProperty(foodName);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public String getFoodName() {
        return foodName.get();
    }

    public StringProperty foodNameProperty() {
        return foodName;
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }
}
