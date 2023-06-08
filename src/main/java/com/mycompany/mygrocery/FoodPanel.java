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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodPanel extends JPanel {

    private Receipt receipt;

    
    public FoodPanel(Receipt receipt) {
        this.receipt = receipt;
        setLayout(new GridLayout(2, 2)); // Set the layout to a 2x2 grid

        JPanel meatPanel = createCategoryPanel("Meats", new Color(249, 235, 234));
        addMeatItem(meatPanel, Meats.CHICKEN);
        addMeatItem(meatPanel, Meats.LAMB);
        addMeatItem(meatPanel, Meats.BEEF);
        addCategoryPanel(meatPanel);

        JPanel fruitPanel = createCategoryPanel("Fruits", new Color(254, 245, 231));
        addFruitItem(fruitPanel, Fruits.STRAWBERRY);
        addFruitItem(fruitPanel, Fruits.APPLE);
        addFruitItem(fruitPanel, Fruits.ORANGE);
        addCategoryPanel(fruitPanel);

        JPanel drinkPanel = createCategoryPanel("Drinks", new Color(235, 245, 251));
        addDrinkItem(drinkPanel, Drinks.MILK);
        addDrinkItem(drinkPanel, Drinks.WATER);
        addDrinkItem(drinkPanel, Drinks.COLA);
        addCategoryPanel(drinkPanel);

        JPanel cannedPanel = createCategoryPanel("Canned Food", new Color(248, 249, 249));
        addCannedFoodItem(cannedPanel, CannedFood.PEAS);
        addCannedFoodItem(cannedPanel, CannedFood.REDBEANS);
        addCannedFoodItem(cannedPanel, CannedFood.WHIHTEBEANS);
        addCategoryPanel(cannedPanel);
                
        
    }
    
    private JPanel createCategoryPanel(String category, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(category);
        panel.add(label);
        return panel;
    }

    private void addCategoryPanel(JPanel panel) {
        panel.setPreferredSize(new Dimension(280, 250));
        add(panel);
    }

    private JPanel createItemPanel(Color background) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }
    
    private void addMeatItem(JPanel panel, Meats meat) {
        JPanel itemPanel = createItemPanel(panel.getBackground());
        JLabel nameLabel = new JLabel(meat.getName());
        JLabel priceLabel = new JLabel("Price: RM" + meat.getPrice());
        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(meat);
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
     
     private void addFruitItem(JPanel panel, Fruits fruits) {
        JPanel itemPanel = createItemPanel(panel.getBackground());
        JLabel nameLabel = new JLabel(fruits.getName());
        JLabel priceLabel = new JLabel("Price: RM" + fruits.getPrice());
        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(fruits);
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
    
    private void addDrinkItem(JPanel panel, Drinks drinks) {
       JPanel itemPanel = createItemPanel(panel.getBackground());
        JLabel nameLabel = new JLabel(drinks.getName());
        JLabel priceLabel = new JLabel("Price: RM" + drinks.getPrice());
        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(drinks);
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }
    
    private void addCannedFoodItem(JPanel panel, CannedFood cannedFood) {
       JPanel itemPanel = createItemPanel(panel.getBackground());
        JLabel nameLabel = new JLabel(cannedFood.getName());
        JLabel priceLabel = new JLabel("Price: RM" + cannedFood.getPrice());
        itemPanel.add(nameLabel);
        itemPanel.add(priceLabel);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(cannedFood);
            }
        });
        itemPanel.add(addButton);

        panel.add(itemPanel);
    }

}
