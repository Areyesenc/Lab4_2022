package org.example;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<Symbol> symbols;

    //crea una cara
    public Card() {

        symbols = new ArrayList<>();
    }

    /**
     * Crear una carta con la lista de símbolos obtenioda.
     *
     * @param symbols es la lista de símbolos.
     */
    public Card(List<Symbol> symbols) {

        this.symbols = symbols;
    }
    //Agrega los simbobolos a la carta
    public void addSymbol(Symbol symbol) {

        symbols.add(symbol);
    }
    //obtiene los símbolos de la carta.

    public List<Symbol> getSymbols() {

        return symbols;
    }

    /**
     * Comprueba si la carta tiene un símbolo.
     *
     * @param symbol el símbolo a comprobar
     * @return true si el símbolo está en la carta.
     */
    public boolean hasSymbol(Symbol symbol) {
        return symbols.stream()
                .anyMatch(s -> s.equals(symbol));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Symbol symbol : symbols)
            stringBuilder.append(symbol)
                    .append(" ");
        return stringBuilder.toString()
                .strip();
    }
}
