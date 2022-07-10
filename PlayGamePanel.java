package view;

import model.Card;
import model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayGamePanel extends JPanel {

    JLabel lblC1;
    JLabel lblC2;

    Card a;
    Card b;

    /**
     * Crea un nuevo panel de juego
     */
    public PlayGamePanel() {
        super();
        refresh();
    }

    /**
     * rfresca el contenido
     */
    public void refresh() {
        removeAll();
        setLayout(new GridLayout(5, 1));

        lblC1 = new JLabel();
        lblC2 = new JLabel();
        JPanel panelPlayers = new JPanel(new FlowLayout());
        JButton btnBack = new JButton();

        DobbleGame.getInstance()
                .getPlayers()
                .forEach(player -> {
                    JButton btnPlayer = new JButton();
                    btnPlayer.setText(player.getName());
                    btnPlayer.addActionListener(actionEvent -> {
                        DobbleGame.getInstance()
                                .playerGuess(player, a);
                        newRound();
                    });
                    panelPlayers.add(btnPlayer);
                });

        btnBack.setText("Volver");
        btnBack.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "menu");
        });

        if (DobbleGame.getInstance()
                .getDobble() != null) newRound();

        add(lblC1);
        add(lblC2);
        add(panelPlayers);
        add(btnBack);
    }

    void newRound() {
        DobbleGame game = DobbleGame.getInstance();
        List<Card> cards = game.newRound();
        if (cards == null) {
            // game over
            GUI.getInstance()
                    .navigate(this, "Status", false);
        } else {
            a = cards.get(0);
            b = cards.get(1);
            lblC1.setText(a.toString());
            lblC2.setText(b.toString());
        }
    }
}
