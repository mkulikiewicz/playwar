package game.main.players;

import game.main.GameTable;
import game.main.card.Card;
import game.main.exceptions.GameException;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Player extends Human {


    Queue<Card> cardInHand = new LinkedList<>();

    public Player(String name) {
        super(name);
    }

    public void takeCardToHand(Card card) {
        cardInHand.add(card);
    }

    public boolean isPlayerHaveCard() {
        return cardInHand.size() > 0;
    }

    public Queue<Card> getPlayerAllCard() {
        return cardInHand;
    }

    public void putCardToTable(GameTable gameTable) throws Exception {
        if (isPlayerHaveCard()) {
            gameTable.putCard(this, cardInHand.remove());
        } else
            throw GameException.noEnoughCardException();
    }

    public String toString() {
        return getName();
    }

    public void putCardToTableContainer(GameTable gameTable) throws Exception {
        if (isPlayerHaveCard()) {
            gameTable.putCardToContainer(cardInHand.remove());
        } else
            throw GameException.noEnoughCardException();
    }

    public void getCardFromTable(GameTable gameTable) {
        cardInHand.addAll(gameTable.getCardFromTable());
    }

    public int getCardCount() {
        return cardInHand.size();
    }


    @Override
    public boolean equals(Object obj) {
        if (Objects.nonNull(obj) && obj instanceof Player) {
            return ((Player) obj).getName().equals(this.getName()) && ((Player) obj).getPlayerAllCard().containsAll(this.getPlayerAllCard());
        }
        return false;
    }
}
