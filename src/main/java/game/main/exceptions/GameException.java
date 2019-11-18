package game.main.exceptions;

public final class GameException {
    public static NoEnoughCardException noEnoughCardException() {
        return new NoEnoughCardException();
    }

    public static NoWinnerException noWinnerException() {
        return new NoWinnerException();
    }
}
