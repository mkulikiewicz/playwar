package game.main;

import game.main.engine.Game;
import game.main.engine.GameBuilder;

public class MainGame {

    public static void main(String[] args) throws Exception {
        Game game = new GameBuilder().addPlayers(args).build();
        game.start();
    }
}
