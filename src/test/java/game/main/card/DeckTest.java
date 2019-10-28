package game.main.card;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void testGetCardReturnCard() {
        //Given
        Deck deck = new Deck();
        //When
        Optional<Card> card = deck.getCard();
        //Then
        assertThat(card.isPresent()).isTrue();
        assertThat(card.get()).isInstanceOf(Card.class);
    }

    @Test
    public void testGetCardReturnOtherCard() {
        //Given
        Deck deck = new Deck();
        //When
        Queue<Card> cardFromDeck = new LinkedList<>(getCardFromDeck(deck));
        //Then
        assertThat(cardFromDeck).hasOnlyElementsOfType(Card.class);
        for (int i = 0; i < cardFromDeck.size(); ) {
            Card getCard = cardFromDeck.remove();
            assertThat(cardFromDeck).doesNotContain(getCard);
        }
    }

    @Test
    public void testIsDeckEmptyReturnTrue() {
        //Given
        Deck deck = new Deck();
        //When
        boolean isDeckEmpty = deck.isDeckEmpty();
        //Then
        assertThat(isDeckEmpty).isFalse();
    }

    @Test
    public void testIsDeckEmptyAfterGettingAllCard() {
        //Given
        Deck deck = new Deck();
        //When
        getCardFromDeck(deck);
        boolean isDeckEmpty = deck.isDeckEmpty();
        //Then
        assertThat(isDeckEmpty).isTrue();
    }

    @Test
    public void testSizeReturnDefaultSize() {
        //Given
        Deck deck = new Deck();
        //When
        int deckSize = deck.size();
        int deckSizeAfterGetAllCard = getCardFromDeck(deck).size();
        //Then
        assertThat(deckSize).isEqualTo(deckSizeAfterGetAllCard);
    }

    @Test
    public void testSizeReturnPositiveNumber() {
        //Given
        Deck deck = new Deck();
        //When
        int deckSize = deck.size();
        //Then
        assertThat(deckSize).isGreaterThan(0);
    }

    private List<Card> getCardFromDeck(Deck deck) {
        List<Card> temp = new LinkedList<>();
        Optional<Card> optionalCard = deck.getCard();
        while (optionalCard.isPresent()) {
            temp.add(optionalCard.get());
            optionalCard = deck.getCard();
        }
        return temp;
    }
}