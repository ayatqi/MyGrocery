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

public class GroceryPanel extends JFrame{
    private Receipt receipt;
    private DiscountPanel discount;
    private FoodPanel foodPanel;

    public GroceryPanel() {
        receipt = new Receipt();
        discount = new DiscountPanel(receipt);
        foodPanel = new FoodPanel(receipt);
    }

    public void showGUI() {
        setTitle("MyGrocery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel receiptDiscount = new JPanel(new BorderLayout());
        receiptDiscount.add(receipt, BorderLayout.CENTER);
        receiptDiscount.add(discount, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        
        mainPanel.add(foodPanel);
        mainPanel.add(receiptDiscount);

        getContentPane().add(mainPanel);
        pack();
        setVisible(true);
      
    }
}
