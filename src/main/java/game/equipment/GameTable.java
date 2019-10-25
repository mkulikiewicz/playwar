package game.equipment;

import game.engine.exception.NoWinnerException;
import game.equipment.card.Card;
import game.players.Player;

import java.util.*;

public class GameTable {


    Map<Player, Card> cardAndPlayersInTable = new HashMap<>();
    Set<Card> cardAndPlayersContainerInTable = new HashSet<>();

    public void putCard(Player player, Card card) {
        cardAndPlayersInTable.put(player, card);
    }

    public Player getWinnerPlayer() throws NoWinnerException {
        Map.Entry<Player, Card> winnerEntry = null;
        for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
            if (winnerEntry == null || entry.getValue().biggerRankThen(winnerEntry.getValue())) {
                winnerEntry = entry;
            }
        }
        if (winnerEntry == null && cardAndPlayersContainerInTable.size() > 0)
            throw new NoWinnerException();
        assert winnerEntry != null;
        return winnerEntry.getKey();
    }

    public Collection<Card> getCardFromTable() {
        Collection<Card> temp = new HashSet<>();
        temp.addAll(cardAndPlayersInTable.values());
        temp.addAll(cardAndPlayersContainerInTable);
        removeCardFromTable();
        return temp;
    }

    public Map<Player, Card> showCardFromTable() {
        return cardAndPlayersInTable;
    }


    public boolean isWar() {
        if (cardAndPlayersInTable.size() <= 0) {
            return false;
        } else {
            Card winningCard = getWiningCard();
            boolean wasOneTime = false;
            for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
                if (entry.getValue().equalsRank(winningCard) && wasOneTime)
                    return true;
                if (entry.getValue().equalsRank(winningCard)) {
                    wasOneTime = true;
                }
            }
            return false;
        }
    }

    public Set<Player> getListOfWinnersPlayer() {
        Set<Player> winningPlayer = new HashSet<>();
        for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
            if (entry.getValue().equalsRank(getWiningCard()))
                winningPlayer.add(entry.getKey());
        }
        return winningPlayer;
    }

    public void addCardToContainer() {
        cardAndPlayersContainerInTable.addAll(cardAndPlayersInTable.values());
        cardAndPlayersInTable.clear();
    }

    public void putCardToContainer(Card card) {
        cardAndPlayersContainerInTable.add(card);
    }

    private Card getWiningCard() {
        Map.Entry<Player, Card> winnerEntry = null;
        for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
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
