package org.example.fhrms;

import javafx.util.Pair;
import org.example.fhrms.model.FoodItem;
import org.example.fhrms.model.Order;
import org.example.fhrms.model2.Role;
import org.example.fhrms.model2.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class db {
    private final HashMap<String, User> DB=new HashMap<String,User>();
    private final HashMap<String, FoodItem> FoodItemDB=new HashMap<>();
    private final HashMap<String, Order> OrderDB=new HashMap<>();

    private static db data=new db();

    private db() {
        User user=new User(UUID.randomUUID().toString(),"test@user","test@user","test@user", Role.USER);
        User admin=new User(UUID.randomUUID().toString(),"test@admin","test@admin","test@admin", Role.ADMIN);
        User chef=new User(UUID.randomUUID().toString(),"test@chef","test@chef","test@chef", Role.CHEF);
        User waiter=new User(UUID.randomUUID().toString(),"test@waiter","test@waiter","test@waiter", Role.WAITER);

        DB.put(user.id(),user);
        DB.put(admin.id(),admin);
        DB.put(chef.id(),chef);
        DB.put(waiter.id(),waiter);
    }
    public static db getInstance() {
        if(data==null){
            data=new db();
        }
        return data;
    }

    public User saveUser(User user) {
        String id= UUID.randomUUID().toString();
        User newUser=new User(id,user.fullname(),user.username(),user.password(),user.userRole());
        DB.put(id,newUser);
        return newUser;
    }

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        for(User user:DB.values()) {
            if(user.username().equals(username) && user.password().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean saveOrder(Order order) {
        String id= UUID.randomUUID().toString();
        Order savedOrder=new Order(
          order.getId(),
                (Pair<FoodItem, Integer>) order.getFoodItemAndNumberContainer()
        );
        OrderDB.put(id,savedOrder);
        return true;
    }

    public List<Order> getAllOrders() {
        return OrderDB.values().stream().toList();
    }

    public void removeOrder(String id) {
        OrderDB.remove(id);
    }
}
