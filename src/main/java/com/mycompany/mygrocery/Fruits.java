/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 *  Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */


// declares a new class called Fruits that implements the FoodItems interface
public class Fruits implements FoodItems  {
    
    // declares a private String variable called name
    private String name; 
    // declares a private double variable called price
    private double price; 
    
    // declares a public static final variable called STRAWBERRY of type Fruits 
    public static final Fruits STRAWBERRY = new Fruits("Strawberry", 25.99);
    // declares a public static final variable called APPLE of type Fruits 
    public static final Fruits APPLE = new Fruits("Apple", 17.99);
    // declares a public static final variable called ORANGE of type Fruits 
    public static final Fruits ORANGE = new Fruits("Orange", 15.99);

   // declares a constructor for the Fruits class that takes two parameters: a String called name and a double called price
    public Fruits(String name, double price) {
        
        // assigns the value of the name parameter to the name variable
        this.name = name; 
         // assigns the value of the price parameter to the price variable
        this.price = price;
    }
    
    // overrides the getName() method from the FoodItems interface
    @Override 
    public String getName() { 
        
        // returns the value of the name variable
        return name; 
    }

    //  overrides the getPrice() method from the FoodItems interface
    @Override 
    public double getPrice() { 
        
        // returns the value of the price variable
        return price; 
    }
}
