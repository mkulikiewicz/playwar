package game.players;

import game.engine.exception.NoEnoughCardException;
import game.equipment.GameTable;
import game.equipment.card.Card;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends Human {


    private Queue<Card> cardInHand = new LinkedList<>();

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

    public void putCardToTable(GameTable gameTable) {
        gameTable.putCard(this, cardInHand.remove());
    }

    public String toString() {
        return getName();
    }

    public void putCardToTableContainer(GameTable gameTable) throws NoEnoughCardException {
        if (isPlayerHaveCard()) {
            gameTable.putCardToContainer(cardInHand.element());
        } else
            throw new NoEnoughCardException();
    }

    public void getCardFromTable(GameTable gameTable) {
        cardInHand.addAll(gameTable.getCardFromTable());
    }

    public int getCardCount() {
        return cardInHand.size();
    }
}
