/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package com.mycompany.mygrocery;

/**
 *
 *  Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */

import javax.swing.*; 
import java.awt.*; 

 // declares the class name and extends JFrame
public class GroceryPanel extends JFrame{
    
    //declares a private instance variable of type Receipt
    private Receipt receipt; 
    //declares a private instance variable of type DiscountPanel
    private DiscountPanel discount; 
     //declares a private instance variable of type FoodPanel
    private FoodPanel foodPanel;

    
    //declares the constructor for the GroceryPanel class
    public GroceryPanel() { 
        
        // creates a new instance of the Receipt class and assigns it to the receipt variable
        receipt = new Receipt(); 
         // creates a new instance of the DiscountPanel class and passes in the receipt variable as an argument
        discount = new DiscountPanel(receipt);
        // creates a new instance of the FoodPanel class and passes in the receipt variable as an argument
        foodPanel = new FoodPanel(receipt); 
    }

    // declares the showGUI method
    public void showGUI() { 
        
         //  sets the title of the JFrame to "MyGrocery"
        setTitle("MyGrocery");
        
        //  sets the default close operation for the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        //  creates a new JPanel with a BorderLayout layout and assigns it to the receiptDiscount variable
        JPanel receiptDiscount = new JPanel(new BorderLayout()); 
        
        // adds the receipt panel to the center of the receiptDiscount panel
        receiptDiscount.add(receipt, BorderLayout.CENTER); 
        
        //  adds the discount panel to the north of the receiptDiscount panel
        receiptDiscount.add(discount, BorderLayout.NORTH); 

        //  creates a new JPanel with a GridLayout layout and assigns it to the mainPanel variable
        JPanel mainPanel = new JPanel(new GridLayout(1, 2)); 
        
        //  adds the food panel to mainPanel
        mainPanel.add(foodPanel);
         //  adds the receiptDiscount panel to mainPanel
        mainPanel.add(receiptDiscount);

        // adds mainPanel to the content pane of the JFrame
        getContentPane().add(mainPanel); 
        //sizes the JFrame so that all its contents are at or above their preferred sizes.
        pack(); 
        // makes this component visible.
        setVisible(true);  
      
    }
}
