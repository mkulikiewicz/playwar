package game.main;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GameTest {

    @Test
    public void testGameStart()
    {
        Game game = new Game();
        assertTrue(game.start());


    }
}
