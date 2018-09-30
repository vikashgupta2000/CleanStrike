package service.impl;

import handler.GameHandler;
import model.Player;
import service.CarromBoardGame;

import java.util.stream.Collectors;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class MyCarromBoardGame extends CarromBoardGame {

    public MyCarromBoardGame(GameHandler gameHandler) {
        super(gameHandler);
    }

    @Override
    protected void gameOn() {
        Player winner = null;
        boolean coinsPresentOnBoard = true;
        while (winner == null && coinsPresentOnBoard) {
            for (int count = 0; count < playerList.size(); count++) {
                Player player = playerList.remove();
                gameHandler.handlePlayer(player);
                playerList.add(player);
            }
            winner = gameHandler.hasWinner(playerList);
            coinsPresentOnBoard = gameHandler.coinsPresentOnBoard();
        }
        String finalScore = playerList.stream()
                .map(Player::getScore)
                .map(playerScore -> playerScore.toString())
                .collect(Collectors.joining("-"));
        if (winner == null) {
            System.out.println("Game is considered a Draw. Final Score : " + finalScore);
        } else {
            System.out.println(winner.getName() + " has won the game. Final Score : " + finalScore);
        }

    }
}
