package game.main.players;

abstract class Human {
    private String name;

    Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
