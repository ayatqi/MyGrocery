/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodDrink extends JPanel {

    private String name;
    private int id;
    private double price; 
    
    public FoodDrink(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
     
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    
    public FoodDrink() {
        setLayout(new GridLayout(2, 2)); // Set the layout to a 2x2 grid

        // Create components for Meats
        JPanel meatPanel = new JPanel();
        meatPanel.setBackground(new Color(249,235,234));
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS)); // Set vertical BoxLayout
        JLabel meatLabel = new JLabel("Meats"); // Create a JLabel for the title
        meatPanel.add(meatLabel); // Add the label to the meat panel
        
        // Add the Meat items
        addMeatItem(meatPanel, Meats.CHICKEN);
        addMeatItem(meatPanel, Meats.LAMB);
        addMeatItem(meatPanel, Meats.BEEF);

        // Set preferred size for the meat panel
        meatPanel.setPreferredSize(new Dimension(280, 250));

        // Add the category panel to the main panel
        add(meatPanel);
        
        

        // Create components for Fruits
        JPanel fruitPanel = new JPanel();
        fruitPanel.setBackground(new Color(254,245,231));
        fruitPanel.setLayout(new BoxLayout(fruitPanel, BoxLayout.Y_AXIS)); // Set vertical BoxLayout
        JLabel fruitLabel = new JLabel("Fruits"); // Create a JLabel for the title
        fruitPanel.add(fruitLabel); // Add the label to the fruit panel

        // Add the Fruit items
        addFruitItem(fruitPanel, Fruits.STRAWBERRY);
        addFruitItem(fruitPanel, Fruits.APPLE);
        addFruitItem(fruitPanel, Fruits.ORANGE);

        // Set preferred size for the Fruit panel
        fruitPanel.setPreferredSize(new Dimension(280, 250));

        // Add the category panel to the main panel
        add(fruitPanel);

        
        
        
        // Create components for Drinks
        JPanel drinkPanel = new JPanel();
        drinkPanel.setBackground(new Color(235,245,251));
        drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS)); // Set vertical BoxLayout
        JLabel drinkLabel = new JLabel("Drinks"); // Create a JLabel for the title
        drinkPanel.add(drinkLabel); // Add the label to the drink panel

        
        // Add the Drink items
        addDrinkItem(drinkPanel, Drinks.MILK);
        addDrinkItem(drinkPanel, Drinks.WATER);
        addDrinkItem(drinkPanel, Drinks.COLA);

        // Set preferred size for the Drinks panel
        drinkPanel.setPreferredSize(new Dimension(280, 250));

        // Add the category panel to the main panel
        add(drinkPanel);

        
        
        // Create components for Canned Food
        JPanel cannedPanel = new JPanel();
        cannedPanel.setBackground(new Color(248,249,249));
        cannedPanel.setLayout(new BoxLayout(cannedPanel, BoxLayout.Y_AXIS)); // Set vertical BoxLayout
        JLabel cannedLabel = new JLabel("Canned Food"); // Create a JLabel for the title
        cannedPanel.add(cannedLabel); // Add the label to the canned panel

        
        // Add the Canned Food items
        addCannedFoodItem(cannedPanel, CannedFood.PEAS);
        addCannedFoodItem(cannedPanel, CannedFood.REDBEANS);
        addCannedFoodItem(cannedPanel, CannedFood.WHIHTEBEANS);

        // Set preferred size for the  Canned Food panel
        cannedPanel.setPreferredSize(new Dimension(280, 250));

        // Add the category panel to the main panel
        add(cannedPanel);
                
        
    }
    
     private void addMeatItem(JPanel panel, Meats meat) {
        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(249,235,234));
        itemPanel.setPreferredSize(new Dimension(260, 30));

        JLabel nameLabel = new JLabel(meat.getName());
        JLabel priceLabel = new JLabel("Price: RM" + meat.getPrice());

        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
                // Add the meat item to the shopping cart or perform other actions
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
     
     private void addFruitItem(JPanel panel, Fruits fruits) {
        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(254,245,231));
        itemPanel.setPreferredSize(new Dimension(260, 30));

        JLabel nameLabel = new JLabel(fruits.getName());
        JLabel priceLabel = new JLabel("Price: RM" + fruits.getPrice());

        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
                // Add the meat item to the shopping cart or perform other actions
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
    
    private void addDrinkItem(JPanel panel, Drinks drinks) {
        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(235,245,251));
        itemPanel.setPreferredSize(new Dimension(260, 30));

        JLabel nameLabel = new JLabel(drinks.getName());
        JLabel priceLabel = new JLabel("Price: RM" + drinks.getPrice());

        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
                // Add the meat item to the shopping cart or perform other actions
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
    
    private void addCannedFoodItem(JPanel panel, CannedFood cannedFood) {
        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(248,249,249));
        itemPanel.setPreferredSize(new Dimension(260, 30));

        JLabel nameLabel = new JLabel(cannedFood.getName());
        JLabel priceLabel = new JLabel("Price: RM" + cannedFood.getPrice());

        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click event here
                // Add the meat item to the shopping cart or perform other actions
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }

}
