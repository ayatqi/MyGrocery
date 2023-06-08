/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
public class Drinks extends FoodDrink {
    public static final Drinks MILK = new Drinks("Milk", 15.99);
    public static final Drinks WATER = new Drinks("Water", 1.50);
    public static final Drinks COLA = new Drinks("Cola", 3.50);

    public Drinks(String name, double price) {
        super(name, price);
    }
}
