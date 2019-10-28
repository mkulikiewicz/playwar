package game.main.players;

import game.main.GameTable;
import game.main.card.Card;
import game.main.card.Color;
import game.main.card.Rank;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    GameTable gameTable = new GameTable();

    @Test
    public void testPutCardToTable() throws NoEnoughCardException {
        //Given
        Player player = new Player("testPlayer");
        Card card = new Card(Rank.KNIGHT, Color.CLUBS);
        player.takeCardToHand(card);
        //When
        player.putCardToTable(gameTable);
        //Then
        assertThat(gameTable.showCardFromTable()).containsOnlyKeys(player);
        assertThat(gameTable.showCardFromTable()).containsValues(card);

    }

    @Test
    public void testToString() {
        //Given
        Player player = new Player("testPlayer");
        //When
        String name = player.toString();
        //Then
        assertThat(name).isEqualTo("testPlayer");
    }

    @Test
    public void putCardToTableContainer() throws NoEnoughCardException {
        //Given
        Player player = new Player("testPlayer");
        Card card = new Card(Rank.KNIGHT, Color.CLUBS);
        player.takeCardToHand(card);
        //When
        player.putCardToTableContainer(gameTable);
        //Then
        assertThat(gameTable.getCardFromTable()).containsOnly(card);
        assertThat(player.getCardCount()).isEqualTo(0);
    }

    @Test
    public void putCardToTableContainerThrowsException() {
        //Given
        Player player = new Player("testPlayer");
        Exception temp = new Exception();
        //When
        try {
            player.putCardToTableContainer(gameTable);
        } catch (NoEnoughCardException e) {
            temp = e;
        }
        //Then
        assertThat(temp).isInstanceOf(NoEnoughCardException.class);
    }

    @Test
    public void getCardCount() {
        //Given
        Player player = new Player("testPlayer");
        Card card = new Card(Rank.KING, Color.CLUBS);
        player.takeCardToHand(card);
        //When
        int countCard = player.getCardCount();
        //Then
        assertThat(countCard).isEqualTo(1);
    }
}