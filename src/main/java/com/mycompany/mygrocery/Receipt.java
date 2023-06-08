/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receipt extends JPanel {
    private DefaultListModel<String> receiptModel;
    private JList<String> receiptList;
    private JScrollPane scrollPane;
    private JLabel totalLabel;

    public Receipt() {
        receiptModel = new DefaultListModel<>();
        receiptList = new JList<>(receiptModel);
        scrollPane = new JScrollPane(receiptList);
        totalLabel = new JLabel("Total: RM0.00"); // Label to display the total price

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.SOUTH);
    }

    public void addItem(FoodDrink item) {
        String itemString = item.getName() + " - RM" + item.getPrice();
        receiptModel.addElement(itemString);
        updateTotal();
    }

    public void removeItem(FoodDrink item) {
        String itemString = item.getName() + " - RM" + item.getPrice();
        receiptModel.removeElement(itemString);
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (int i = 0; i < receiptModel.size(); i++) {
            String itemString = receiptModel.elementAt(i);
            String[] parts = itemString.split(" - RM");
            double itemPrice = Double.parseDouble(parts[1]);
            total += itemPrice;
        }
        totalLabel.setText("Total: RM" + String.format("%.2f", total)); // Update the total price label
    }

    public List<FoodDrink> getItems() {
        List<FoodDrink> itemList = new ArrayList<>();
        for (int i = 0; i < receiptModel.size(); i++) {
            String itemString = receiptModel.elementAt(i);
            String[] parts = itemString.split(" - RM");
            String itemName = parts[0];
            double itemPrice = Double.parseDouble(parts[1]);
            itemList.add(new FoodDrink(itemName, itemPrice));
        }
        return itemList;
    }

    public void createRemoveItemButton(FoodDrink item) {
        JButton removeButton = new JButton("-");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem(item);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(removeButton);

        // Create a new panel to hold the item name and the delete button
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.add(new JLabel(item.getName()), BorderLayout.CENTER);
        itemPanel.add(buttonPanel, BorderLayout.EAST);

        receiptList.add(itemPanel); // Add the item panel to the JList
        updateTotal();
    }
}
