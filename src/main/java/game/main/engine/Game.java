package game.main.engine;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Game implements  GameInterface{
    private Printer printer = new Printer();
    private List<Player> playersList;
    private Arbitrator arbitrator = new Arbitrator();
    private GameTable gameTable = new GameTable();

    Game(List<Player> playersList) {
        this.playersList = playersList;
    }

    public void start() throws Exception {
        while (getPlayersWithAvailableCards().size() > 1) {
            List<Player> playerList = getPlayersWithAvailableCards();
            for (Player player : playerList) {
                player.putCardToTable(gameTable);
            }
            printer.printCardFromTable(gameTable);
            if (arbitrator.isWarTime(gameTable))
                startWar(gameTable);

            Optional<Player> winner = arbitrator.checkWinnerPlayerInTable(gameTable);
            if (winner.isPresent()) {
                addReward(winner.get(), gameTable);
                printer.showPlayerStats(playerList);
            } else {
                Player playerWhichHaveTakenCard = arbitrator.giveCardFromTableToGraterPlayer(gameTable, playerList);
                printer.noWinner(playerWhichHaveTakenCard);
            }
        }

        printer.printEndGameMessage(playersList);
    }

    private List<Player> getPlayersWithAvailableCards() {
        return playersList.stream().filter(Player::isPlayerHaveCard).collect(Collectors.toList());
    }

    private void addReward(Player winner, GameTable gameTable) {
        printer.printRoundWinner(winner);
        winner.getCardFromTable(gameTable);
    }


    private void startWar(GameTable gameTable) {

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
}
