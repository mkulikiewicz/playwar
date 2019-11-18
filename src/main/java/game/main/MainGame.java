package game.main;

public class MainGame {

    public static void main(String[] args) {
        Game game = new Game()
        game.addPlayers(args);
        game.start();
    }
}
