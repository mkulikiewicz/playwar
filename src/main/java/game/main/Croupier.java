package game.main;

import game.main.card.Card;
import game.main.card.Deck;
import game.main.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Croupier {

    static final Deck DECK = new Deck();

    public void dealTheCards(List<Player> players) {
        while (!DECK.isDeckEmpty())
            for (Player player : players) {
                Optional<Card> cardOptional = DECK.getCard();
                cardOptional.ifPresent(player::takeCardToHand);
            }
    }

    public boolean isEnoughCard(List<Player> playersList) {
        return playersList.size() < DECK.size() && playersList.size() > 0;
    }

    public List<Player> createPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++)
        {
            players.add(new Player("Player"));
        }
        return players;
    }

}
