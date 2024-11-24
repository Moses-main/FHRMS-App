package org.example.fhrms.model;

import org.example.fhrms.model.foods.FoodType;

import java.util.List;

public class Food {
    private int id;
    private String name;
    private String description;
    private String image;
    private double priceInDollars;
    private FoodType foodType;
    private static List FoodList=List.of(
            new Food(0," Plate of Rice","","",20),
            new Food(1," Chicken","","",20)
    );

    public Food(int id, String name, String description,String image, double priceInDollars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.priceInDollars = priceInDollars;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
