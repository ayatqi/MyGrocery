/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */

public class FoodDrink{

    private String name;
    private int id;
    private double price; 
    
    
    public FoodDrink(String name, double price) {
        this.name = name;
        this.price = price;
    }
     
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
