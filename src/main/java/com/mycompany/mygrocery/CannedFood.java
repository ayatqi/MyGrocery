/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 *Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
public class CannedFood extends FoodDrink {
    
    public static final CannedFood PEAS = new CannedFood("Peas", 5.99);
    public static final CannedFood REDBEANS = new CannedFood("Red Beans", 6.90);
    public static final CannedFood WHIHTEBEANS = new CannedFood("White Beans", 8.80);

    public CannedFood(String name, double price) {
        super(name, price);
    }
}
