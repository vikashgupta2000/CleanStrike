package handler;

import constants.Carrom;
import model.CarromBoard;
import model.CoinType;
import model.Player;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by vikashgupta on 30/09/18.
 */
public class GameHandler {
    private static Scanner scanner = new Scanner(System.in);
    private CarromValidation carromValidation;
    private CarromBoard carromBoard;

    public GameHandler (CarromBoard carromBoard, CarromValidation carromValidation) {
        this.carromBoard = carromBoard;
        this.carromValidation = carromValidation;
    }

    private void showOptions() {
        System.out.println("1. Strike");
        System.out.println("2. Red Strike");
        System.out.println("3. Striker Strike");
        System.out.println("4. Defunt Coin");
        System.out.println("5. None");
    }

    private void coinCalculation(Player player) {
        if (player.getRedCoinPocketed()) {
            carromBoard.addCoin(player.getTotalBlackCoinPocketed(), CoinType.BLACK);
        } else if (player.getTotalBlackCoinPocketed() > 2) {
            carromBoard.addCoin(player.getTotalBlackCoinPocketed()-2, CoinType.BLACK);
        }
    }

    public void handlePlayer(Player player) {
        boolean isValid = carromBoard.anyCoinOnBoard();
        boolean breakLoop = false;
        while (isValid) {
            System.out.println(player.getName() + " : Choose an outcome from the list below");
            showOptions();
            int inputOption = scanner.nextInt();
            switch (inputOption) {
                case 1:
                    boolean blackCoinPresent = carromValidation.isValidInput(carromBoard, CoinType.BLACK);
                    if (blackCoinPresent) {
                        player.setBlackCoinPocketed();
                        carromBoard.removeCoin(CoinType.BLACK);
                    } else {
                        System.out.println("No Black coin Left on Board. Please select a different choice.");
                    }
                    break;
                case 2:
                    boolean redCoinPresent = carromValidation.isValidInput(carromBoard, CoinType.RED);
                    if (redCoinPresent) {
                        player.setRedCoinPocketed();
                        carromBoard.removeCoin(CoinType.RED);
                    } else {
                        System.out.println("No Red coin left on Board. Please select a different choice.");
                    }
                    break;
                case 3:
                    player.foulPlay(Carrom.STRIKER_STRIKE);
                    breakLoop = true;
                    break;
                case 4:
                    player.foulPlay(Carrom.DEFUNCT_COIN);
                    carromBoard.removeCoin(CoinType.BLACK);
                    breakLoop = true;
                    break;
                case 5:
                    player.incrementMissedPocketCounter();
                    breakLoop = true;
                    break;
            }
            if (breakLoop) {
                isValid = false;
            } else {
                isValid = carromBoard.anyCoinOnBoard();
            }
        }
        coinCalculation(player);
        player.calculateScore();
    }

    public boolean coinsPresentOnBoard () {
        return carromBoard.anyCoinOnBoard();
    }
    public Player hasWinner(Queue<Player> playerList) {
        return carromValidation.hasWinner(playerList);
    }
}
