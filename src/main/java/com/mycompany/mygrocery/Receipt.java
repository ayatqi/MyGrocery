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

public class Receipt extends JPanel {
    private DefaultListModel<String> receiptModel;
    private JList<String> receiptList;
    private JScrollPane scrollPane;
    private JLabel totalLabel;
    private JLabel discountTotalLabel;
    private JLabel afterDiscountTotalLabel;
    private boolean discountApplied;
    private double discountPercentage;
    private List<FoodDrink> items;

    public Receipt() {
        receiptModel = new DefaultListModel<>();
        receiptList = new JList<>(receiptModel);
        scrollPane = new JScrollPane(receiptList);
        totalLabel = new JLabel("Total: RM0.00");
        discountTotalLabel = new JLabel("Discount Total: RM0.00");
        afterDiscountTotalLabel = new JLabel("After Discount Total: RM0.00");
        discountApplied = false;
        discountPercentage = 0;
        items = new ArrayList<>();

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new GridLayout(3, 1));
        totalPanel.add(totalLabel);
        totalPanel.add(discountTotalLabel);
        totalPanel.add(afterDiscountTotalLabel);
        add(totalPanel, BorderLayout.SOUTH);
    }

    public void addItem(FoodDrink item) {
        String itemString = item.getName() + " - RM" + item.getPrice();
        receiptModel.addElement(itemString);
        items.add(item);
        updateTotals();
    }

    public void removeItem(FoodDrink item) {
        String itemString = item.getName() + " - RM" + item.getPrice();
        receiptModel.removeElement(itemString);
        items.remove(item);
        updateTotals();
    }

    public DefaultListModel<String> getReceiptModel() {
        return receiptModel;
    }

    private void updateTotals() {
        double total = calculateTotal();
        double discountTotal = calculateDiscountTotal(total);
        double afterDiscountTotal = total - discountTotal;

        totalLabel.setText("Total: RM" + String.format("%.2f", total));
        discountTotalLabel.setText("Discount Total: RM" + String.format("%.2f", discountTotal));
        afterDiscountTotalLabel.setText("After Discount Total: RM" + String.format("%.2f", afterDiscountTotal));
    }

    private double calculateTotal() {
        double total = 0;
        for (FoodDrink item : items) {
            total += item.getPrice();
        }
        return total;
    }

    private double calculateDiscountTotal(double total) {
        if (discountApplied) {
            return total * (discountPercentage / 100);
        }
        return 0;
    }

    public void applyDiscount(double percentage) {
        if (!discountApplied) {
            discountApplied = true;
            discountPercentage = percentage;
            updateTotals();
            JOptionPane.showMessageDialog(null, "Discount applied: " + percentage + "%");
        } else {
            JOptionPane.showMessageDialog(null, "Discount has already been applied.");
        }
    }

    public void noDiscount() {
        if (discountApplied) {
            discountApplied = false;
            discountPercentage = 0;
            updateTotals();
            JOptionPane.showMessageDialog(null, "Discount removed.");
        }
    }
}
