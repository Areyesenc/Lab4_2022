package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dobble {
    private final List<Card> cards;

    /**
     * Crea un nuevo modelo de baraja de Dobble con el número de cartas dado
     *
     * @param n - el n° de cartas
     */
    public Dobble(int n) {
        cards = generateCards(n);
    }

    /**
     * Genera el número dado de cartas para dobble
     *
     * @param numberOfCards el n° de cartas
     * @return generar una lista de cartas
     */
    private static List<Card> generateCards(int numberOfCards) {
        List<Card> cards = new ArrayList<>();
        int n = getPrimeForKCards(numberOfCards);
        // the first card
        cards.add(new Card(IntStream.range(1, n + 2)
                .boxed()
                .map(Symbol::new)
                .collect(Collectors.toList())));

        // the next n cards
        for (int j = 1; j <= n; j++) {
            Card card = new Card();
            card.addSymbol(new Symbol(1));
            for (int k = 1; k <= n; k++) {
                card.addSymbol(new Symbol(n * j + (k + 1)));
            }
            cards.add(card);
        }

        // the next n*n cards
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Card card = new Card();
                card.addSymbol(new Symbol(i + 1));
                for (int k = 1; k <= n; k++) {
                    card.addSymbol(new Symbol(n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n)));
                }
                cards.add(card);
            }
        }
        // shuffle the deck before returning
        Collections.shuffle(cards);
        return cards.subList(0, numberOfCards);
    }

    /**
     * Obtener el número primo correcto para el número de caertas
     *
     * @param numberOfCards el numero de cartas
     * @return el número primo del número de cartas
     */
    private static int getPrimeForKCards(int numberOfCards) {
        List<Integer> primes = getPrimesUpTo(numberOfCards);
        for (int prime : primes) {
            if (prime * prime + prime + 1 >= numberOfCards) return prime;
        }
        return primes.get(primes.size() - 1);
    }

    /**
     * Obtiene numeros primos hasta n
     *
     * @param n el limite superior
     * @return a una lista de numeros primos hasta n
     */
    private static List<Integer> getPrimesUpTo(int n) {
        return IntStream.range(2, n + 1)
                .boxed()
                .filter(Dobble::isPrime)
                .collect(Collectors.toList());
    }

    /**
     * Comprueba si un número dado es primo o no
     *
     * @param n - el número para comprobar si es primo
     * @return true si es "primo falso" - osea que el resultado no sea primo, entrega verdadero...
     */
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Obtiene la lista de cartas
     *
     * @return la lista de cartas del mazo
     */
    public List<Card> getCards() {
        return cards;
    }
}
