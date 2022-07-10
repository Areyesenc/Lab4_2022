package view;

import model.DobbleGame;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {

    /**
     * crea un nuevo status en el panel
     */
    public StatsPanel() {
        super();
        refresh();
    }

    /**
     * actualiza el contenido
     */
    public void refresh() {
        removeAll();
        setLayout(new GridLayout(1, 2));

        JTextArea lblInfo = new JTextArea();
        lblInfo.setText(DobbleGame.getInstance()
                .toString());

        JButton btnBack = new JButton();
        btnBack.setText("Volver");
        btnBack.addActionListener(actionEvent -> {
            GUI.getInstance()
                    .navigate(this, "menu");
        });

        add(lblInfo);
        add(btnBack);
    }
}
