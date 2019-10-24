package game.players;

import game.equipment.GameTable;
import game.equipment.card.Card;

import java.util.LinkedList;
import java.util.NoSuchElementException;
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

    public void controlMetodeToShowCardInHenad() {
        for (Card x : cardInHand) {
            System.out.println("\t" + x);
        }
    }

    public void putCardToTable(GameTable gameTable) {
        gameTable.putCard(this, cardInHand.remove());
    }

    public String toString() {
        return getName();
    }

    public void putCardToTableContainer(GameTable gameTable) throws NoSuchElementException {
        if (isPlayerHaveCard()) {
            gameTable.putCardToContainer(cardInHand.element());
        } else {
            throw new NoSuchElementException();
        }
    }

    public void getCardFromTable(GameTable gameTable) {
        cardInHand.addAll(gameTable.getCardFromTable());
    }

    public int getCardCount()
    {
        return cardInHand.size();
    }
}
