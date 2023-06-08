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


import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private Receipt receipt;
    private FoodPanel foodPanel;

    public MainPanel() {
        setLayout(new GridLayout(1, 2));

        JPanel receiptDiscount = new JPanel(new BorderLayout());

        receipt = new Receipt();
        receiptDiscount.add(receipt, BorderLayout.CENTER);

        // Create and add the discount panel to the top of the receiptDiscount panel
        DiscountPanel discount = new DiscountPanel();
        receiptDiscount.add(discount, BorderLayout.NORTH);

        foodPanel = new FoodPanel(receipt);

        add(foodPanel);
        add(receiptDiscount);
    }

}
