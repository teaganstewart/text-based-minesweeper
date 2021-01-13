/**
 * The base class of my text-based interpretation of the classic game
 * 'Minesweeper'.
 * 
 * @version 1.0
 * @author Teagan Stewart
 */
public class App {

    final int BOARD_SIZE = 10; //max is 26
    final double MINE_RATE = 0.2; //max is 1

    Board board;

    /**
     * Sets up the board, including the positions of the mines.
     */
    private void setup() {
        board = new Board(BOARD_SIZE, MINE_RATE);
        board.printBoard();
    }

    public static void main(String[] args) {
        new App().setup();
    }
}
