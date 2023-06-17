/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 *  Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */

// declares a new class called CannedFood that implements the FoodItems interface
public class CannedFood implements FoodItems {
    
    // declares a private String variable called name
    private String name; 
    // declares a private double variable called price
    private double price; 
     
    // declares a public static final variable called PEAS of type CannedFood 
    public static final CannedFood PEAS = new CannedFood("Peas", 5.99); 
    // declares a public static final variable called REDBEANS  of type CannedFood 
    public static final CannedFood REDBEANS = new CannedFood("Red Beans", 6.90); 
    // declares a public static final variable called WHIHTEBEANS of type CannedFood 
    public static final CannedFood WHIHTEBEANS = new CannedFood("White Beans", 8.80);

    
   // declares a constructor for the CannedFood class that takes two parameters: a String called name and a double called price
    public CannedFood(String name, double price) {
       
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
