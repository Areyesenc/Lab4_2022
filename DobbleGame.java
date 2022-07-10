package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DobbleGame {
    private static DobbleGame instance = null;
    private final List<Player> players;
    boolean gameOver;
    Scanner input;
    private int currentIndex;
    private Dobble dobble;

    /**
     * crear el juego nuevo de dobble
     */
    private DobbleGame() {
        dobble = null;
        players = new ArrayList<>();
        currentIndex = 0;
        input = new Scanner(System.in);
    }

    public static DobbleGame getInstance() {
        if (instance == null) instance = new DobbleGame();
        return instance;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dobble getDobble() {
        return dobble;
    }


    /**
     * agrega un jugador
     *
     * @param player el jugador que se va agregar
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Card> newRound() {
        try {
            List<Card> cards = new ArrayList<>();
            cards.add(dobble.getCards()
                    .get(currentIndex));
            cards.add(dobble.getCards()
                    .get(++currentIndex));
            return cards;
        } catch (IndexOutOfBoundsException e) {
            gameOver = true;
            return null;
        }
    }

    public void playerGuess(Player player, Card card) {
        player.addCard(card);
    }

    /**
     * jugar dobble
     */

    public void createGame(int numberOfCards) {
        dobble = new Dobble(numberOfCards);
        for (Player player : players) player.reset();
        currentIndex = 0;
    }

    @Override
    public String toString() {
        if (dobble == null) return "No hay juego en curso.";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Estadísticas de juego actuales:\n");
        for (Player player : players) {
            stringBuilder.append(player)
                    .append("\n");
        }
        stringBuilder.append("Status de juego: ")
                .append(gameOver ? String.format("Ganador %s", getWinner().getName()) : "en progreso..")
                .append("\n");
        return stringBuilder.toString();
    }

    /**
     * obtiene al ganador del juego
     *
     * @return el ganador del juego si este termina, sino entrega null..
     */
    public Player getWinner() {
        if (!gameOver) return null;
        return players.stream()
                .reduce((player, player2) -> player2.getCards()
                        .size() > player.getCards()
                        .size() ? player2 : player)
                .orElse(null);
    }
}
