package game.main.card;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CardTest {

    @Test
    public void testToStringMethod() {
//        Given
        Card card = new Card(Rank.ACE, Color.DIAMONDS);
//        When
        String cardToString = card.toString();
//        Then
        assertEquals(card.toString(), "ACE♦");
    }

    @Test
    public void testBiggerRankThenMethodWithTwoSameRankCard() {
//        Given
        Card firstCard = new Card(Rank.TEN, Color.DIAMONDS);
        Card secondCard = new Card(Rank.TEN, Color.CLUBS);
//        When
        boolean isBiggerRankThen = firstCard.biggerRankThen(secondCard);
//        Then
        assertFalse(isBiggerRankThen);
    }

    @Test
    public void testBiggerRankThenMethodWithTwoOtherRankCard() {
//        Given
        Card firstCard = new Card(Rank.ACE, Color.DIAMONDS);
        Card secondCard = new Card(Rank.KING, Color.CLUBS);
//        When
        boolean isBiggerRankThen = firstCard.biggerRankThen(secondCard);
//        Then
        assertTrue(isBiggerRankThen);
    }

    @Test
    public void testEqualsRankWithTwoSameRank() {
//        Given
        Card firstCard = new Card(Rank.NINE, Color.DIAMONDS);
        Card secondCard = new Card(Rank.NINE, Color.CLUBS);
//        When
        boolean isEqualRank = firstCard.equalsRank(secondCard);
//        Then
        assertTrue(isEqualRank);
    }

    @Test
    public void testEqualsRankWithOtherRank() {
//        Given
        Card firstCard = new Card(Rank.KNIGHT, Color.DIAMONDS);
        Card secondCard = new Card(Rank.QUEEN, Color.CLUBS);
//        When
        boolean isEqualRank = firstCard.equalsRank(secondCard);
//        Then
        assertFalse(isEqualRank);
    }

    @Test
    public void testEqualsSameCard() {
//        Given
        Card firstCard = new Card(Rank.TEN, Color.SPADES);
        Card secondCard = new Card(Rank.TEN, Color.SPADES);
//        When
        boolean cardsAreEqual = firstCard.equals(secondCard);
//        Then
        assertTrue(cardsAreEqual);
    }

    @Test
    public void testEqualsDifferentCard() {
//        Given
        Card firstCard = new Card(Rank.TEN, Color.SPADES);
        Card secondCard = new Card(Rank.TEN, Color.HEARTS);
//        When
        boolean cardsAreEqual = firstCard.equals(secondCard);
//        Then
        assertFalse(cardsAreEqual);
    }

}