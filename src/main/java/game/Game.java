package game;

import game.engine.Printer;
import game.engine.exception.NoEnoughCardException;
import game.equipment.GameTable;
import game.players.GameMaster;
import game.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private static List<Player> playersList = new ArrayList<>();
    private static Printer printer = new Printer();

    public static void main(String[] args) {
        int playerCount = trySignArgs(args); // default value 5
        playersList = addPlayers(playerCount);
        GameMaster gameMaster = new GameMaster("Game master");
        GameTable gameTable = new GameTable();
        checkIsEnoughCard(gameMaster);
        gameMaster.dealTheCards(playersList);

        while (getPlayersWithAvailableCards().size() > 1) {
            List<Player> playerList = getPlayersWithAvailableCards();
            for (Player player : playerList) {
                player.putCardToTable(gameTable);
            }
            printer.printCardFromTable(gameTable);
            if (gameMaster.isWarTime(gameTable))
                startWar(gameTable);

            Optional<Player> winner = gameMaster.checkWinnerPlayerInTable(gameTable);
            if (winner.isPresent()) {
                addReward(winner.get(), gameTable);
                printer.showPlayerStats(playerList);
            } else {
                Player playerWithHaveTakenCard = gameMaster.giveCardFromTableToGraterPlayer(gameTable, playerList);
                printer.noWinner(playerWithHaveTakenCard);
            }
        }

        printer.printEndGameMessage(playersList);
        printer.printCardFromTable(gameTable);
    }

    private static int trySignArgs(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            printer.printInCorrectArgument(e);
            return 5;
        }
    }

    private static void checkIsEnoughCard(GameMaster gameMaster) {
        if (!gameMaster.isEnoughCard(playersList)) {
            printer.printNotEnoughCardToStartGame();
            System.exit(0);
        }

    }


    private static List<Player> getPlayersWithAvailableCards() {
        return playersList.stream().filter(Player::isPlayerHaveCard).collect(Collectors.toList());
    }

    private static void addReward(Player winner, GameTable gameTable) {
        printer.printRoundWinner(winner);
        winner.getCardFromTable(gameTable);
    }


    private static void startWar(GameTable gameTable) {

        Set<Player> playersList = gameTable.getListOfWinnersPlayer();
        printer.printStartWar(playersList);

        gameTable.addCardToContainer();

        for (Player player : playersList) {
            try {
                player.putCardToTableContainer(gameTable);
                player.putCardToTable(gameTable);
            } catch (NoEnoughCardException e) {
                printer.printPlayerWithNotEnoughCard(player);
            }
        }

        printer.printCardFromTableInWar(gameTable);

        if (gameTable.isWar())
            startWar(gameTable);
    }

    private static List<Player> addPlayers(int playerCount) {
        List<Player> playersList = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            playersList.add(new Player(String.format("Player{%d}", i)));
        }
        return playersList;
    }
}
