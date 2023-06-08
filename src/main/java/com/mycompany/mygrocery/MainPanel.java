/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;


/**
 *
 * @author Ayat
 */
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        setLayout(new GridLayout(1, 2));

        // Food Panel
        FoodDrink foodDrinkPanel = new FoodDrink();
        add(foodDrinkPanel);

        
        // Receipt Panel
        
     
    }
}

