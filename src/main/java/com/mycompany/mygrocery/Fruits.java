/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
public class Fruits implements FoodItems  {
    
    private String name;
    private double price; 
    
    public static final Fruits STRAWBERRY = new Fruits("Strawberry", 25.99);
    public static final Fruits APPLE = new Fruits("Apple", 17.99);
    public static final Fruits ORANGE = new Fruits("Orange", 15.99);

    public Fruits(String name, double price) {
        
        this.name = name;
        this.price = price;
    }
    
    @Override 
    public String getName() {
        return name;
    }

    @Override  
    public double getPrice() {
        return price;
    }
}
