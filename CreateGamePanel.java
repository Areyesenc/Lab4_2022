package view;

import model.DobbleGame;

import javax.swing.*;
import java.awt.*;

public class CreateGamePanel extends JPanel {

    /**
     * crea el panel de juego
     */
    public CreateGamePanel() {
        super();
        refresh();
    }

    /**
     * actualiza los datos ingresasdos... remover
     */
    public void refresh() {
        removeAll();
        setLayout(new GridLayout(3, 1));

        JLabel lblTitle = new JLabel();
        lblTitle.setText("Coloca el número de cartas");

        JTextField txtNumCards = new JTextField();

        JButton btnCreate = new JButton();
        btnCreate.setText("Crear Juego");
        btnCreate.addActionListener(actionEvent -> {
            DobbleGame.getInstance()
                    .createGame(Integer.parseInt(txtNumCards.getText()));
            txtNumCards.setText("");
            GUI.getInstance()
                    .navigate(this, "menu");
        });

        add(lblTitle);
        add(txtNumCards);
        add(btnCreate);
    }
}
