/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

import javax.swing.*;

/**
 *
 * @author Ayat
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DiscountPanel extends JPanel {

    private List<String> cardNumbers;
    private Receipt receipt;
    private boolean discountApplied;

    DiscountPanel(Receipt receipt) {
        this.receipt = receipt;
        discountApplied = false;

        // Initialize the list of card numbers
        cardNumbers = new ArrayList<>();
        cardNumbers.add("123456789");
        cardNumbers.add("987654321");
        cardNumbers.add("567890123");

        // First Row: Card Number
        JLabel cardNumberLabel = new JLabel("Card Number");
        JTextField cardNumberField = new JTextField(10); // Adjust the size as needed
        JButton submitButton = new JButton("Submit");

        JPanel cardNumberPanel = new JPanel();
        cardNumberPanel.add(cardNumberLabel);
        cardNumberPanel.add(cardNumberField);
        cardNumberPanel.add(submitButton);
        add(cardNumberPanel);

        // Second Row: Discount Vouchers
        JLabel discountLabel = new JLabel("Vouchers");
        JButton discountButton = new JButton("Chicken and Coke");
        
        discountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle voucher button click
                String selectedVoucher = discountButton.getText();
                boolean chickenAndCokeIncluded = checkChickenAndCokeIncluded();

                if (chickenAndCokeIncluded) {
                    applyDiscountVoucher(selectedVoucher);
                } else {
                    JOptionPane.showMessageDialog(null, "The voucher is not applicable as Chicken and Cola are not included in the receipt.");
                }
            }
        });

        // Clear Vouchers button
        JButton clearButton = new JButton("Clear Vouchers");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.noDiscount();
                discountApplied = false; 
            }
        });

        JPanel discountPanel = new JPanel();
        discountPanel.add(discountLabel);
        discountPanel.add(discountButton);
        discountPanel.add(clearButton);
        add(discountPanel);

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
    }

    private boolean checkChickenAndCokeIncluded() {
        DefaultListModel<String> receiptModel = receipt.getReceiptModel();
        boolean chickenIncluded = false;
        boolean cokeIncluded = false;

        // Iterate over the items in the receiptModel
        for (int i = 0; i < receiptModel.size(); i++) {
            String itemString = receiptModel.getElementAt(i);
            if (itemString.contains("Chicken")) {
                chickenIncluded = true;
            } else if (itemString.contains("Cola")) {
                cokeIncluded = true;
            }

            // Break the loop if both Chicken and Coke are found
            if (chickenIncluded && cokeIncluded) {
                break;
            }
        }

        // Return true if both Chicken and Coke are included in the receiptModel
        return chickenIncluded && cokeIncluded;
    }

    private void applyDiscountVoucher(String voucher) {
        if (!discountApplied) {
            JOptionPane.showMessageDialog(null, "Discount applied: " + voucher);
            receipt.applyDiscount(5); // Apply 10% discount to the receipt
            discountApplied = true; // Set the flag to indicate discount applied
        } else {
            JOptionPane.showMessageDialog(null, "Discount has already been applied.");
        }
    }

    private void clearVouchers() {
        discountApplied = false;
        JOptionPane.showMessageDialog(null, "Vouchers cleared.");
    }
}
