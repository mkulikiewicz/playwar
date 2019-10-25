package game.players;

import game.equipment.GameTable;
import game.equipment.card.Card;
import game.equipment.card.Color;
import game.equipment.card.Rank;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class GameMasterTest {

    GameMaster gameMaster;

    @BeforeMethod
    private void initData() {
        gameMaster = new GameMaster("Maciek");
    }

    @Test
    public void testDealTheCards() {
        //Given
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("TestPlayer1"));
        playerList.add(new Player("TestPlayer2"));
        playerList.add(new Player("TestPlayer3"));
        playerList.add(new Player("TestPlayer4"));
        //When
        gameMaster.dealTheCards(playerList);

        //Then
        assertThat(playerList).extracting(Player::isPlayerHaveCard).containsOnly(true);
    }

    @Test
    public void checkWinnerPlayerInTable() {
        //Given
        GameTable gameTable = new GameTable();
        Player winnerPlayer = new Player("winnerPlayer");
        gameTable.putCard(new Player("loserPlayer"), new Card(Rank.TEN, Color.DIAMONDS));
        gameTable.putCard(winnerPlayer, new Card(Rank.KING, Color.DIAMONDS));
        //When
        Optional<Player> optionalWinner = gameMaster.checkWinnerPlayerInTable(gameTable);

        assertThat(optionalWinner.isPresent()).isTrue();
        assertThat(optionalWinner.get()).isEqualTo(winnerPlayer);
    }

    @Test
    public void checkWinnerPlayerInTableIfNoWinner() {
        //Given
        GameTable gameTable = new GameTable();
        gameTable.putCardToContainer(new Card(Rank.ACE, Color.SPADES));
        //When
        Optional<Player> optionalWinner = gameMaster.checkWinnerPlayerInTable(gameTable);

        assertThat(optionalWinner.isPresent()).isFalse();
        assertThat(optionalWinner).isEqualTo(Optional.empty());
    }

    @Test
    public void isWarTimeReturnTrue() {
        //Given
        GameTable gameTable = new GameTable();
        gameTable.putCard(new Player("winnerPlayer1"), new Card(Rank.ACE, Color.DIAMONDS));
        gameTable.putCard(new Player("winnerPlayer2"), new Card(Rank.ACE, Color.HEARTS));
        //When
        boolean isWar = gameMaster.isWarTime(gameTable);
        //Then
        assertThat(isWar).isTrue();
    }

    @Test
    public void isWarTimeReturnFalse() {
        //Given
        GameTable gameTable = new GameTable();
        gameTable.putCard(new Player("winnerPlayer"), new Card(Rank.ACE, Color.SPADES));
        gameTable.putCard(new Player("loserPlayer"), new Card(Rank.KNIGHT, Color.HEARTS));
        //When
        boolean isWar = gameMaster.isWarTime(gameTable);
        //Then
        assertThat(isWar).isFalse();
    }

    @Test
    public void testGiveCardFromTableToGraterPlayer() {
        //Given
        List<Player> playersList = new ArrayList<>();
        GameTable gameTable = new GameTable();

        Player playerWithTheBiggestCardCount = new Player("TestPlayer1");
        Player secondPlayer = new Player("TestPlayer2");
        playersList.add(playerWithTheBiggestCardCount);
        playersList.add(secondPlayer);

        Card cardInHand = new Card(Rank.TEN,Color.DIAMONDS);
        Card firstCardInTable = new Card(Rank.ACE,Color.DIAMONDS);
        Card secondCardInTable = new Card(Rank.KNIGHT,Color.DIAMONDS);
        Card cardInSecondPlayerHand = new Card(Rank.KNIGHT , Color.CLUBS);

        playerWithTheBiggestCardCount.takeCardToHand(cardInHand);
        secondPlayer.takeCardToHand(cardInSecondPlayerHand);

        gameTable.putCardToContainer(firstCardInTable);
        gameTable.putCard(secondPlayer,secondCardInTable);
        //When
        Player playerWhichTakeCard = gameMaster.giveCardFromTableToGraterPlayer(gameTable,playersList);
        //Then
        assertThat(playerWithTheBiggestCardCount).isEqualTo(playerWhichTakeCard);
        assertThat(playerWithTheBiggestCardCount.getPlayerAllCard()).containsOnly(firstCardInTable,cardInHand,secondCardInTable);
    }

    @Test
    public void isEnoughCardReturnTrue()
    {
        //Given
        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player("TestPlayer1"));
        //When
        boolean isEnoughCard = gameMaster.isEnoughCard(playersList);
        //Then
        assertThat(isEnoughCard).isTrue();
    }

    @Test
    public void isEnoughCardReturnFalse()
    {
        //Given
        List<Player> playersList = new ArrayList<>();

        //When
        boolean isEnoughCard = gameMaster.isEnoughCard(playersList);
        //Then
        assertThat(isEnoughCard).isFalse();
    }


}