package game.main.engine;

import game.main.engine.exceptions.NoEnoughCardToStartGame;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CroupierTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeMethod
    public void initOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void unInitOutputStream() {
        System.setOut(System.out);
    }

    @Test
    public void testAfterDealsCardPlayerHaveAllCardFromDeck() throws Exception {
        Croupier croupier = new Croupier();
        Player player1 = new Player("Maciek");
        Player player2 = new Player("Andrzej");
        croupier.dealTheCards(List.of(player1, player2));

        assertEquals(player1.cardInHand.size(), 26);
        assertEquals(player2.cardInHand.size(), 26);
    }

    @Test
    public void testDealsCardsWithOutPlayer() {
        Croupier croupier = new Croupier();


        try {
            croupier.dealTheCards(Collections.emptyList());
        } catch (Exception e) {
            assertTrue(e instanceof NoEnoughCardToStartGame);
        }
        assertEquals(outContent.toString(), "Not enough card to start play or is to low players\n");
    }

}