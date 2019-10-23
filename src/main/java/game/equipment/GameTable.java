package game.equipment;

import game.equipment.card.Card;
import game.players.Player;

import java.util.*;
import java.util.stream.Stream;

public class GameTable {


    private Map<Player, Card> cardAndPlayersInTable = new HashMap<>();
    private Map<Player, Card> cardAndPlayersContainerInTable = new HashMap<>();

    public void putCard(Player player, Card card) {
        cardAndPlayersInTable.put(player, card);
    }

    public Player checkWiningCard() {
        Map.Entry<Player, Card> winnerEntry = null;
        for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
            if (winnerEntry == null || entry.getValue().biggerRankThen(winnerEntry.getValue())) {
                winnerEntry = entry;
            }
        }
        assert winnerEntry != null;
        return winnerEntry.getKey();
    }

    public Collection<Card> getCardFromTable() {
        Map<Player, Card> temp = new HashMap<>();
        temp.putAll(cardAndPlayersInTable);
        temp.putAll(cardAndPlayersContainerInTable);
        cardAndPlayersInTable.clear();
        cardAndPlayersContainerInTable.clear();
        return temp.values();
    }


    public void showPlayersWithCardsInTable() {
        if (cardAndPlayersInTable.size() > 0) {
            for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
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
        Card winningCard = getWiningCard();
        Set<Player> winningPlayer = new HashSet<Player>();
        for (Map.Entry<Player, Card> entry : cardAndPlayersInTable.entrySet()) {
            if (entry.getValue().equalsRank(getWiningCard())) {
                winningPlayer.add(entry.getKey());
            }
        }
        return winningPlayer;
    }

    public void addCardToContainer() {
        cardAndPlayersContainerInTable.putAll(cardAndPlayersInTable);
        cardAndPlayersInTable.clear();
    }

    public void putCardToContainer(Player player, Card card) {
        cardAndPlayersContainerInTable.put(player, card);
    }
}
