package view;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private static GUI instance = null;
    private final MainMenuPanel menuPanel;
    private final CreateGamePanel createGamePanel;
    private final RegisterPlayerPanel registerPlayerPanel;
    private final PlayGamePanel playGamePanel;
    private final StatsPanel statsPanel;

    /**
     * crea el nuevo GUI.
     */
    private GUI() {
        JFrame root = new JFrame();
        JPanel panels = new JPanel(new CardLayout());

        menuPanel = new MainMenuPanel();
        createGamePanel = new CreateGamePanel();
        registerPlayerPanel = new RegisterPlayerPanel();
        playGamePanel = new PlayGamePanel();
        statsPanel = new StatsPanel();


        panels.add(menuPanel, "menu");
        panels.add(createGamePanel, "CrearJuego");
        panels.add(registerPlayerPanel, "registrarJugador");
        panels.add(playGamePanel, "Jugar");
        panels.add(statsPanel, "Status");

        ((CardLayout) panels.getLayout()).show(panels, "menu");

        root.add(panels);
        root.setMinimumSize(new Dimension(600, 400));
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setVisible(true);
    }

    /**
     * Obtiene la instancia actual de la GUI.
     *
     * @return GUI (instancia de la interfaz)
     */
    public static GUI getInstance() {
        if (instance == null) instance = new GUI();
        return instance;
    }

    /**
     * Navega el panel dado
     *
     * @param panel el actual panel
     * @param path  nombre del panel a navegar
     */
    public void navigate(JPanel panel, String path) {
        navigate(panel, path, true);
    }

    /**
     * Navega hasta el panel que se muestra
     *
     * @param panel   el panel actual
     * @param path    el nombre del panel para navegar a "refresh"
     * @param refresh si se actualiza o no
     */
    public void navigate(JPanel panel, String path, boolean refresh) {
        if (refresh) {
            playGamePanel.refresh();

        }
        menuPanel.refresh();
        registerPlayerPanel.refresh();
        statsPanel.refresh();
        createGamePanel.refresh();
        JPanel parent = (JPanel) panel.getParent();
        ((CardLayout) parent.getLayout()).show(parent, path);
    }

}
