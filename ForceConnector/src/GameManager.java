
//Imports:
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameManager {

    private static GameManager instance = null;
    public static GameManager get() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    //Main loop of class:
    public static void main(String[] args) { startGame(); }
    //Here can be the main starting point or link from other classes imported:
    public static void startGame() {

        //Start UI (working)
        JFrame frame = new mainMenu("FORCE CONNECTOR");
        frame.setVisible(true);

        //Interface:
        //JFrame gameInterface = gameInterface.get();
        GameBoard gameboard = GameBoard.get();
        Player player = new Player(gameboard.getPlayerColor());
        Player ai = new Player(gameboard.getAiColor());

        //On players turn
        //gameInterface.get().addPieceToBoard(gameboard.getPlayerColumn(), gameboard.getPlayerRow(),gameboard.getPlayerColor());
        //On Ai's turn
        //gameInterface.get().addPieceToBoard(gameboard.getAiColumn(), gameboard.getAIRow(), gameboard.getAiColor());

        //Logic to check board and set who is winning and or won:
        //gameboard.getWinningMove();
        //gameboard.getWinner();


    }
    public void onColumnSelect(int column) {
        GameBoard gameboard = GameBoard.get();
        gameboard.addPlayerPieceToBoard(column);
    }


}
