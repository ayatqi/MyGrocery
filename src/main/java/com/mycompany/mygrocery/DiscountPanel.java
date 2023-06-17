/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

import javax.swing.*;

/**
 *
 *  Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//  declares a new class called DiscountPanel that extends JPanel
public class DiscountPanel extends JPanel {

    // declares a private instance variable of type List<String> called cardNumbers
    private List<String> cardNumbers;
    // declares a private instance variable of type Receipt
    private Receipt receipt;
    // declares a private boolean variable called discountApplied
    private boolean discountApplied;

    // a constructor for the DiscountPanel class that takes an instance of the Receipt class as an argument
    DiscountPanel(Receipt receipt) {
        
        // sets the instance variable receipt to the value of the receipt argument.
        this.receipt = receipt; 
        // sets the discountApplied variable to false.
        discountApplied = false; 

        // initializes a new ArrayList called cardNumbers.
        cardNumbers = new ArrayList<>(); 
        // adds "123456789" to the cardNumbers list.
        cardNumbers.add("123456789"); 
        // adds "987654321" to the cardNumbers list.
        cardNumbers.add("987654321"); 
        // adds "567890123" to the cardNumbers list.
        cardNumbers.add("567890123"); 

        // creates a new JLabel called cardNumberLabel with text "Card Number".
        JLabel cardNumberLabel = new JLabel("Card Number"); 
        // creates a new JTextField called cardNumberField with a size of 10.
        JTextField cardNumberField = new JTextField(10); 
        //creates a new JButton called submitButton with text "Submit".
        JButton submitButton = new JButton("Submit"); 
        
        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredCardNumber = cardNumberField.getText();
                boolean cardNumberMatch = cardNumbers.contains(enteredCardNumber);

                if (cardNumberMatch && !discountApplied) {
                    // Card number matches and discount not applied yet
                    JOptionPane.showMessageDialog(null, "Card number is valid! Discount applied: 5%");
                    receipt.applyDiscount(5); // Apply 5% discount to the receipt
                    discountApplied = true; // Set the flag to indicate discount applied
                } else if (discountApplied) {
                    // Discount already applied
                    JOptionPane.showMessageDialog(null, "Discount has already been applied.");
                } else {
                    // Card number does not match
                    JOptionPane.showMessageDialog(null, "Invalid card number or voucher. Please try again.");
                    receipt.noDiscount();
                }
            }
        });
        
        
        // creates a new JPanel called cardNumberPanel.
        JPanel cardNumberPanel = new JPanel(); 
        // adds the cardNumberLabel to the cardNumberPanel.
        cardNumberPanel.add(cardNumberLabel); 
         // adds the cardNumberField to the cardNumberPanel.
        cardNumberPanel.add(cardNumberField);
        // adds the submitButton to the cardNumberPanel.
        cardNumberPanel.add(submitButton); 
        // adds the cardNumberPanel to this DiscountPanel.
        add(cardNumberPanel); 

        // creates a new JLabel called discountLabel with text "Vouchers".
        JLabel discountLabel = new JLabel("Vouchers"); 
        // creates a new JButton called discountButton with text "Chicken and Coke".
        JButton discountButton = new JButton("Chicken and Coke"); 
       
        //adds an ActionListener to the discountButton.
        discountButton.addActionListener(new ActionListener() { 
            
            // actionPerformed method that is called when the discountButton is clicked.
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                // gets the text of the discountButton and assigns it to the selectedVoucher variable.
                String selectedVoucher = discountButton.getText(); 
                // calls the checkChickenAndCokeIncluded() method and assigns its return value to the chickenAndCokeIncluded variable.
                boolean chickenAndCokeIncluded = checkChickenAndCokeIncluded(); 
                
                // checks if chickenAndCokeIncluded is true.
                if (chickenAndCokeIncluded) { 
                    
                    //If it is true, then it calls the applyDiscountVoucher() method with the selectedVoucher as an argument.
                    applyDiscountVoucher(selectedVoucher); 
                } else {
                    
                     //If it is false, then it shows a message dialog box indicating that the voucher is not applicable.
                    JOptionPane.showMessageDialog(null, "The voucher is not applicable as Chicken and coke are not included in the receipt.");
                }
            }
        });


        // creates a new JButton called clearButton with text "Clear Vouchers".
        JButton clearButton = new JButton("Clear Vouchers"); 
        // adds an ActionListener to the clearButton.
        clearButton.addActionListener(new ActionListener() { 
           
            // the actionPerformed method that is called when the clearButton is clicked.
            @Override
            public void actionPerformed(ActionEvent e) { 
               
                // calls the noDiscount() method of the receipt object.
                receipt.noDiscount(); 
                // sets the discountApplied variable to false.
                discountApplied = false; 
            }
        });
        
        // creates a new JButton called resetButton with text "Reset".
        JButton resetButton = new JButton("Reset"); 
         // adds an ActionListener to the resetButton.
        resetButton.addActionListener(new ActionListener() {
            
            //T actionPerformed method that is called when the resetButton is clicked.
            @Override
            public void actionPerformed(ActionEvent e) { 
               
                 // calls the resetDiscount() method.
                resetDiscount();
                cardNumberField.setText("");
                
            }
        });

        // creates a new JPanel called discountPanel.
        JPanel discountPanel = new JPanel(); 
        // adds the discountLabel to the discountPanel.
        discountPanel.add(discountLabel); 
        // adds the discountButton to the discountPanel.
        discountPanel.add(discountButton); 
        // adds the clearButton to the discountPanel.
        discountPanel.add(clearButton); 
        // adds the resetButton to the discountPanel.
        discountPanel.add(resetButton); 
        // adds the discountPanel to this DiscountPanel.
        add(discountPanel); 

    }

    // creates a new method called checkChickenAndCokeIncluded that returns a boolean value.
    private boolean checkChickenAndCokeIncluded() { 
        
        // gets the receiptModel from the receipt object and assigns it to a new DefaultListModel called receiptModel.
        DefaultListModel<String> receiptModel = receipt.getReceiptModel(); 
        // creates a new boolean variable called chickenIncluded and sets it to false.
        boolean chickenIncluded = false; 
        // creates a new boolean variable called cokeIncluded and sets it to false.
        boolean cokeIncluded = false; 

        // Iterate over the items in the receiptModel
        // starts a for loop that iterates over each item in the receiptModel.
        for (int i = 0; i < receiptModel.size(); i++) { 
            
            // gets the current item from the receiptModel and assigns it to a new String variable called itemString.
            String itemString = receiptModel.getElementAt(i); 
            
            // checks if the itemString contains the word "Chicken".
            if (itemString.contains("Chicken")) { 
                
                //If it does, then it sets chickenIncluded to true.
                chickenIncluded = true; 
            } 
            // checks if the itemString contains the word "Coke".
            else if (itemString.contains("Coke")) { 
               
                //If it does, then it sets cokeIncluded to true.
                cokeIncluded = true; 
            }

            // checks if both chickenIncluded and cokeIncluded are true.
            if (chickenIncluded && cokeIncluded) { 
                
                //If they are, then it breaks out of the for loop.
                break; 
            }
        }

        // Return true if both Chicken and Coke are included in the receiptModel
        return chickenIncluded && cokeIncluded; 
    }


    
    private void applyDiscountVoucher(String voucher) {
        
        // Check if discount has not been applied yet
        if (!discountApplied) { 
            
            // Show message box with the voucher code applied
            JOptionPane.showMessageDialog(null, "Discount applied: " + voucher); 
            // Apply 5% discount to the receipt
            receipt.applyDiscount(5); 
            // Set the flag to indicate discount applied
            discountApplied = true; 
        } else {
            
            // Show message box with message that discount has already been applied
            JOptionPane.showMessageDialog(null, "Discount has already been applied."); 
        }
    }

    
    public void clearVouchers() {
        
         // Set the flag to indicate no discount applied
        discountApplied = false;
         // Show message box with message that vouchers have been cleared
        JOptionPane.showMessageDialog(null, "Vouchers cleared.");
    }

    
    public void resetDiscount() {
        
        // Reset the receipt
        receipt.resetReceipt(); 
        // Set the flag to indicate no discount applied
        discountApplied = false; 
        // Show message box with message that receipt has been reset
        JOptionPane.showMessageDialog(null, "Reset Receipt."); 
    }

}
