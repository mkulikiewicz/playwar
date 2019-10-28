package game.main.card;

public enum Rank {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    KNIGHT("KNIGHT"),
    QUEEN("QUEEN"),
    KING("KING"),
    ACE("ACE");

    private String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.rank;
    }
}