package Module2;

//braden heeney
//advanced java 2022
//puzzle widget

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.text.*;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import java.util.logging.Logger;
//import java.util.logging.Level;
//import javax.script.ScriptException;
//import java.util.*;
import java. util. Random;


public class puzWig extends JPanel implements ActionListener{
	JButton[][] buttons = new JButton[5][];
	JPanel titlePanel, centerPanel, bar0,bar1,bar2,bar3,bar4;
	JTextField Title;
	int [] randNumbers = new int[5];
	public puzWig(){
		Random rand = new Random();
		for(int i=0;i<5;i++){
			randNumbers[i]=rand. nextInt(25);
		}
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5,5,10,10));
		Title = new JTextField();
		Title.setText("Turn all boxes grey");
		Title.setEditable(false);
		Title.setBorder(BorderFactory.createBevelBorder(1));
		Title.setFont(new Font ("Unispace", Font.BOLD, 30));
		Title.setHorizontalAlignment(JTextField.CENTER);
		titlePanel = new JPanel();
		titlePanel.add(Title);
		for(int i=0; i <5;i++){
			buttons[i] = new JButton[5];
			for(int j=0; j < 5; j++){
				buttons[i][j] = new JButton("");
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.GRAY);
				centerPanel.add(buttons[i][j]);
			}
		}
		this.setLayout(new BorderLayout());
		add(titlePanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		for(int r = 0; r<5;r++){
			int count=0;
			for(int i=0; i < 5;i++){
				for(int j=0;j<5;j++){
					if(count == randNumbers[r]){
						buttons[i][j].doClick();
					}
					count++;
				}
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		boolean finished = true;
		Color codeColor;
		/*
		for(int i=0; i < 5;i++){
				for(int j=0;j<5;j++){
					codeColor = buttons[i][j].getBackground();
					if(codeColor == Color.BLUE){
						finished=false;
					}
				}
		}
		System.out.println(finished);
		if(finished == true){
			Title.setText("WINNER");
		}
		else{
			Title.setText("Turn all boxes grey");
		}*/
		if(e.getSource() == buttons[0][0]){
			helpMe(buttons[0][0]);
			helpMe(buttons[0][1]);
			helpMe(buttons[1][0]);
		}
		if(e.getSource() == buttons[0][1]){
			helpMe(buttons[0][0]);
			helpMe(buttons[0][1]);
			helpMe(buttons[1][1]);
			helpMe(buttons[0][2]);
		}
		if(e.getSource() == buttons[0][2]){
			helpMe(buttons[0][1]);
			helpMe(buttons[0][2]);
			helpMe(buttons[1][2]);
			helpMe(buttons[0][3]);
		}
		if(e.getSource() == buttons[0][3]){
			helpMe(buttons[0][2]);
			helpMe(buttons[0][3]);
			helpMe(buttons[1][3]);
			helpMe(buttons[0][4]);
		}
		if(e.getSource() == buttons[0][4]){
			helpMe(buttons[0][3]);
			helpMe(buttons[0][4]);
			helpMe(buttons[1][4]);
			//helpMe(buttons[0][4]);
		}
		if(e.getSource() == buttons[1][0]){
			helpMe(buttons[0][0]);
			helpMe(buttons[1][1]);
			helpMe(buttons[2][0]);
			helpMe(buttons[1][0]);
		}
		if(e.getSource() == buttons[1][1]){
			helpMe(buttons[0][1]);
			helpMe(buttons[1][0]);
			helpMe(buttons[1][1]);
			helpMe(buttons[1][2]);
			helpMe(buttons[2][1]);
		}
		if(e.getSource() == buttons[1][2]){
			helpMe(buttons[0][2]);
			helpMe(buttons[1][1]);
			helpMe(buttons[1][2]);
			helpMe(buttons[1][3]);
			helpMe(buttons[2][2]);
		}
		if(e.getSource() == buttons[1][3]){
			helpMe(buttons[0][3]);
			helpMe(buttons[1][2]);
			helpMe(buttons[1][3]);
			helpMe(buttons[1][4]);
			helpMe(buttons[2][3]);
		}
		if(e.getSource() == buttons[1][4]){
			helpMe(buttons[0][4]);
			helpMe(buttons[1][3]);
			helpMe(buttons[1][4]);
			//helpMe(buttons[1][4]);
			helpMe(buttons[2][4]);
		}
		
		
		if(e.getSource() == buttons[2][0]){
			helpMe(buttons[1][0]);
			helpMe(buttons[2][1]);
			helpMe(buttons[3][0]);
			helpMe(buttons[2][0]);
		}
		if(e.getSource() == buttons[2][1]){
			helpMe(buttons[1][1]);
			helpMe(buttons[2][0]);
			helpMe(buttons[2][1]);
			helpMe(buttons[2][2]);
			helpMe(buttons[3][1]);
		}
		if(e.getSource() == buttons[2][2]){
			helpMe(buttons[1][2]);
			helpMe(buttons[2][1]);
			helpMe(buttons[2][2]);
			helpMe(buttons[2][3]);
			helpMe(buttons[3][2]);
		}
		if(e.getSource() == buttons[2][3]){
			helpMe(buttons[1][3]);
			helpMe(buttons[2][2]);
			helpMe(buttons[2][3]);
			helpMe(buttons[2][4]);
			helpMe(buttons[3][3]);
		}
		if(e.getSource() == buttons[2][4]){
			helpMe(buttons[1][4]);
			helpMe(buttons[2][3]);
			helpMe(buttons[2][4]);
			//helpMe(buttons[1][4]);
			helpMe(buttons[3][4]);
		}
		
		if(e.getSource() == buttons[3][0]){
			helpMe(buttons[2][0]);
			helpMe(buttons[3][1]);
			helpMe(buttons[4][0]);
			helpMe(buttons[3][0]);
		}
		if(e.getSource() == buttons[3][1]){
			helpMe(buttons[2][1]);
			helpMe(buttons[3][0]);
			helpMe(buttons[3][1]);
			helpMe(buttons[3][2]);
			helpMe(buttons[4][1]);
		}
		if(e.getSource() == buttons[3][2]){
			helpMe(buttons[2][2]);
			helpMe(buttons[3][1]);
			helpMe(buttons[3][2]);
			helpMe(buttons[3][3]);
			helpMe(buttons[4][2]);
		}
		if(e.getSource() == buttons[3][3]){
			helpMe(buttons[2][3]);
			helpMe(buttons[3][2]);
			helpMe(buttons[3][3]);
			helpMe(buttons[3][4]);
			helpMe(buttons[4][3]);
		}
		if(e.getSource() == buttons[3][4]){
			helpMe(buttons[2][4]);
			helpMe(buttons[3][3]);
			helpMe(buttons[3][4]);
			//helpMe(buttons[1][4]);
			helpMe(buttons[4][4]);
		}
		
		
		if(e.getSource() == buttons[4][0]){
			helpMe(buttons[3][0]);
			helpMe(buttons[4][0]);
			helpMe(buttons[4][1]);
		}
		if(e.getSource() == buttons[4][1]){
			helpMe(buttons[4][0]);
			helpMe(buttons[4][1]);
			helpMe(buttons[4][2]);
			helpMe(buttons[3][1]);
		}
		if(e.getSource() == buttons[4][2]){
			helpMe(buttons[4][1]);
			helpMe(buttons[4][2]);
			helpMe(buttons[4][3]);
			helpMe(buttons[3][2]);
		}
		if(e.getSource() == buttons[4][3]){
			helpMe(buttons[4][2]);
			helpMe(buttons[4][3]);
			helpMe(buttons[4][4]);
			helpMe(buttons[3][3]);
		}
		if(e.getSource() == buttons[4][4]){
			helpMe(buttons[4][4]);
			helpMe(buttons[4][3]);
			helpMe(buttons[3][4]);
			//helpMe(buttons[0][4]);
		}
		
		this.repaint();
		this.revalidate();
		
		
	}
	
	public void helpMe(JButton button){
		if(button.getBackground() == Color.BLUE){
				button.setBackground(Color.GRAY);
			}
			else{
				button.setBackground(Color.BLUE);
			}
	}
}