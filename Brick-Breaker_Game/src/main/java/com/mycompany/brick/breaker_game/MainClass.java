/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brick.breaker_game;

import javax.swing.JFrame;

/**
 *
 * @author Sandy
 */
public class MainClass {
    public static void main (String args[]) {
        JFrame frame = new JFrame();
        GamePlay gameplay =new GamePlay();
        frame.setBounds(100, 100, 710, 600);
        frame.setTitle("Brick Breaker Game");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
        
    }
}
