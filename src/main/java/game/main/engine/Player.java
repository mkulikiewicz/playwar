package game.main.engine;

import game.main.engine.card.CardInterface;
import game.main.engine.exceptions.GameException;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Napisz klasę testową PlayeTest
 */
class Player {


    Queue<CardInterface> cardInHand = new LinkedList<>();
    private String name;

    Player(String name) {
        this.name = name;
    }

    /**
     * Napisz Przypadek testowy który sprawdzić czy gracz po wzięciu karty posiada kartę w ręku oraz czy ta karta jest dokładnie tą kartą którą pobrał :)
     * Możesz posłużyć się klasą testową z paczki card i w niej udostępnić odpowiedni zestaw card.
     * @param card
     */
    void takeCardToHand(CardInterface card) {
        cardInHand.add(card);
    }

    /**
     * Napisz 2 przypadki testowe sprawdzające czy jeżeli gracz nie ma kart to metoda zwróci false oraz jeżeli gracz posiada karty metoda zwróci prawdę
     * @return
     */
    boolean isPlayerHaveCard() {
        return cardInHand.size() > 0;
    }

    /**
     * Napisz przypadek testów w którym sprawdzisz czy po wzięciu przez gracza kilku kart karty istnieją w jego ręce.
     * @return
     */
    Queue<CardInterface> getPlayerAllCard() {
        return cardInHand;
    }

    /**
     * Napisz 2 przypadek testowy który sprawdzi że jeżeli gracz położy kartę na stole to gracz nie ma już tej karty na ręce a karta znajduje się na stole
     * Dodatkowo nie zapomnij o zweryfikowaniu sytuacji w której gracz nie ma już kart w ręce użyj exceptedException
     * @param gameTable
     * @throws Exception
     */
    void putCardToTable(GameTable gameTable) throws Exception {
        if (isPlayerHaveCard()) {
            gameTable.putCard(this, cardInHand.remove());
        } else
            throw GameException.noEnoughCardException();
    }

    /**
     * Napisz przypadek testowy w którym sprawdzisz że metoda toString zwraca imię gracza
     * Możesz posłużyć się @DataProvider'em
     * @return
     */
    public String toString() {
        return name;
    }

    /**
     * Napisz 2 przypadek testowy który sprawdzi że jeżeli gracz położy kartę do konteneru na stole to gracz nie ma już tej karty na ręce a karta znajduje się na w kontenerze
     * Dodatkowo nie zapomnij o zweryfikowaniu sytuacji w której gracz nie ma już kart w ręce użyj exceptedException
     * @param gameTable
     * @throws Exception
     */
    void putCardToTableContainer(GameTable gameTable) throws Exception {
        if (isPlayerHaveCard()) {
            gameTable.putCardToContainer(cardInHand.remove());
        } else
            throw GameException.noEnoughCardException();
    }

    /**
     * Napisz przypadek testowy w którym sprawdzisz że wszystkie karty ze stołu po wykonaniu metody lądują w ręce gracz
     * Nie zapomnij że stół posiada 2 zbiory kart ( znajdujące się na nim oraz te w tzw. kontenerze wykorzystywanym do wojny)
     * @param gameTable
     */
    void getCardFromTable(GameTable gameTable) {
        cardInHand.addAll(gameTable.getCardFromTable());
    }

    /**
     * Napisz przypadek testowy w którym sprawdzisz że metoda poprawnie zwraca wielkość ręki gracza
     * Możesz posłużyć się @DataProvider'em aby sprawdzić kilka takich przypadków
     * @return
     */
    int getCardCount() {
        return cardInHand.size();
    }

    /**
     * Napisz 2 przypadki testowe sprawdzające że dwaj gracze o tej samym imieniu i tych samych kartach są tacy sami
     * Sprawdź również że gracze o tym samym imieniu a różnych kartach na ręce nie sa sobie równi
     * Wykorzystaj @DataProvider'a
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (Objects.nonNull(obj) && obj instanceof Player) {
            return ((Player) obj).name.equals(this.name) && ((Player) obj).getPlayerAllCard().containsAll(this.getPlayerAllCard());
        }
        return false;
    }
}
