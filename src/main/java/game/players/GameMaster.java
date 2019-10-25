package game.players;

import game.engine.exception.NoWinnerException;
import game.equipment.Deck;
import game.equipment.GameTable;
import game.equipment.card.Card;

import java.util.List;
import java.util.Optional;

public class GameMaster extends Human {

    static final Deck DECK = new Deck();

    public GameMaster(String name) {
        super(name);
    }

    public void dealTheCards(List<Player> players) {
        while (!DECK.isDeckEmpty())
            for (Player player : players) {
                Optional<Card> cardOptional = DECK.getCard();
                cardOptional.ifPresent(player::takeCardToHand);
            }
    }

    public Optional<Player> checkWinnerPlayerInTable(GameTable gameTable) {
        try {
            return Optional.of(gameTable.getWinnerPlayer());
        } catch (NoWinnerException e) {
            return Optional.empty();
        }
    }

    public boolean isWarTime(GameTable gameTable) {
        return gameTable.isWar();
    }

    public Player giveCardFromTableToGraterPlayer(GameTable gameTable, List<Player> playerList) {
        int maxSizeOfCardInHand = -1;
        for (Player player : playerList) {
            if (player.getPlayerAllCard().size() > 0) {
                maxSizeOfCardInHand = Math.max(maxSizeOfCardInHand, player.getPlayerAllCard().size());
            }
        }
        for (Player player : playerList) {
            if (player.getPlayerAllCard().size() == maxSizeOfCardInHand) {
                player.getCardFromTable(gameTable);
                return player;
            }
        }
        return null;
    }

    public boolean isEnoughCard(List<Player> playersList) {
        return playersList.size() < DECK.size() && playersList.size() > 0;
    }
}


