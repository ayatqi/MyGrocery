/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 *  Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// declares the class name and extends JPanel
public class FoodPanel extends JPanel {
    
    // declares a private instance variable of type Receipt
    private Receipt receipt;

    // declares the constructor for the FoodPanel class and takes in a Receipt object as an argument
    public FoodPanel(Receipt receipt) {
        
        // assigns the receipt object passed in as an argument to the receipt instance variable
        this.receipt = receipt;
        
        // sets the layout of the panel to a 2x2 grid
        setLayout(new GridLayout(2, 2));

        
        // creates a new JPanel with the category "Meats" and a light pink color
        JPanel meatPanel = createCategoryPanel("Meats", new Color(249, 235, 234));
        // adds a chicken meat item to the meat panel
        MeatItem(meatPanel, Meats.CHICKEN);
        // adds a lamb meat item to the meat panel
        MeatItem(meatPanel, Meats.LAMB);
        // adds a beef meat item to the meat panel
        MeatItem(meatPanel, Meats.BEEF);
        // adds the meat panel to the main panel
        addCategoryPanel(meatPanel);

        // creates a new JPanel with the category "Fruits" and a light orange color
        JPanel fruitPanel = createCategoryPanel("Fruits", new Color(254, 245, 231));
        // adds a strawberry fruit item to the fruit panel
        FruitItem(fruitPanel, Fruits.STRAWBERRY);
        // adds a apple fruit item to the fruit panel
        FruitItem(fruitPanel, Fruits.APPLE);
        // adds a orange fruit item to the fruit panel
        FruitItem(fruitPanel, Fruits.ORANGE);
        // adds the fruit panel to the main panel
        addCategoryPanel(fruitPanel);

        // creates a new JPanel with the category "Drinks" and a light blue color
        JPanel drinkPanel = createCategoryPanel("Drinks", new Color(235, 245, 251));
        // adds a milk drink item to the drink panel
        DrinkItem(drinkPanel, Drinks.MILK);
        // adds a water drink item to the drink panel
        DrinkItem(drinkPanel, Drinks.WATER);
        // adds a coke drink item to the drink panel
        DrinkItem(drinkPanel, Drinks.COKE);
        // adds the drink panel to the main panel
        addCategoryPanel(drinkPanel);

        
         // creates a new JPanel with the category "Canned Food" and a light grey color
        JPanel cannedPanel = createCategoryPanel("Canned Food", new Color(248, 249, 249));
        // adds a peas canned food item to the canned food panel
        CannedFoodItem(cannedPanel, CannedFood.PEAS);
        // adds a red beans canned food item to the canned food panel
        CannedFoodItem(cannedPanel, CannedFood.REDBEANS);
        // adds a white beans canned food item to the canned food panel
        CannedFoodItem(cannedPanel, CannedFood.WHIHTEBEANS);
        // adds the canned food panel to the main panel
        addCategoryPanel(cannedPanel);
    }

    // This method creates a new JPanel with a specified category and color and returns it
    private JPanel createCategoryPanel(String category, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(category);
        panel.add(label);
        return panel;
    }

     // This method sets the preferred size of a given JPanel and adds it to this Food Panel.
    private void addCategoryPanel(JPanel panel) {
        panel.setPreferredSize(new Dimension(280, 250));
        add(panel);
    }

    // This method sets the color background of a given JPanel and return it to this Food Panel
    private JPanel createItemPanel(Color background) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    // This method takes in a JPanel and a Meats object as arguments
    private void MeatItem(JPanel panel, Meats meat) { 
        
        //  creates a new JPanel with the same background color as the given panel
        JPanel itemPanel = createItemPanel(panel.getBackground()); 
        // creates a new JLabel with the name of the meat item
        JLabel nameLabel = new JLabel(meat.getName()); 
        // creates a new JLabel with the price of the meat item
        JLabel priceLabel = new JLabel("Price: RM" + meat.getPrice()); 
        // adds the name label to the item panel
        itemPanel.add(nameLabel); 
        // adds the price label to the item panel
        itemPanel.add(priceLabel); 

        // creates a new JButton with a "+" symbol
        JButton addButton = new JButton("+"); 
        
        // adds an ActionListener to the add button that adds the meat item to the receipt when clicked
        addButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(meat);
            }
        });

        // creates a new JButton with a "-" symbol
        JButton removeButton = new JButton("-"); 
        
        //  adds an ActionListener to the remove button that removes the meat item from the receipt when clicked
        removeButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.removeItem(meat);
            }
        });

        //  sets the layout of the item panel to a FlowLayout
        itemPanel.setLayout(new FlowLayout()); 
        // adds the add button to the item panel
        itemPanel.add(addButton); 
        //  adds the remove button to the item panel
        itemPanel.add(removeButton); 

        // adds the item panel to the given panel
        panel.add(itemPanel); 
    }


    // This method takes in a JPanel and a Fruits object as arguments
    private void FruitItem(JPanel panel, Fruits fruits) {
        
        //  creates a new JPanel with the same background color as the given panel
        JPanel itemPanel = createItemPanel(panel.getBackground()); 
        // creates a new JLabel with the name of the fruits item
        JLabel nameLabel = new JLabel(fruits.getName()); 
        // creates a new JLabel with the price of the fruits item
        JLabel priceLabel = new JLabel("Price: RM" + fruits.getPrice()); 
        // adds the name label to the item panel
        itemPanel.add(nameLabel); 
        // adds the price label to the item panel
        itemPanel.add(priceLabel); 

        // creates a new JButton with a "+" symbol
        JButton addButton = new JButton("+"); 
        
        // adds an ActionListener to the add button that adds the fruits item to the receipt when clicked
        addButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(fruits);
            }
        });

        // creates a new JButton with a "-" symbol
        JButton removeButton = new JButton("-"); 
        
        //  adds an ActionListener to the remove button that removes the fruits item from the receipt when clicked
        removeButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.removeItem(fruits);
            }
        });

        //  sets the layout of the item panel to a FlowLayout
        itemPanel.setLayout(new FlowLayout()); 
        // adds the add button to the item panel
        itemPanel.add(addButton); 
        //  adds the remove button to the item panel
        itemPanel.add(removeButton); 

        // adds the item panel to the given panel
        panel.add(itemPanel); 
    }

    // This method takes in a JPanel and a Drinks object as arguments
    private void DrinkItem(JPanel panel, Drinks drinks) {
        
        //  creates a new JPanel with the same background color as the given panel
        JPanel itemPanel = createItemPanel(panel.getBackground()); 
        // creates a new JLabel with the name of the drinks item
        JLabel nameLabel = new JLabel(drinks.getName()); 
        // creates a new JLabel with the price of the drinks item
        JLabel priceLabel = new JLabel("Price: RM" + drinks.getPrice()); 
        // adds the name label to the item panel
        itemPanel.add(nameLabel); 
        // adds the price label to the item panel
        itemPanel.add(priceLabel); 

        // creates a new JButton with a "+" symbol
        JButton addButton = new JButton("+"); 
        
        // adds an ActionListener to the add button that adds the drinks item to the receipt when clicked
        addButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(drinks);
            }
        });

        // creates a new JButton with a "-" symbol
        JButton removeButton = new JButton("-"); 
        
        //  adds an ActionListener to the remove button that removes the drinks item from the receipt when clicked
        removeButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.removeItem(drinks);
            }
        });

        //  sets the layout of the item panel to a FlowLayout
        itemPanel.setLayout(new FlowLayout()); 
        // adds the add button to the item panel
        itemPanel.add(addButton); 
        //  adds the remove button to the item panel
        itemPanel.add(removeButton); 

        // adds the item panel to the given panel
        panel.add(itemPanel); 
    }

    // This method takes in a JPanel and a CannedFood object as arguments
    private void CannedFoodItem(JPanel panel, CannedFood cannedFood) {
        
        //  creates a new JPanel with the same background color as the given panel
        JPanel itemPanel = createItemPanel(panel.getBackground()); 
        // creates a new JLabel with the name of the canned food item
        JLabel nameLabel = new JLabel(cannedFood.getName()); 
        // creates a new JLabel with the price of the canned food item
        JLabel priceLabel = new JLabel("Price: RM" + cannedFood.getPrice()); 
        // adds the name label to the item panel
        itemPanel.add(nameLabel); 
        // adds the price label to the item panel
        itemPanel.add(priceLabel); 

        // creates a new JButton with a "+" symbol
        JButton addButton = new JButton("+"); 
        
        // adds an ActionListener to the add button that adds the canned food item to the receipt when clicked
        addButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.addItem(cannedFood);
            }
        });

        // creates a new JButton with a "-" symbol
        JButton removeButton = new JButton("-"); 
        
        //  adds an ActionListener to the remove button that removes the canned food item from the receipt when clicked
        removeButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.removeItem(cannedFood);
            }
        });

        //  sets the layout of the item panel to a FlowLayout
        itemPanel.setLayout(new FlowLayout()); 
        // adds the add button to the item panel
        itemPanel.add(addButton); 
        //  adds the remove button to the item panel
        itemPanel.add(removeButton); 

        // adds the item panel to the given panel
        panel.add(itemPanel); 
    }
}