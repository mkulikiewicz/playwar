package game.equipment;

import game.equipment.card.Card;
import game.equipment.card.Color;
import game.equipment.card.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private List<Card> cardDeck = new ArrayList<>();

    public Deck() {
        cardDeck.add(new Card(Rank.ACE, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.ACE, Color.CLUBS));
        cardDeck.add(new Card(Rank.ACE, Color.HEARTS));
        cardDeck.add(new Card(Rank.ACE, Color.SPADES));
        cardDeck.add(new Card(Rank.KING, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.KING, Color.CLUBS));
        cardDeck.add(new Card(Rank.KING, Color.HEARTS));
        cardDeck.add(new Card(Rank.KING, Color.SPADES));
        cardDeck.add(new Card(Rank.QUEEN, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.QUEEN, Color.CLUBS));
        cardDeck.add(new Card(Rank.QUEEN, Color.HEARTS));
        cardDeck.add(new Card(Rank.QUEEN, Color.SPADES));
        cardDeck.add(new Card(Rank.KNIGHT, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.KNIGHT, Color.CLUBS));
        cardDeck.add(new Card(Rank.KNIGHT, Color.HEARTS));
        cardDeck.add(new Card(Rank.KNIGHT, Color.SPADES));
        cardDeck.add(new Card(Rank.TEN, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.TEN, Color.CLUBS));
        cardDeck.add(new Card(Rank.TEN, Color.HEARTS));
        cardDeck.add(new Card(Rank.TEN, Color.SPADES));
        cardDeck.add(new Card(Rank.NINE, Color.DIAMONDS));
        cardDeck.add(new Card(Rank.NINE, Color.CLUBS));
        cardDeck.add(new Card(Rank.NINE, Color.HEARTS));
        cardDeck.add(new Card(Rank.NINE, Color.SPADES));
        shuffleCard();
    }

    public Optional<Card> getCard() {
        Optional<Card> cardToReturn = cardDeck.stream().findAny();
        if (cardToReturn.isPresent()) {
            cardDeck.remove(cardToReturn.get());
            return cardToReturn;
        }
        return Optional.empty();
    }

    private void shuffleCard() {
        List<Card> deckAfterShuffle = new ArrayList<>();
        while (cardDeck.size() != 0) {
            long random = ThreadLocalRandom.current().nextLong(cardDeck.size() + deckAfterShuffle.size());
            Optional<Card> cardAfterShuffle = cardDeck.stream().skip(random).findFirst();
            if (cardAfterShuffle.isPresent()) {
                Card card = cardAfterShuffle.get();
                deckAfterShuffle.add(card);
                cardDeck.remove(card);
            }
        }
        cardDeck = deckAfterShuffle;
    }

    private List<Card> getDeck() {
        return cardDeck;
    }

    public boolean isDeckEmpty() {
        return getDeck().size() == 0;
    }
}
