package game.main;

import game.main.players.Player;

import java.util.List;
import java.util.Optional;

public class Arbitrator {

    public Optional<Player> checkWinnerPlayerInTable(GameTable gameTable) {
        try {
            return Optional.of(gameTable.getWinnerPlayer());
        } catch (Exception e) {
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
}
