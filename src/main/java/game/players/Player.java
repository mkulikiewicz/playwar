package game.players;

import game.engine.exception.NoEnoughCardException;
import game.equipment.GameTable;
import game.equipment.card.Card;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Player extends Human {


    Queue<Card> cardInHand = new LinkedList<>();

    public Player(String name) {
        super(name);
    }

    void takeCardToHand(Card card) {
        cardInHand.add(card);
    }

    public boolean isPlayerHaveCard() {
        return cardInHand.size() > 0;
    }

    Queue<Card> getPlayerAllCard() {
        return cardInHand;
    }

    public void putCardToTable(GameTable gameTable) throws NoEnoughCardException {
        if(isPlayerHaveCard()) {
            gameTable.putCard(this, cardInHand.remove());
        }else
            throw new NoEnoughCardException();
    }

    public String toString() {
        return getName();
    }

    public void putCardToTableContainer(GameTable gameTable) throws NoEnoughCardException {
        if (isPlayerHaveCard()) {
            gameTable.putCardToContainer(cardInHand.remove());
        } else
            throw new NoEnoughCardException();
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
            if (((Player) obj).getName().equals(this.getName()) && ((Player) obj).getPlayerAllCard().containsAll(this.getPlayerAllCard()))
                return true;
        }
        return false;
    }
}
