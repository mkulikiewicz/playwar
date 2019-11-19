package game.main.engine;

import game.main.engine.Player;
import game.main.engine.card.CardInterface;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

//    GameTable gameTable = new GameTable();
//
//    @Test
//    public void testPutCardToTable() throws Exception {
//        //Given
//        Player player = new Player("testPlayer");
//        CardInterface card = new Card(Rank.KNIGHT, Color.CLUBS);
//        player.takeCardToHand(card);
//        //When
//        player.putCardToTable(gameTable);
//        //Then
//        assertThat(gameTable.showCardFromTable()).containsOnlyKeys(player);
//        assertThat(gameTable.showCardFromTable()).containsValues(card);
//
//    }
//
//    @Test
//    public void testToString() {
//        //Given
//        Player player = new Player("testPlayer");
//        //When
//        String name = player.toString();
//        //Then
//        assertThat(name).isEqualTo("testPlayer");
//    }
//
//    @Test
//    public void putCardToTableContainer() throws Exception {
//        //Given
//        Player player = new Player("testPlayer");
//        Card card = new Card(Rank.KNIGHT, Color.CLUBS);
//        player.takeCardToHand(card);
//        //When
//        player.putCardToTableContainer(gameTable);
//        //Then
//        assertThat(gameTable.getCardFromTable()).containsOnly(card);
//        assertThat(player.getCardCount()).isEqualTo(0);
//    }
//
//    @Test(expectedExceptions = Exception.class)
//    public void putCardToTableContainerThrowsException() throws Exception {
//        //Given
//        Player player = new Player("testPlayer");
//        //When
//        player.putCardToTableContainer(gameTable);
//        //Then throw and check exception
//    }
//
//    @Test
//    public void getCardCount() {
//        //Given
//        Player player = new Player("testPlayer");
//        Card card = new Card(Rank.KING, Color.CLUBS);
//        player.takeCardToHand(card);
//        //When
//        int countCard = player.getCardCount();
//        //Then
//        assertThat(countCard).isEqualTo(1);
//    }
}