package game.main.engine;

import game.main.engine.card.CardInterface;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Utwórz klasę testową Printer
 */
final class Printer {

    private static final int NORMAL_PRINTER_TIME = 300;
    private static final int WAR_PRINTER_TIME = 1;

    private void printGameWinner(Player x) {
        System.out.println("The winner is: " + x + " he have a " + x.getCardCount() + " cards");
    }

    /**
     * Napisz przypadek testowy że metoda wyświetl odpowiednie znaki
     * Nie zapomnij o sprawdzeniu odstępu czasowego ;)
     * @param winner
     */
    void printRoundWinner(Player winner) {
        System.out.println("Winner:" + winner);
        sleep();
    }

    /**
     * Napisz przypadek testowy że metoda wyświetla odowiednie znaki
     * @param gameTable
     */
    void printCardFromTable(GameTable gameTable) {
        System.out.println("On table:" + gameTable.showCardFromTable());
    }

    /**
     * Napisz przypadek testowy że metoda wyświetla odowiednie znaki
     * @param playerList
     */
    void printStartWar(Set<Player> playerList) {
        System.out.println("it is WAR time!!! beetwen" + playerList);
    }


    /**
     * Napisz przypadek testowy że metoda wyświetla odowiednie znaki
     * @param player
     */
    void printPlayerWithNotEnoughCard(Player player) {
        System.out.println(player + " don't have enough card :(");
        sleepWar(1);
    }


    /**
     * Napisz przypadek testowy że metoda wyświetla odowiednie znaki
     * @param playersList
     */
    void printEndGameMessage(List<Player> playersList) {
        for (Player x : playersList) {
            if (x.getCardCount() > 0)
                printGameWinner(x);
        }

    }


    /**
     * Napisz przypadek testowy że metoda wyświetla odowiednie znaki
     * @param gameTable
     */
    void printCardFromTableInWar(GameTable gameTable) {
        Map<Player, CardInterface> cardFromTable = gameTable.showCardFromTable();
        for (Map.Entry<Player, CardInterface> entry : cardFromTable.entrySet()) {
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

    void noWinner(Player playerWithHaveTakenCard) {
        System.out.println("It wasn't winner player in this round :( all card will be taken by " + playerWithHaveTakenCard);
    }

    void printInCorrectArgument(NumberFormatException e) {
        System.out.println("Argument wasn't correct " + e.getMessage() + " we use default value {5}");
    }

    static void printNotEnoughCardToStartGame() {
        System.out.println("Not enough card to start play or is to low players");
    }

    void showPlayerStats(List<Player> playerList) {
        System.out.print("\t".repeat(25) + "Stats:");
        for (Player player : playerList) {
            if (player.getCardCount() > 0)
                System.out.print(" " + player + "[" + player.getCardCount() + "]");
        }
        System.out.println("\n");
    }
}
