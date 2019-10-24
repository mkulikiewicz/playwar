package game.equipment;

import game.equipment.card.Card;
import game.players.Player;

import java.util.*;

public class GameTable {


    private Map<Player, Card> cardAndPlayersInTable = new HashMap<>();
    private Set<Card> cardAndPlayersContainerInTable = new HashSet<Card>();

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
        Collection<Card> temp = new HashSet<>();
        temp.addAll(cardAndPlayersInTable.values());
        temp.addAll(cardAndPlayersContainerInTable);
        cardAndPlayersInTable.clear();
        cardAndPlayersContainerInTable.clear();
        return temp;
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
        cardAndPlayersContainerInTable.addAll(cardAndPlayersInTable.values());
        cardAndPlayersInTable.clear();
    }

    public void putCardToContainer(Card card) {
        cardAndPlayersContainerInTable.add(card);
    }
}
