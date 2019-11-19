package game.main.engine.card;

public interface CardInterface {
    boolean biggerRankThen(CardInterface value);

    boolean equalsRank(CardInterface winningCard);

    Rank getRank();
}
