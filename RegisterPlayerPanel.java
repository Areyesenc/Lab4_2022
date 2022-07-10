package view;

import model.DobbleGame;
import model.Player;

import javax.swing.*;
import java.awt.*;

public class RegisterPlayerPanel extends JPanel {

    /**
     * Crea un nuevo panel de registro del jugador
     */
    public RegisterPlayerPanel() {
        super();
        refresh();
    }

    /**
     * actualiza el contenido
     */
    public void refresh() {
        removeAll();
        setLayout(new GridLayout(3, 1));

        JLabel lblTitle = new JLabel();
        lblTitle.setText("Coloca el nombre del jugador");

        JTextField txtPlayerName = new JTextField();

        JButton btnCreate = new JButton();
        btnCreate.setText("Registrar un jugador");
        btnCreate.addActionListener(actionEvent -> {
            DobbleGame.getInstance()
                    .addPlayer(new Player(txtPlayerName.getText()));
            txtPlayerName.setText("");
            GUI.getInstance()
                    .navigate(this, "menu");
        });

        add(lblTitle);
        add(txtPlayerName);
        add(btnCreate);
    }
}
