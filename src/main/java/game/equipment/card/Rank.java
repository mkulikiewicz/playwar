package game.equipment.card;

public enum Rank {
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