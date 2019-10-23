package game.players;

import game.equipment.Deck;
import game.equipment.GameTable;
import game.equipment.card.Card;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

public class GameMaster extends Human {

    private static final Deck DECK = new Deck();

    public GameMaster(String name) {
        super(name);
    }

    public void dealTheCards(List<Player> players) {
        while (!DECK.isDeckEmpty())
            for (Player player : players) {
                Optional<Card> cardOptional = DECK.getCard();
                if (cardOptional.isPresent())
                    player.takeCardToHand(cardOptional.get());
            }
    }

    public Player checkWiningCardInTable(GameTable gameTable) {
        return gameTable.checkWiningCard();
    }

    public boolean isWarTime(GameTable gameTable) {
        return gameTable.isWar();
    }
}


