package game.main.engine;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    private Printer printer = new Printer();
    private List<Player> playersList = new ArrayList<>();
    private Croupier croupier = new Croupier();


    public GameBuilder addPlayers(String[] args) {
        int playerCount = new ArgsChecker().trySignArgs(args);
        List<Player> playersList = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            playersList.add(new Player(String.format("Player{%d}", i)));
        }
        this.playersList.addAll(playersList);
        return this;
    }


    public Game build() throws Exception {

        croupier.dealTheCards(playersList);
        return new Game(playersList);
    }
}
