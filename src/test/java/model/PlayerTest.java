package model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class PlayerTest {

    @Test
    public void shouldConsiderOnlyRedCoinScoreIfNoBlackCoinIsPocketed() {
        Player player = new Player("TestPlayer");
        player.setRedCoinPocketed();
        player.calculateScore();

        Assert.assertEquals(3, player.getScore());
    }

    @Test
    public void shouldConsiderOnlyOneBlackCoinIfOneBlackCoinIsPocketedAndNoRedCoinIsPocketed() {
        Player player = new Player("TestPlayer");
        player.setBlackCoinPocketed();
        player.calculateScore();

        Assert.assertEquals(1, player.getScore());
    }

    @Test
    public void shouldConsiderMultipleBlackCoinAndNoRedCoinIsPocketed() {
        Player player = new Player("TestPlayer");
        player.setBlackCoinPocketed();
        player.setBlackCoinPocketed();
        player.setBlackCoinPocketed();
        player.calculateScore();

        Assert.assertEquals(2, player.getScore());
    }

    @Test
    public void shouldConsiderBothBlackCoinAndRedCoinScore() {
        Player player = new Player("TestPlayer");
        player.setRedCoinPocketed();
        player.setBlackCoinPocketed();
        player.setBlackCoinPocketed();
        player.calculateScore();

        Assert.assertEquals(5, player.getScore());
    }

    @Test
    public void shouldReduceOnePointIfMissesForThreeConsecutive() {
        Player player = new Player("TestPlayer");
        player.setBlackCoinPocketed();
        player.calculateScore();

        player.incrementMissedPocketCounter();
        player.incrementMissedPocketCounter();
        player.incrementMissedPocketCounter();
        player.calculateScore();

        Assert.assertEquals(0, player.getScore());
    }

    @Test
    public void shouldReduceAdditionalTwoPointIfThreeFoulsHappens() {
        Player player = new Player("TestPlayer");
        player.setRedCoinPocketed();
        player.setBlackCoinPocketed();
        player.setBlackCoinPocketed();
        player.calculateScore();

        player.foulPlay(1);
        player.foulPlay(1);
        player.foulPlay(1);
        player.calculateScore();

        Assert.assertEquals(1, player.getScore());
    }

    @Test
    public void shouldNotReduceScoreToNegative() {
        Player player = new Player("TestPlayer");
        player.foulPlay(1);
        player.foulPlay(1);
        player.foulPlay(1);
        player.calculateScore();

        Assert.assertEquals(0, player.getScore());
    }
}
