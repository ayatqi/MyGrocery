/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mygrocery;

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335)
 */
import javax.swing.*;

public class MyGrocery {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MyGrocery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        frame.getContentPane().add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }
}