package handler;

import model.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class CarromValidationTest {

    @Test
    public void shouldReturnPlayerObjectIfAWinnerIsIdentified() {
        Player player1 = new Player("TestPlayer1");
        player1.setBlackCoinPocketed();
        player1.setBlackCoinPocketed();
        player1.calculateScore();
        player1.setRedCoinPocketed();
        player1.calculateScore();

        Player player2 = new Player("TestPlayer2");

        Queue<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);

        CarromValidation carromValidation = new CarromValidation();
        Player winner = carromValidation.hasWinner(playerList);

        Assert.assertEquals(player1, winner);

    }

    @Test
    public void shouldReturnNullIfNoWinnerIsIdentifiedForMinimumScoreLessThanFive() {
        Player player1 = new Player("TestPlayer1");
        player1.setBlackCoinPocketed();
        player1.setBlackCoinPocketed();
        player1.calculateScore();
        player1.setBlackCoinPocketed();
        player1.calculateScore();

        Player player2 = new Player("TestPlayer2");

        Queue<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);

        CarromValidation carromValidation = new CarromValidation();
        Player winner = carromValidation.hasWinner(playerList);

        Assert.assertNull(winner);
    }

    @Test
    public void shouldReturnNullIfNoWinnerIsIdentifiedForDiffOfScoreIsLessThanThree() {
        Player player1 = new Player("TestPlayer1");
        player1.setBlackCoinPocketed();
        player1.setBlackCoinPocketed();
        player1.calculateScore();
        player1.setRedCoinPocketed();
        player1.calculateScore();

        Player player2 = new Player("TestPlayer2");
        player2.setBlackCoinPocketed();
        player2.setBlackCoinPocketed();
        player2.calculateScore();
        player2.setBlackCoinPocketed();
        player2.calculateScore();

        Queue<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);

        CarromValidation carromValidation = new CarromValidation();
        Player winner = carromValidation.hasWinner(playerList);

        Assert.assertNull(winner);
    }
}
