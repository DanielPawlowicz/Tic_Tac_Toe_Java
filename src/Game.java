import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	
	Game(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,250,0));
		textField.setFont(new Font("Verdane", Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		titlePanel.add(textField);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Verdana", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setEnabled(false);
		}
		
		frame.add(buttonPanel);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.setVisible(true);
		
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1Turn = false;
						textField.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1Turn = true;
						textField.setText("X turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1Turn = true;
			textField.setText("X turn");
		}
		else {
			player1Turn = false;
			textField.setText("O turn");
		}
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(true);
		}
	}
	
	public void check() {
		
		// X wins conditions
			// horizontal
		if(
				buttons[0].getText()=="X" &&
				buttons[1].getText()=="X" && 
				buttons[2].getText()=="X"
				){
			xWins(0,1,2);
		}
		if(
				buttons[3].getText()=="X" &&
				buttons[4].getText()=="X" && 
				buttons[5].getText()=="X"
				){
			xWins(3,4,5);
		}
		if(
				buttons[6].getText()=="X" &&
				buttons[7].getText()=="X" && 
				buttons[8].getText()=="X"
				){
			xWins(6,7,8);
		}
			//vertical
		if(
				buttons[0].getText()=="X" &&
				buttons[3].getText()=="X" && 
				buttons[6].getText()=="X"
				){
			xWins(0,3,6);
		}
		if(
				buttons[1].getText()=="X" &&
				buttons[4].getText()=="X" && 
				buttons[7].getText()=="X"
				){
			xWins(1,4,7);
		}
		if(
				buttons[2].getText()=="X" &&
				buttons[5].getText()=="X" && 
				buttons[8].getText()=="X"
				){
			xWins(2,5,8);
		}
			// skew
		if(
				buttons[0].getText()=="X" &&
				buttons[4].getText()=="X" && 
				buttons[8].getText()=="X"
				){
			xWins(0,4,8);
		}
		if(
				buttons[6].getText()=="X" &&
				buttons[4].getText()=="X" && 
				buttons[2].getText()=="X"
				){
			xWins(6,4,2);
		}
		
		
		
		// O wins conditions
			// horizontal
		if(
				buttons[0].getText()=="O" &&
				buttons[1].getText()=="O" && 
				buttons[2].getText()=="O"
				){
			oWins(0,1,2);
		}
		if(
				buttons[3].getText()=="O" &&
				buttons[4].getText()=="O" && 
				buttons[5].getText()=="O"
				){
			oWins(3,4,5);
		}
		if(
				buttons[6].getText()=="O" &&
				buttons[7].getText()=="O" && 
				buttons[8].getText()=="O"
				){
			oWins(6,7,8);
		}
			// vertical
		if(
				buttons[0].getText()=="O" &&
				buttons[3].getText()=="O" && 
				buttons[6].getText()=="O"
				){
			oWins(0,3,6);
		}
		if(
				buttons[1].getText()=="O" &&
				buttons[4].getText()=="O" && 
				buttons[7].getText()=="O"
				){
			oWins(1,4,7);
		}
		if(
				buttons[2].getText()=="O" &&
				buttons[5].getText()=="O" && 
				buttons[8].getText()=="O"
				){
			oWins(2,5,8);
		}
			// skew
		if(
				buttons[0].getText()=="O" &&
				buttons[4].getText()=="O" && 
				buttons[8].getText()=="O"
				){
			oWins(0,4,8);
		}
		if(
				buttons[6].getText()=="O" &&
				buttons[4].getText()=="O" && 
				buttons[2].getText()=="O"
				){
			oWins(6,4,2);
		}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X wins");
	}
	
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("O wins");
	}

}
