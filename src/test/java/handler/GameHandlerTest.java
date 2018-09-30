package handler;

import model.CarromBoard;
import model.Coin;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class GameHandlerTest {

    @Test
    public void shouldReturnTrueIfCoinIsPresentOnBoard() {
        CarromBoard carromBoard = new CarromBoard(new Coin(9, 1), new Coin(1, 3));
        CarromValidation carromValidation = new CarromValidation();
        GameHandler gameHandler = new GameHandler(carromBoard, carromValidation);
        boolean actualResult = gameHandler.coinsPresentOnBoard();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void shouldReturnFalseIfNoCoinPresentOnBoard() {
        CarromBoard carromBoard = new CarromBoard(new Coin(0, 1), new Coin(0, 3));
        CarromValidation carromValidation = new CarromValidation();
        GameHandler gameHandler = new GameHandler(carromBoard, carromValidation);
        boolean actualResult = gameHandler.coinsPresentOnBoard();

        Assert.assertFalse(actualResult);
    }
}
