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
     // register
	JButton btnAddClient = new JButton("register");
	btnregister.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			dobblegame.register(textFieldName.getText());
			javax.swing.JOptionPane.showMessageDialog(null, "jugador agregado con éxito");
		} catch (dobblegameException e2) {
			// TODO: handle exception
			javax.swing.JOptionPane.showMessageDialog(null, "Error "+e2.getCode()+": "+e2.getMessage() );
			}
		}
	});
	frame.getContentPane().add(btnAddClient, BorderLayout.WEST);
	
//menu! 
	//colocar el frame con lo de arriba ... 
		
  int mainMenu() {
        try {
            System.out.println();
            System.out.println();
            System.out.println("Bienvenido al juego de Dobble!");
            System.out.println();
            System.out.println("1. Crear un juego");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Jugar!");
            System.out.println("4. Visualizar estado completo del juego");
            System.out.println("5. Salir");
            System.out.print("\t: ");
            return Integer.parseInt(input.nextLine());
        }catch (Exception ignored) {
            System.out.println("debes colocar una de las 5 opciones!!");
        }
        return 0;
    }

	    //Creación del menu
    void createGameMenu() {
        try {
            System.out.print("Coloca el numero de cartas: ");
            int numberOfCards = Integer.parseInt(input.nextLine());
            dobble = new Dobble(numberOfCards);
            for (Player player : players) player.reset();
            currentIndex = 0;
            System.out.println("Juego creado.");
        } catch (Exception ignored) {
        }
    }

    //agrega un nuevo jugador al juego
    void addPlayerMenu() {
        System.out.print("Coloca el nombre del jugador: ");
        String name = input.nextLine()
                .strip();
        addPlayer(new Player(name));
    }

    //empieza el juego

    void playMenu() {
        if (players.size() < 2) {
            System.out.println("Por favor, agrega a lo menos 02 jugadores para jugar a Dobble.");
            return;
        }
        if (dobble == null) {
            System.out.println("Por favor crea un juego para jugar a Dobble");
            return;
        }
        while (!gameOver) {
            playRound();
        }
        System.out.println(this);
    }

    //muestra la estadistica
    void statsMenu() {

        System.out.println(this);
    }
		
}
