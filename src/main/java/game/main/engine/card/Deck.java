package game.main.engine.card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Utwórz klasę testową DeckTest
 *
 *
 * Pamiętaj o poprawnych paczkach w pakiecie testów
 */
public class Deck {
    List<Card> cardDeck = new LinkedList<>();

    public Deck() {
        createDeck();
        shuffleCard();
    }

    /**
     * Napisz 2 przypadki które sprawdzą
     * - czy w tali są wszystkie karty oraz czy zwracane obiekty są instancją karty
     * - czy jeżeli nie mamy kart to  metoda zwróci nam pustego optional'a
     *
     * w pierwszym przypadku napewno warto wykorzystać kalsę SoftAssert
     * @return
     */
    public Optional<? extends CardInterface> getCard() {
        Optional<? extends CardInterface> cardToReturn = cardDeck.stream().findAny();
        if (cardToReturn.isPresent()) {
            cardDeck.remove(cardToReturn.get());
            return cardToReturn;
        }
        return Optional.empty();
    }

    /**
     * Napisz przypadek testowy który sprawdzi że metoda size zwróci 52 elementy
     * Nie zapmonij zmienną wilekości umieścić jako stałą klasy DeckTest
     * @return
     */
    public int size() {
        return cardDeck.size();
    }

    /**
     * Napisz 2 przypadki testowy które sprawdzą czy po utworzenie obiektu deck metoda zwraca fałsz
     * Drugi przypadek sprawdzi czy po pobraniu wszystkich kart deck jest pusty
     * @return
     */
    public boolean isDeckEmpty() {
        return cardDeck.size() == 0;
    }

    private void createDeck()
    {
        for(Rank rank: Rank.values())
        {
            for(Color color: Color.values())
            {
                cardDeck.add(new Card(rank, color));
            }
        }
    }

    private void shuffleCard() {
        Collections.shuffle(cardDeck);
    }
}
