package game.main;

import game.main.engine.Game;
import game.main.engine.GameBuilder;
import org.testng.annotations.Test;

public class GameTest {

    @Test
    public void testGameStart() throws Exception {
        Game game = new GameBuilder().addPlayers(new String[]{"2"}).build();
        game.start();
    }
}
