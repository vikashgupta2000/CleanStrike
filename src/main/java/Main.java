import handler.CarromValidation;
import handler.GameHandler;
import model.CarromBoard;
import model.Coin;
import service.CarromBoardGame;
import service.impl.MyCarromBoardGame;


/**
 * Created by vikashgupta on 29/09/18.
 */
public class Main {
//    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int playerCount = 2;
        CarromBoard carromBoard = new CarromBoard(new Coin(9, 1), new Coin(1, 3));
        CarromValidation carromValidation = new CarromValidation();
        GameHandler gameHandler = new GameHandler(carromBoard, carromValidation);
        CarromBoardGame carromBoardGame = new MyCarromBoardGame(gameHandler);
        carromBoardGame.startGame(playerCount);
    }
}
