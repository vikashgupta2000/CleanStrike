package model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class CarromBoardTest {

    @Test
    public void testAddingCoin() {
        CarromBoard carromBoard = new CarromBoard(new Coin(0, 1), new Coin(1, 5));
        Assert.assertFalse(carromBoard.coinsPresent(CoinType.BLACK));
        carromBoard.addCoin(2, CoinType.BLACK);
        Assert.assertTrue(carromBoard.coinsPresent(CoinType.BLACK));
    }

    @Test
    public void testRemovingCoin() {
        CarromBoard carromBoard = new CarromBoard(new Coin(0, 1), new Coin(1, 5));
        Assert.assertTrue(carromBoard.coinsPresent(CoinType.RED));
        carromBoard.removeCoin(CoinType.RED);
        Assert.assertFalse(carromBoard.coinsPresent(CoinType.RED));
    }

    @Test
    public void testIsThereAnyCoinOnBoard() {
        CarromBoard carromBoard = new CarromBoard(new Coin(1, 1), new Coin(1, 5));
        Assert.assertTrue(carromBoard.coinsPresent(CoinType.BLACK));
        Assert.assertTrue(carromBoard.coinsPresent(CoinType.RED));

        carromBoard.removeCoin(CoinType.BLACK);
        Assert.assertTrue(carromBoard.anyCoinOnBoard());

        carromBoard.removeCoin(CoinType.RED);
        Assert.assertFalse(carromBoard.anyCoinOnBoard());
    }
}
