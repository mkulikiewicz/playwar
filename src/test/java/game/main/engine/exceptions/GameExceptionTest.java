package game.main.engine.exceptions;

import org.testng.annotations.Test;

public class GameExceptionTest {

    @Test(expectedExceptions = NoEnoughCardException.class)
    public void testGetNoEnoughCardException() throws Exception {
        throw GameException.noEnoughCardException();
    }

    @Test(expectedExceptions = NoWinnerException.class)
    public void testGetNoWinnerException() throws Exception {
        throw GameException.noWinnerException();
    }
}