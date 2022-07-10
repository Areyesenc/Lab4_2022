package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cards;

    /**
     * crea un nuevo jugador
     *
     * @param name - el nombre del jugador
     */
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    /**
     * Añade una carta al juagdor
     *
     * @param card la carta a agregar
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * obtienen las cartas de los jugadores
     *
     * @return la carta del juagdor
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * obtiene el nombre del jugador
     *
     * @return el nomnbre del jugadoir
     */
    public String getName() {
        return name;
    }

    /**
     * Restablecer las cartas de los jugadores
     */
    public void reset() {
        cards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s: (%d cartas)", name, cards.size());
    }
}
