/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * @author Ayat
 */

public class Meats extends FoodDrink {
    public static final Meats CHICKEN = new Meats("Chicken", 35.99, 1);
    public static final Meats LAMB = new Meats("Lamb", 37.99, 2);
    public static final Meats BEEF = new Meats("Beef", 36.99, 3);

    public Meats(String name, double price, int id) {
        super(name, price, id);
    }
}