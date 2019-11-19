package game.main.engine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTableTest {
//
//    private Player firstTestPlayer;
//    private Player secondTestPlayer;
//    private GameTable gameTable;
//
//    @BeforeMethod
//    private void initData() {
//        gameTable = new GameTable();
//        firstTestPlayer = new Player("TestPlayer1");
//        secondTestPlayer = new Player("TestPlayer2");
//    }
//
//    @DataProvider
//    private Object[][] sameRankCardTemplate() {
//        return new Object[][]{
//                {new Card(Rank.ACE, Color.SPADES), new Card(Rank.ACE, Color.HEARTS)},
//                {new Card(Rank.KING, Color.CLUBS), new Card(Rank.KING, Color.SPADES)},
//                {new Card(Rank.QUEEN, Color.SPADES), new Card(Rank.QUEEN, Color.DIAMONDS)},
//                {new Card(Rank.KNIGHT, Color.CLUBS), new Card(Rank.KNIGHT, Color.HEARTS)},
//                {new Card(Rank.TEN, Color.DIAMONDS), new Card(Rank.TEN, Color.SPADES)},
//                {new Card(Rank.NINE, Color.DIAMONDS), new Card(Rank.NINE, Color.CLUBS)},};
//    }
//
//    @DataProvider
//    private Object[][] differentRankCardTemplate() {
//        return new Object[][]{
//                {new Card(Rank.ACE, Color.SPADES), new Card(Rank.KING, Color.HEARTS)},
//                {new Card(Rank.KING, Color.CLUBS), new Card(Rank.QUEEN, Color.SPADES)},
//                {new Card(Rank.QUEEN, Color.SPADES), new Card(Rank.KNIGHT, Color.DIAMONDS)},
//                {new Card(Rank.KNIGHT, Color.CLUBS), new Card(Rank.TEN, Color.HEARTS)},
//                {new Card(Rank.TEN, Color.DIAMONDS), new Card(Rank.NINE, Color.SPADES)},
//                {new Card(Rank.NINE, Color.DIAMONDS), new Card(Rank.ACE, Color.CLUBS)},};
//    }
//
//    @Test
//    private void testPutCard() {
//        //Given
//        Card testCard = new Card(Rank.ACE, Color.DIAMONDS);
//
//        //When
//        gameTable.putCard(firstTestPlayer, testCard);
//
//        //Then
//        assertThat(gameTable.cardAndPlayersInTable.size()).isEqualTo(1);
//        assertThat(gameTable.cardAndPlayersInTable).containsOnlyKeys(firstTestPlayer);
//        assertThat(gameTable.cardAndPlayersInTable).containsValues(testCard);
//    }
//
//    @Test
//    private void testGetWinnerPlayer() throws Exception {
//        //Given
//        Card firstTestCard = new Card(Rank.TEN, Color.SPADES);
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, firstTestCard);
//
//        Card secondTestCard = new Card(Rank.KING, Color.DIAMONDS);
//        gameTable.cardAndPlayersInTable.put(secondTestPlayer, secondTestCard);
//
//        //When
//        Player winner = gameTable.getWinnerPlayer();
//
//        //Then
//        assertThat(winner).isEqualTo(secondTestPlayer);
//    }
//
//    @Test
//    private void testGetWinnerPlayerThrowsException() {
//        //Given
//        Exception temp = new Exception();
//        gameTable.cardAndPlayersContainerInTable.add(new Card(Rank.ACE, Color.DIAMONDS));
//        //When
//        try {
//            gameTable.getWinnerPlayer();
//        } catch (Exception e) {
//            temp = e;
//        }
//        //Then
//        assertThat(temp).isInstanceOf(Exception.class);
//    }
//
//    @Test
//    private void testGetCardFromTable() {
//        //Given
//        Card cardInContainer = new Card(Rank.KING, Color.HEARTS);
//        Card cardInTable = new Card(Rank.ACE, Color.DIAMONDS);
//        gameTable.cardAndPlayersContainerInTable.add(cardInContainer);
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, cardInTable);
//        //When
//        Collection<Card> cardFromTable = gameTable.getCardFromTable();
//        //Then
//        assertThat(cardFromTable).containsOnly(cardInTable, cardInContainer);
//    }
//
//    @Test
//    private void testShowCardFromTable() {
//        //Given
//        Card cardInContainer = new Card(Rank.TEN, Color.SPADES);
//        Card cardInTable = new Card(Rank.ACE, Color.CLUBS);
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, cardInTable);
//        gameTable.cardAndPlayersContainerInTable.add(cardInContainer);
//        //When
//        Map<Player, Card> cardsAndPlayersFromTable = gameTable.showCardFromTable();
//        //Then
//        assertThat(cardsAndPlayersFromTable).containsOnlyKeys(firstTestPlayer);
//        assertThat(cardsAndPlayersFromTable).containsValues(cardInTable);
//        assertThat(cardsAndPlayersFromTable).isEqualTo(gameTable.cardAndPlayersInTable);
//        assertThat(cardsAndPlayersFromTable.size()).isEqualTo(1);
//    }
//
//    @Test(dataProvider = "sameRankCardTemplate")
//    private void testIsWarReturnTrue(Card firsCard, Card secondCard) {
//        //Given
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, firsCard);
//        gameTable.cardAndPlayersInTable.put(secondTestPlayer, secondCard);
//        //When
//        boolean isWar = gameTable.isWar();
//        //Then
//        assertThat(isWar).isTrue();
//    }
//
//    @Test(dataProvider = "differentRankCardTemplate")
//    private void testIsWarReturnFalse(Card firsCard, Card secondCard) {
//        //Given
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, firsCard);
//        gameTable.cardAndPlayersInTable.put(secondTestPlayer, secondCard);
//        //When
//        boolean isWar = gameTable.isWar();
//        //Then
//        assertThat(isWar).isFalse();
//    }
//
//    @Test
//    private void testIsWarReturnFalse() {
//        //Given
//        // Only data from @BeforeMethod
//
//        //When
//        boolean isWar = gameTable.isWar();
//        //Then
//        assertThat(isWar).isFalse();
//    }
//
//    @Test
//    private void testGetListOfWinnersPlayer() {
//        //Given
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, new Card(Rank.KING, Color.CLUBS));
//        gameTable.cardAndPlayersInTable.put(secondTestPlayer, new Card(Rank.KING, Color.DIAMONDS));
//        //When
//        Set<Player> winnersPlayers = gameTable.getListOfWinnersPlayer();
//        //Then
//        assertThat(winnersPlayers).containsOnly(firstTestPlayer, secondTestPlayer);
//    }
//
//    @Test(dataProvider = "differentRankCardTemplate")
//    private void testAddCardToContainer(Card firstCard, Card secondCard) {
//        //Given
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, firstCard);
//        gameTable.cardAndPlayersContainerInTable.add(secondCard);
//        //When
//        gameTable.addCardToContainer();
//        //Then
//        assertThat(gameTable.cardAndPlayersContainerInTable).containsOnly(firstCard, secondCard);
//        assertThat(gameTable.cardAndPlayersInTable).isEmpty();
//    }
//
//    @Test(dataProvider = "differentRankCardTemplate")
//    private void testPutCardToContainer(Card firstCard, Card secondCard) {
//        //Given
//        Card cardToContainer = new Card(Rank.ACE, Color.DIAMONDS);
//        gameTable.cardAndPlayersInTable.put(firstTestPlayer, firstCard);
//        gameTable.cardAndPlayersContainerInTable.add(secondCard);
//        //When
//        gameTable.putCardToContainer(cardToContainer);
//        //Then
//        assertThat(gameTable.cardAndPlayersContainerInTable).containsOnly(secondCard, cardToContainer);
//        assertThat(gameTable.cardAndPlayersInTable).containsOnlyKeys(firstTestPlayer);
//        assertThat(gameTable.cardAndPlayersInTable).containsValues(firstCard);
//    }
}