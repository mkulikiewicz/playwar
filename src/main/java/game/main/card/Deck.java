package game.main.card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Deck {
    private List<Card> cardDeck = new LinkedList<>();

    public Deck() {
        for(Rank rank: Rank.values())
        {
            for(Color color: Color.values())
            {
                cardDeck.add(new Card(rank, color));
            }
        }
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

    public int size() {
        return cardDeck.size();
    }

    public boolean isDeckEmpty() {
        return cardDeck.size() == 0;
    }

    private void shuffleCard() {
        Collections.shuffle(cardDeck);
    }
}
