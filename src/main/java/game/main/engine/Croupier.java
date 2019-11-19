package game.main.engine;

import game.main.engine.card.CardInterface;
import game.main.engine.card.Deck;
import game.main.engine.exceptions.GameException;

import java.util.List;
import java.util.Optional;

/**
 * Utwórz klasę testową CroupierTest
 */
class Croupier {

    static final Deck DECK = new Deck();

    /**
     * Utwórz 2 przypadek testowy w którym sprawdzisz czy po rozdaniu gracze mają wszystkie karty
     * sprawdź również czy jeżeli graczy jest więcej niż kart lub mniej niż 0 to czy zostaje wyświetlony poprawny komunikat ;) oraz zwrócony odpowiedni exception
     *
     * @param players
     */
    void dealTheCards(List<Player> players) throws Exception {
        checkEnoughCardsAndPlayers(players);
        while (!DECK.isDeckEmpty())
            for (Player player : players) {
                Optional<? extends CardInterface> cardOptional = DECK.getCard();
                cardOptional.ifPresent(player::takeCardToHand);
            }

    }

    private void checkEnoughCardsAndPlayers(List<Player> playersList) throws Exception {
        if (playersList.size() > DECK.size() || playersList.size() <= 0) {
            Printer.printNotEnoughCardToStartGame();
            throw GameException.noEnoughCardToStartGame();
        }
    }

}
