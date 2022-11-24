package com.mycompany.calculatorvis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorVis implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
         
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("serif",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	CalculatorVis(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
                frame.setBackground(Color. black);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
                textfield.setBackground(Color. black);
		
		
		addButton = new JButton("+");
                  addButton.setBackground(Color.red);
		subButton = new JButton("-");
                    subButton.setBackground(Color.red);
		mulButton = new JButton("*");
                     mulButton.setBackground(Color.red);
		divButton = new JButton("/");
                    divButton.setBackground(Color.red);
		decButton = new JButton(".");
                    decButton.setBackground(Color.red);
		equButton = new JButton("=");
                    equButton.setBackground(Color.red);
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
                  functionButtons[0].setBackground(Color.black);
                  functionButtons[0].setForeground(Color.white);
                functionButtons[1] = subButton;
                  functionButtons[1].setBackground(Color.black);
                  functionButtons[1].setForeground(Color.white);
		functionButtons[2] = mulButton;
                  functionButtons[2].setBackground(Color.black);
                  functionButtons[2].setForeground(Color.white);
		functionButtons[3] = divButton;
                  functionButtons[3].setBackground(Color.black);
                  functionButtons[3].setForeground(Color.white);
		functionButtons[4] = decButton;
                  functionButtons[4].setBackground(Color.black);
                  functionButtons[4].setForeground(Color.white);
		functionButtons[5] = equButton;
                  functionButtons[5].setBackground(Color.black);
                  functionButtons[5].setForeground(Color.white);
		functionButtons[6] = delButton;
                  functionButtons[6].setBackground(Color.black);
                  functionButtons[6].setForeground(Color.white);
		functionButtons[7] = clrButton;
                  functionButtons[7].setBackground(Color.black);
                  functionButtons[7].setForeground(Color.white);
		functionButtons[8] = negButton;
                  functionButtons[8].setBackground(Color.black);
                  functionButtons[8].setForeground(Color.white);
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(true);
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButtons[1]);
               
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		CalculatorVis calc = new CalculatorVis();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}
