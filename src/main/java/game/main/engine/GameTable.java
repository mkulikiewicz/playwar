package game.main.engine;

import game.main.engine.card.CardInterface;
import game.main.engine.exceptions.GameException;

import java.util.*;

/**
 * Utwórz Klasę GameTableTest
 */
class GameTable {

    Map<Player, CardInterface> cardAndPlayersInTable = new HashMap<>();
    Set<CardInterface> cardAndPlayersContainerInTable = new HashSet<>();

    /**
     * Napisz przypadek testowy który sprawdzi że po dodaniu kart do stołu kolekcja cardAndPlayersInTable zawiera odpowiednią parę kluczy Gracz, Karta
     *
     * @param player
     * @param card
     */
    void putCard(Player player, CardInterface card) {
        cardAndPlayersInTable.put(player, card);
    }

    /**
     * Napisz 2 przypadek testowy który sprawdzi że gdy mamy pustą listę graczy to rzucany jest wyjątek
     * kolejny przypadek sprawdzi czy jeżeli posiadamy graczy to czy metoda zwraca gracza z najwyższą kartą
     *
     * @return
     * @throws Exception
     */
    Player getWinnerPlayer() throws Exception {
        Map.Entry<Player, CardInterface> winnerEntry = null;
        for (Map.Entry<Player, CardInterface> entry : cardAndPlayersInTable.entrySet()) {
            if (winnerEntry == null || entry.getValue().biggerRankThen(winnerEntry.getValue())) {
                winnerEntry = entry;
            }
        }
        if (winnerEntry == null && cardAndPlayersContainerInTable.size() > 0)
            throw GameException.noWinnerException();
        assert winnerEntry != null;
        return winnerEntry.getKey();
    }

    /**
     * Napisz przypadek testowy który sprawdzi że po pobraniu kart ze stoły stół jest już pusty
     * Nie zapomnij o wypełnieniu kontenera na stole
     *
     * @return
     */
    Collection<CardInterface> getCardFromTable() {
        Collection<CardInterface> temp = new HashSet<>();
        temp.addAll(cardAndPlayersInTable.values());
        temp.addAll(cardAndPlayersContainerInTable);
        removeCardFromTable();
        return temp;
    }

    /**
     * Napisz przypadek testowy który sprawdzi że metoda zwraci mapę gracz->karta
     *
     * @return
     */
    Map<Player, CardInterface> showCardFromTable() {
        return cardAndPlayersInTable;
    }


    /**
     * Napisz 2 przypadeki testowe które sprwadzą że podczas gry jest wojna kiedy na stole znajdują się karty o tej samej randze
     * Oczywiście pamiętaj o sprawdzeniu co jeżeli na stole nie ma wojny
     *
     * @return
     */
    boolean isWar() {
        if (cardAndPlayersInTable.size() <= 0) {
            return false;
        } else {
            CardInterface winningCard = getWiningCard();
            boolean wasOneTime = false;
            for (Map.Entry<Player, CardInterface> entry : cardAndPlayersInTable.entrySet()) {
                if (entry.getValue().equalsRank(winningCard) && wasOneTime)
                    return true;
                if (entry.getValue().equalsRank(winningCard)) {
                    wasOneTime = true;
                }
            }
            return false;
        }
    }

    /**
     * Napisz przypadek testowy sprawdzający żę metoda swróci zbiór graczy którzy wygrali walkę na stole( posiadali najwyższe rangą karty)
     *
     * @return
     */
    Set<Player> getListOfWinnersPlayer() {
        Set<Player> winningPlayer = new HashSet<>();
        for (Map.Entry<Player, CardInterface> entry : cardAndPlayersInTable.entrySet()) {
            if (entry.getValue().equalsRank(getWiningCard()))
                winningPlayer.add(entry.getKey());
        }
        return winningPlayer;
    }

    /**
     * Napisz przypadek testowy który sprawdzi że po dodaniu kart do kontenera na stole karty znajdują się tam
     * Nie zapomnij zweryfikować że stół po za kontenerem nie zawiera już kart
     */
    void addCardToContainer() {
        cardAndPlayersContainerInTable.addAll(cardAndPlayersInTable.values());
        cardAndPlayersInTable.clear();
    }

    /**
     * Napisz przypadek testowy który sprawdzi że po wywołaniu metody wszystkie karta jest dodawana do kontenera
     */
    void putCardToContainer(CardInterface card) {
        cardAndPlayersContainerInTable.add(card);
    }

    private CardInterface getWiningCard() {
        Map.Entry<Player, CardInterface> winnerEntry = null;
        for (Map.Entry<Player, CardInterface> entry : cardAndPlayersInTable.entrySet()) {
            if (winnerEntry == null || entry.getValue().biggerRankThen(winnerEntry.getValue())) {
                winnerEntry = entry;
            }
        }
        assert winnerEntry != null;
        return winnerEntry.getValue();
    }

    private void removeCardFromTable() {
        cardAndPlayersInTable.clear();
        cardAndPlayersContainerInTable.clear();
    }
}
