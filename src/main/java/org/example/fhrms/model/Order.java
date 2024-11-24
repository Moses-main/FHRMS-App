package org.example.fhrms.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Order {
    private String id;
    private static HashMap<String, Food> orders = new HashMap<>();
    private ArrayList<Pair<FoodItem,Integer>> FoodItemAndNumberContainer;

    public Order(String id, Pair<FoodItem,Integer>... FoodItemAndNumber) {
        this.id = id;
        this.FoodItemAndNumberContainer = new ArrayList<>();
        this.FoodItemAndNumberContainer.addAll(List.of(FoodItemAndNumber));
    }

    public String getId() {
        return id;
    }

    public void addToFoodItemAndNumberContainer(FoodItem foodItem, int number) {
        FoodItemAndNumberContainer.add(new Pair<>(foodItem,number));
    }
    public List<Pair<FoodItem,Integer>> getFoodItemAndNumberContainer() {
        return FoodItemAndNumberContainer;
    }

    public Long totalPrice(){
        return FoodItemAndNumberContainer.stream().mapToLong(item -> item.getValue().longValue()).sum();
    }
}
