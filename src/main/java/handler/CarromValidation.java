package handler;

import model.CarromBoard;
import model.CoinType;
import model.Player;

import java.util.List;
import java.util.Queue;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class CarromValidation {

    public Player hasWinner(Queue<Player> playerList) {
        List<Player> players = (List) playerList;
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        if (player1.getScore() >= 5 || player2.getScore() >= 5) {
            int scoreDiff = player1.getScore() - player2.getScore();
            if (scoreDiff >= 3) {
                return  player1;
            } else if (scoreDiff <= -3) {
                return player2;
            }
        }
        return null;
    }

    public boolean isValidInput(CarromBoard carromBoard, CoinType coinType) {
        return carromBoard.coinsPresent(coinType);
    }
}
