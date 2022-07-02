package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cards;

    //se crea un nuevo jugardor
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }
//Agregamos cartas al juegdor
    public void addCard(Card card) {

        cards.add(card);
    }
 // obtiene las cartas de un jugdor
    //@return las cartas del jugador
    public List<Card> getCards() {

        return cards;
    }

 // obtenemos el nombre del jugador
    //@return erl nombre del jugador
    public String getName() {

        return name;
    }

//restablece las cartas de todos los jugadores
    public void reset() {

        cards = new ArrayList<>();
    }

    @Override
    public String toString() {

        return String.format("%s: (%d cartas)", name, cards.size());
    }
}
