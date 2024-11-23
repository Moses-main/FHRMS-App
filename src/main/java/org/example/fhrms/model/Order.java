package org.example.fhrms.model;

import javafx.util.Pair;

public class Order {
    private String id;
    private Pair<FoodItem,Integer> FoodItemAndNumber;

    public Order(String id, Pair<FoodItem,Integer> FoodItemAndNumber) {
        this.id = id;
        this.FoodItemAndNumber = FoodItemAndNumber;
    }

    public String getId() {
        return id;
    }
    public Pair<FoodItem,Integer> getFoodItemAndNumber() {
        return FoodItemAndNumber;
    }
}
