package view;

import model.DobbleGame;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    /**
     * Create a new MainMenu panel.
     */
    public MainMenuPanel() {
        super();
        refresh();
    }

    /**
     * refresca el dato
     */
    public void refresh() {
        removeAll();
        setLayout(new GridLayout(2, 2));

        JButton btnCreate = new JButton();
        if (DobbleGame.getInstance()
                .getPlayers()
                .size() < 2) {
            btnCreate.setText("Registra al menos 2 jugadores para crear una partida.");
            btnCreate.setEnabled(false);
        } else {
            btnCreate.setText("Crear un juego");
        }
        btnCreate.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "CrearJuego");
        });
        add(btnCreate);

        JButton btnRegister = new JButton();
        btnRegister.setText("Registrar un Jugador");
        btnRegister.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "registrarJugador");
        });
        add(btnRegister);

        JButton btnPlay = new JButton();

        if (DobbleGame.getInstance()
                .getDobble() == null) {
            btnPlay.setText("Por favor, crea una partida antes de jugar.");
            btnPlay.setEnabled(false);
        } else {
            btnPlay.setText("Jugar");
        }
        btnPlay.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "Jugar");
        });
        add(btnPlay);

        JButton btnStats = new JButton();
        btnStats.setText("Estadísticas del juego");
        btnStats.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "Status");
        });
        add(btnStats);
    }
}
