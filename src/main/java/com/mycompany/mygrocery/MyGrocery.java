/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 */

package com.mycompany.mygrocery; 

/**
 *
 * Ayat Abdulaziz Gaber Al-Khulaqi (ID: 1191202335) 
 */

import javax.swing.*; 

public class MyGrocery { 
    
    public static void main(String[] args) {
        
         //creates a new thread for the GUI
        SwingUtilities.invokeLater(new Runnable() {
            
             // declares the run method
            public void run() { 
                
                // creates a new instance of the GroceryPanel class
                GroceryPanel groceryPanel = new GroceryPanel(); 
                
                // calls the showGUI method of the GroceryPanel class
                groceryPanel.showGUI(); 
            }
        });
    }
    
}
