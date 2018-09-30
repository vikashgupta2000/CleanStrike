package service;

import handler.GameHandler;
import model.Player;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vikashgupta on 30/09/18.
 */
public abstract class CarromBoardGame {
    protected Queue<Player> playerList;
    protected GameHandler gameHandler;

    public CarromBoardGame(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }
    public void startGame(int playerCount) {
        playerList = new LinkedList<>();
        for (int count= 1; count<=playerCount; count++) {
            playerList.add(new Player("Player"+count));
        }
        gameOn();
    }

    protected abstract void gameOn();
}
