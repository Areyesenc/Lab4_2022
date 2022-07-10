package model;

public class Symbol {
    private final int value;

    /**
     *
     *
     * @param valueCreate un nuevo simbolo hacia el valor del símbolo
     */
    public Symbol(int value) {
        this.value = value;
    }

    /**
     * Obtiene el valor del símbolo
     *
     * @return el valor del mismo._.
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return value == ((Symbol) obj).value;
    }
}
