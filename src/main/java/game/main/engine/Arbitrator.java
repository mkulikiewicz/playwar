package game.main.engine;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utwórz klasę testową ArbitratorTest
 */
class Arbitrator {


    /**
     * Napisz  2 przypadki testowe który sprawdzi że jeżeli na stole jest zwycięsca to jego referencja jest zwracana
     * Jeżeli na stole nie ma zwycięzcy to sprawdź że zostaje zwrócony Optiona.empty();
     * @param gameTable
     * @return
     */
    Optional<Player> checkWinnerPlayerInTable(GameTable gameTable) {
        try {
            return Optional.of(gameTable.getWinnerPlayer());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Napisz 2 przypadki testowe sprawdzające że jeżeli  przy stole jest kilku graczy i mają wyłożoną kartę o tej samej randze to metoda zwróci prawdę
     * Nie zapomnij o sprawdzeniu sytuacji w której wszyscy gracze mają karty o różnych rangach
     * @param gameTable
     * @return
     */
    boolean isWarTime(GameTable gameTable) {
        return gameTable.isWar();
    }

    /**
     * Napisz przypadek testowy że jeżeli przy stole znajdują się graczę to sprawdz który gracz z listy ma największą ilość kart i to jego zwróć.
     * @param gameTable
     * @param playerList
     * @return
     */
    Player giveCardFromTableToGraterPlayer(GameTable gameTable, List<Player> playerList) {
        Player biggestHandPlayer = null;
        for (Player singlePlayer : playerList) {
            if (Objects.isNull(biggestHandPlayer) && singlePlayer.getCardCount()>0)
                biggestHandPlayer = singlePlayer;
            if (singlePlayer.getCardCount() > biggestHandPlayer.getCardCount()) {
                biggestHandPlayer = singlePlayer;
            }
        }
        return biggestHandPlayer;
    }
}
