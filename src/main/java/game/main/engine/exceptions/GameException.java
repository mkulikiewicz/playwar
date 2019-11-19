package game.main.engine.exceptions;

/**
 * Utwórz klasę testową GameExceptionTest
 *
 *
 */
public class GameException {

    /**
     * Napisz przypadek testowy który sprawdzi że zwrócony wyjątek przez metodę to instancja klasy NoEnoughCardException
     * Do tego zadania posłuż się atrybutem expectedException dla adnotacji @Test
     * @return
     */
    public static NoEnoughCardException noEnoughCardException() {
        return new NoEnoughCardException();
    }

    /**
     * Napisz przypadek testowy który sprawdzi że zwrócony wyjątek przez metodę to instancja klasy NoWinnerException
     * Do tego zadania posłuż się atrybutem expectedException dla adnotacji @Test
     * @return
     */
    public static NoWinnerException noWinnerException() {
        return new NoWinnerException();
    }

    private GameException() {}

    public static Exception noEnoughCardToStartGame() {
        return new NoEnoughCardToStartGame();
    }
}
