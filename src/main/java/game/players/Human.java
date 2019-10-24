package game.players;

public abstract class Human {
    private String name;

    Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
