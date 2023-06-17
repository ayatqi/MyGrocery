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
import java.util.ArrayList;
import java.util.List;

//  declares a new class called Receipt that extends JPanel
public class Receipt extends JPanel {
    
    //  declares a private variable called receiptModel of type DefaultListModel<String>
    private DefaultListModel<String> receiptModel; 
    // declares a private variable called receiptList of type JList<String>
    private JList<String> receiptList; 
    //  declares a private variable called scrollPane of type JScrollPane
    private JScrollPane scrollPane; 
    // declares a private variable called totalLabel of type JLabel
    private JLabel totalLabel; 
    // declares a private variable called discountTotalLabel of type JLabel
    private JLabel discountTotalLabel; 
    //  declares a private variable called afterDiscountTotalLabel of type JLabel
    private JLabel afterDiscountTotalLabel; 
    //  declares a private boolean variable called discountApplied
    private boolean discountApplied; 
    // declares a private double variable called discountPercentage
    private double discountPercentage; 
    //  declares a private List variable called items of type FoodItems
    private List<FoodItems> items; 

    // declares a constructor for the Receipt class
    public Receipt() {
        
        // initializes the receiptModel variable with a new instance of DefaultListModel<>
        receiptModel = new DefaultListModel<>(); 
        //  initializes the receiptList variable with a new instance of JList<> and passes in the receiptModel as an argument
        receiptList = new JList<>(receiptModel); 
        //  initializes the scrollPane variable with a new instance of JScrollPane and passes in the receiptList as an argument
        scrollPane = new JScrollPane(receiptList); 
        //  initializes the totalLabel variable with a new instance of JLabel and sets its text to "Total: RM0.00"
        totalLabel = new JLabel("Total: RM0.00"); 
        //  initializes the discountTotalLabel variable with a new instance of JLabel and sets its text to "Discount Total: RM0.00"
        discountTotalLabel = new JLabel("Discount Total: RM0.00"); 
        //  initializes the afterDiscountTotalLabel variable with a new instance of JLabel and sets its text to "After Discount Total: RM0.00"
        afterDiscountTotalLabel = new JLabel("After Discount Total: RM0.00"); 
        //  initializes the discountApplied variable to false
        discountApplied = false; 
        //  initializes the discountPercentage variable to 0
        discountPercentage = 0; 
        //  initializes the items variable with a new instance of ArrayList<>
        items = new ArrayList<>(); 

        //  sets the layout manager for this panel to BorderLayout
        setLayout(new BorderLayout()); 
        //  adds the scrollPane to this panel at the center position
        add(scrollPane, BorderLayout.CENTER); 
        // creates a new JPanel called totalPanel
        JPanel totalPanel = new JPanel(); 
        // sets the layout manager for totalPanel to GridLayout with 3 rows and 1 column
        totalPanel.setLayout(new GridLayout(3, 1)); 
        // adds the totalLabel to totalPanel
        totalPanel.add(totalLabel); 
        // adds the discountTotalLabel to totalPanel
        totalPanel.add(discountTotalLabel); 
        //  adds the afterDiscountTotalLabel to totalPanel
        totalPanel.add(afterDiscountTotalLabel); 
        //  adds totalPanel to this panel at the south position
        add(totalPanel, BorderLayout.SOUTH); 
    }

    // declares a public method called addItem that takes an argument of type FoodItems
    public void addItem(FoodItems item) {
            
        // creates a String called itemString that concatenates the name and price of the item passed in as an argument
        String itemString = item.getName() + " - RM" + item.getPrice(); 
        // adds itemString to receiptModel using its addElement() method
        receiptModel.addElement(itemString); 
        //  adds the item passed in as an argument to items using its add() method
        items.add(item); 
        // calls the updateTotals() method to update all totals on this panel
        updateTotals(); 
    }
    
    // declares a public method called removeItem that takes an argument of type FoodItems
    public void removeItem(FoodItems item) { 
        
        // creates a String called itemString that concatenates the name and price of the item passed in as an argument
        String itemString = item.getName() + " - RM" + item.getPrice(); 
        // removes the itemString from receiptModel using its removeElement() method
        receiptModel.removeElement(itemString); 
        // removes the item passed in as an argument from items using its remove() method
        items.remove(item); 
        // calls the updateTotals() method to update all totals on this panel
        updateTotals(); 
    }
    
    // declares a public method called getReceiptModel that returns a DefaultListModel<String>
    public DefaultListModel<String> getReceiptModel() {
        
        // returns receiptModel
        return receiptModel; 
    }
    
    // declares a private method called updateTotals that returns void
    private void updateTotals() { 
        
        // declares and initializes a double variable called total with the result of calling the calculateTotal() method
        double total = calculateTotal(); 
        // declares and initializes a double variable called discountTotal with the result of calling the calculateDiscountTotal() method and passing in total as an argument
        double discountTotal = calculateDiscountTotal(total); 
        // declares and initializes a double variable called afterDiscountTotal by subtracting discountTotal from total
        double afterDiscountTotal = total - discountTotal; 
        // sets the text of totalLabel to "Total: RM" concatenated with the formatted value of total with 2 decimal places
        totalLabel.setText("Total: RM" + String.format("%.2f", total)); 
        // sets the text of discountTotalLabel to "Discount Total: RM" concatenated with the formatted value of discountTotal with 2 decimal places
        discountTotalLabel.setText("Discount Total: RM" + String.format("%.2f", discountTotal)); 
        // sets the text of afterDiscountTotalLabel to "After Discount Total: RM" concatenated with the formatted value of afterDiscountTotal with 2 decimal places
        afterDiscountTotalLabel.setText("After Discount Total: RM" + String.format("%.2f", afterDiscountTotal)); 
    }

    // declares a private method called calculateTotal that returns a double
    private double calculateTotal() { 
        // declares and initializes a double variable called total to 0
        double total = 0;
        
        // starts a for-each loop that iterates over each FoodItems object in items
        for (FoodItems item : items) { 
            // adds the price of each FoodItems object to total
            total += item.getPrice(); 
        }
        
        // This line returns total
        return total; 
    }

    // declares a private method called calculateDiscountTotal that takes an argument of type double and returns a double
    private double calculateDiscountTotal(double total) { 
       
        // checks if discountApplied is true
        if (discountApplied) { 
            // If it is, this line returns the result of multiplying total by discountPercentage divided by 100
            return total * (discountPercentage / 100); 
        }
        // If it isn't, this line returns 0
        return 0; 
    }

    // declares a public method called applyDiscount that takes an argument of type double
    public void applyDiscount(double percentage) { 
        
        // checks if discountApplied is false
        if (!discountApplied) { 
           
             // If it is, this line sets discountApplied to true
            discountApplied = true;
            // sets discountPercentage to percentage passed in as an argument 
            discountPercentage = percentage; 
             // calls the updateTotals() method to update all totals on this panel 
            updateTotals();
            // shows a message dialog box indicating that the discount has been applied.
            JOptionPane.showMessageDialog(null, "Discount applied: " + percentage + "%"); 
        } else {
            
            // shows a message dialog box indicating that the discount has already been applied.
            JOptionPane.showMessageDialog(null, "Discount has already been applied."); 
        }
    }

    // a public method called noDiscount
    public void noDiscount() { 
        
         // checks if discountApplied is true.
        if (discountApplied) { 
        
            //If it is true, then it sets it to false.
            discountApplied = false;  
            // sets discountPercentage to 0.
            discountPercentage = 0; 
            // calls the updateTotals() method to update all totals on this panel 
            updateTotals(); 
            // shows a message dialog box indicating that the voucher has been removed.
            JOptionPane.showMessageDialog(null, "Voucher removed."); 
        }
    }

    // a public method called resetReceipt 
    public void resetReceipt() { 
    
        // clears the receiptModel
        receiptModel.clear(); 
        // clears the items
        items.clear();
        // calls the updateTotals() method to update all totals on this panel 
        updateTotals(); 
        //sets discountApplied to false
        discountApplied = false; 
        // sets discountPercentage to 0
        discountPercentage = 0; 
    
    }
}
