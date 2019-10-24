package game.equipment.card;

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


    private Rank getRank() {
        return rank;
    }

    public boolean biggerRankThen(Card card) {
        return this.getRank().ordinal() > card.getRank().ordinal();
    }

    public boolean equalsRank(Card card) {
        return this.getRank().ordinal() == card.getRank().ordinal();
    }


}
