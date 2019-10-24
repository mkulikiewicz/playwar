package game.engine;

import game.equipment.GameTable;
import game.equipment.card.Card;
import game.players.Player;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Printer {

    private static final int NORMAL_PRINTER_TIME = 600;
    private static final int WAR_PRINTER_TIME = 1000;

    private void printGameWinner(Player x) {
        System.out.println("The winner is: " + x.getName() + " he have a " + x.getCardCount() + " cards");
    }

    public void printRoundWinner(Player winner) {
        System.out.println("Winner:" + winner);
        sleep();
    }

    public void printCardFromTable(GameTable gameTable) {
        System.out.println("On table:" + gameTable.showCardFromTable());
    }

    public void printStartWar(Set<Player> playerList) {
        System.out.println("it is WAR time!!! beetwen" + playerList);
    }

    public void printPlayerWithNotEnoughCard(Player player) {
        System.out.println(player.getName() + " don't have enough card :(");
        sleepWar(1);
    }

    public void printEndGameMessage(List<Player> playersList) {
        for (Player x : playersList) {
            if (x.getCardCount() > 0)
                printGameWinner(x);
        }

    }

    public void printCardFromTableInWar(GameTable gameTable) {
        Map<Player, Card> cardFromTable = gameTable.showCardFromTable();
        for (Map.Entry<Player, Card> entry : cardFromTable.entrySet()) {
            sleepWar(cardFromTable.size());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sleepWar(cardFromTable.size());
    }

    private void sleepWar(int warTime) {
        try {
            Thread.sleep(warTime * WAR_PRINTER_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(Printer.NORMAL_PRINTER_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void noWinner(Player playerWithHaveTakenCard) {
        System.out.println("It wasn't winner player in this round :( all card will be taken by " + playerWithHaveTakenCard);
    }

    public void printInCorrectArgument(NumberFormatException e) {
        System.out.println("Argument wasn't correct " + e.getMessage() + " we use default value {5}");
    }

    public void printNotEnoughCardToStartGame() {
        System.out.println("Not enough card to start play or is to low players");
    }

    public void showPlayerStats(List<Player> playerList) {
        System.out.print("\t".repeat(25) + "Stats:");
        for (Player player : playerList) {
            if (player.getCardCount() > 0)
                System.out.print(" " + player.getName() + "[" + player.getCardCount() + "]");
        }
        System.out.println("\n");
    }
}
