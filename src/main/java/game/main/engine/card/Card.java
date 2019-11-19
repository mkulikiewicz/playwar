package game.main.engine.card;

import java.util.Objects;

/**
 * Utwórz klasę testową CardTest
 *
 * Wszystkie z poniższych przypadków mogłyby pobierać dane z pliku csv
 */
class Card implements CardInterface {
    private Color color;
    private Rank rank;

    Card(Rank value, Color color) {
        this.rank = value;
        this.color = color;
    }

    /**
     * Uwtórz przypadek testowy który sprawdzi że dla każdej karty w tali jej to string jest równy rank+color
     * Do zadania wykorzystaj @DataProvider'a
     * @return
     */
    public String toString() {
        return rank + "" + color;
    }

    /**
     *  Utwórz 2 przypadki testowe które sprawdzą porównanie rank kart wyższych z niższymi.
     *  Do każdego przypadku wykorzystaj @DataProvider,a aby utworzyć 2 zestawy danych.
     * @param card
     * @return
     */
    @Override
    public boolean biggerRankThen(CardInterface card) {
        return this.rank.ordinal() > card.getRank().ordinal();
    }

    /**
     * Utwórz 2 przypadki testowe sprawdzające równość oraz nie równość rangi karty
     * Do każdego przypadku wykorzystaj @DataProvider,a aby utworzyć 2 zestawy danych.
     * @param card
     * @return
     */
    @Override
    public boolean equalsRank(CardInterface card) {
        return this.rank.ordinal() == card.getRank().ordinal();
    }

    /**
     * Utwórz przypadek testowy w którym sprawdzisz czy metoda getRank zwraca rangę karty
     * Wykorzysta @DataProvider,a który został utworzony dla metody toString
     * @return
     */
    @Override
    public Rank getRank() {
        return rank;
    }

    /**
     * Utwórz 2 przypadki testowe sprawdzające równość oraz nie równość kart (rangi i jej koloru)
     * Wykorzysta @DataProvider,a
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (Objects.nonNull(obj) && obj instanceof Card) {
            if (((Card) obj).color == color && ((Card) obj).rank == rank)
                return true;
        }
        return false;
    }
}
