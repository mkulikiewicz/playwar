package game.main;

import game.main.players.GameMaster;
import game.main.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private static Printer printer = new Printer();

    public static void main(String[] args) throws Exception {
        int playerCount = new ArgsChecker().trySignArgs(args); // default value 5
//        Croupier croupier = new Croupier();
//        croupier.createPlayers(2);
//
//


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
                Player playerWhichHaveTakenCard = gameMaster.giveCardFromTableToGraterPlayer(gameTable, playerList);
                printer.noWinner(playerWhichHaveTakenCard);
            }
        }

        printer.printEndGameMessage(playersList);
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
            } catch (Exception e) {
                printer.printPlayerWithNotEnoughCard(player);
            }
        }

        printer.printCardFromTableInWar(gameTable);

        if (gameTable.isWar())
            startWar(gameTable);
    }

    public static List<Player> addPlayers(String[] args) {
        int playerCount  = new ArgsChecker().trySignArgs(args);
        List<Player> playersList = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            playersList.add(new Player(String.format("Player{%d}", i)));
        }
        return playersList;
    }
}
