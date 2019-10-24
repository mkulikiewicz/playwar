package game;

import game.equipment.GameTable;
import game.players.GameMaster;
import game.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private static List<Player> playersList = new ArrayList<>();

    public static void main(String[] args) {

        playersList = addPlayers(Integer.parseInt(args[0]));

        GameMaster gameMaster = new GameMaster("Mistrz gry");

        GameTable gameTable = new GameTable();

        gameMaster.dealTheCards(playersList);

        while (getPlayersWithCards().size() > 1) {
            List<Player> playerList = getPlayersWithCards();
            for (Player player : playerList) {
                player.putCardToTable(gameTable);
            }
            if (gameMaster.isWarTime(gameTable))
                startWar(gameTable);
            addReward(gameMaster.checkWiningCardInTable(gameTable), gameTable);
        }

        endGameMessage(playersList);
        System.out.println("Na stole:" + gameTable.getCardFromTable());
    }

    private static void endGameMessage(List<Player> playersWithCards) {
        for (Player x : playersList) {
            if (x.getCardCount() > 0)
                System.out.println("The winner is: " + x.getName() + " he have a " + x.getCardCount() + " cards");
        }

    }


    private static List<Player> getPlayersWithCards() {
        return playersList.stream().filter(Player::isPlayerHaveCard).collect(Collectors.toList());
    }

    private static void addReward(Player winner, GameTable gameTable) {
        System.out.println("Winner:" + gameTable.checkWiningCard());
        winner.getCardFromTable(gameTable);
    }


    public static void startWar(GameTable gameTable) {
        System.out.println("it is WAR !!!");

        Set<Player> playersList = gameTable.getListOfWinnersPlayer();

        gameTable.addCardToContainer();

        for (Player player : playersList) {
            try {
                player.putCardToTableContainer(gameTable);
                player.putCardToTable(gameTable);
            } catch (NoSuchElementException e) {
                System.out.println(player.getName() + " don't have enough card :(");
            }
        }

        gameTable.showPlayersWithCardsInTable();

        if (gameTable.isWar())
            startWar(gameTable);
    }

    public static List<Player> addPlayers(int playerCount) {
        List<Player> playersList = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            playersList.add(new Player(String.format("Player{%d}", i)));
        }
        return playersList;
    }

    static void showPlayerHand(List<Player> playersList) {
        for (Player x : playersList) {
            System.out.println(x.getName());
            x.controlMetodeToShowCardInHenad();
        }

    }
}
