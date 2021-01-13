/**
 * The base class of my text-based interpretation of the classic game
 * 'Minesweeper'.
 * 
 * @version 1.0
 * @author Teagan Stewart
 */
public class App {

    final int BOARD_SIZE = 10;
    final int NO_MINES = 10;

    Board board;

    /**
     * Sets up the board, including the positions of the mines.
     */
    private void setup() {
        board = new Board(BOARD_SIZE, NO_MINES);
    }

    public static void main(String[] args) {
        new App().setup();
    }
}
