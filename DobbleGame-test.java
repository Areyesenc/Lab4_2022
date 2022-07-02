package org.example;

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dobblegame {

    private final List<Player> players;
    int currentIndex;
    boolean gameOver;
    Scanner input;
    private Dobble dobble;
  	private JFrame frame;
   	private JTextField textFieldName;

    // crea un nuevo juego de Dobble..
    public DobbleGame() {
        dobble = null;
        players = new ArrayList<>();
        currentIndex = 0;
        input = new Scanner(System.in);
  
    //crea la app
   	public dobblegameGUI() {
		initialize();
      
    //contenido del frame  
    private void initialize() {
		  frame = new JFrame();
		  frame.setBounds(100, 100, 600, 600);
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  textFieldName = new JTextField();
		  frame.getContentPane().add(textFieldName, BorderLayout.NORTH);
		  textFieldName.setColumns(10);  
        
        
	}
}
