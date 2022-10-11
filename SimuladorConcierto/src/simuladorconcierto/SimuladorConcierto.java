/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorconcierto;

import javax.swing.JFrame;

/**
 *
 * @author gammm
 */
public class SimuladorConcierto extends JFrame{
    int z = 1000;
    public SimuladorConcierto(){
        setTitle("Simulador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new Base());
        setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        new SimuladorConcierto();
    }
    
}
