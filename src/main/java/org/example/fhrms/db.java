package org.example.fhrms;

import javafx.util.Pair;
import org.example.fhrms.model.FoodItem;
import org.example.fhrms.model.Order;
import org.example.fhrms.model2.Role;
import org.example.fhrms.model2.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class db {
    private final HashMap<String, User> DB = new HashMap<String, User>();
    private final HashMap<String, FoodItem> FoodItemDB = new HashMap<>();
    private final HashMap<String, Order> OrderDB = new HashMap<>();
    private final HashMap<String, Order> CompletedOrderDB = new HashMap<>();
    private final Set<String> activeSessions = new HashSet<>(); // placeholder for session tracking.

    private static db data = new db();

    private db() {
        User user = new User(UUID.randomUUID().toString(), "test@user", "test@user", "test@user", Role.USER);
        User admin = new User(UUID.randomUUID().toString(), "test@admin", "test@admin", "test@admin", Role.ADMIN);
        User chef = new User(UUID.randomUUID().toString(), "test@chef", "test@chef", "test@chef", Role.CHEF);
        User waiter = new User(UUID.randomUUID().toString(), "test@waiter", "test@waiter", "test@waiter", Role.WAITER);

        DB.put(user.id(), user);
        DB.put(admin.id(), admin);
        DB.put(chef.id(), chef);
        DB.put(waiter.id(), waiter);
    }

    public static db getInstance() {
        if (data == null) {
            data = new db();
        }
        return data;
    }

    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        User newUser = new User(id, user.fullname(), user.username(), user.password(), user.userRole());
        DB.put(id, newUser);
        return newUser;
    }

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        for (User user : DB.values()) {
            if (user.username().equals(username) && user.password().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public HashMap<String, User> getDB() {
        return DB;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(DB.values());
    }

    // Order Management
    public void saveOrder(Order order) {
        OrderDB.put(order.getOrderId(), order);
    }

    public void moveToCompleted(Order order) {
        String orderId = order.getOrderId();
        OrderDB.remove(orderId);
        CompletedOrderDB.put(orderId, order);
    }

    public List<Order> getAllOrders() {
        return OrderDB.values().stream().toList();
    }

    public List<Order> getAllCompletedOrders() {
        return CompletedOrderDB.values().stream().toList();
    }

    public void removeOrder(String id) {
        OrderDB.remove(id);
    }

    // Food Item Management
    // public void saveFoodItem(FoodItem foodItem) {
    // FoodItemDB.put(foodItem.getId(), foodItem);
    // }

    public void updateFoodItem(String id, FoodItem updatedFoodItem) {
        FoodItemDB.put(id, updatedFoodItem);
    }

    public void deleteFoodItem(String id) {
        FoodItemDB.remove(id);
    }

    public List<FoodItem> getAllFoodItems() {
        return new ArrayList<>(FoodItemDB.values());
    }

    public Optional<FoodItem> getFoodItemsById(String id) {
        return Optional.ofNullable(FoodItemDB.get(id));
    }

    // Active Sessions Management (Dummy implementation)
    public void addActiveSession(String sessionId) {
        activeSessions.add(sessionId);
    }

    public void removeActiveSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }

    // Revenue Calculation
    // public double calculateTotalRevenue() {
    // return CompletedOrderDB.values().stream()
    // .mapToDouble(order ->
    // order.getFoodItemAndNumberContainer().getKey().getPrice()
    // * order.getFoodItemAndNumberContainer().getValue())
    // .sum();
    // }

}
