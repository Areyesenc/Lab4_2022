package model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<Symbol> symbols;

    /**
     * Crea una nueva carta.
     */
    public Card() {
        symbols = new ArrayList<>();
    }


    /**
     * Creaa una nueva carta y obtiene una lsta de simbolos.
     *
     * @param symbols - lista de simbolos.
     */
    public Card(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    /**
     * Agrega un simbolo a la carta
     *
     * @param symbol - el simbolo a agregar
     */
    public void addSymbol(Symbol symbol) {
        symbols.add(symbol);
    }

    /**
     * obtiene el simbolo en la carta
     *
     * @return la lista de simbolos en la carta
     */
    public List<Symbol> getSymbols() {
        return symbols;
    }

    /**
     * Comprueba si la carta tiene un símbolo.
     *
     * @param symbol el simbolo comprueba para
     * @return true si la carta esta con el simbolo.
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
