package game.main.card;

import java.util.Objects;

public class Card {
    private Color color;
    private Rank rank;

    public Card(Rank value, Color color) {
        this.rank = value;
        this.color = color;
    }

    public String toString() {
        return rank + "" + color;
    }

    public boolean biggerRankThen(Card card) {
        return this.rank.ordinal() > card.rank.ordinal();
    }

    public boolean equalsRank(Card card) {
        return this.rank.ordinal() == card.rank.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (Objects.nonNull(obj) && obj instanceof Card) {
            if (((Card) obj).color == color && ((Card) obj).rank == rank)
                return true;
        }
        return false;
    }
}
