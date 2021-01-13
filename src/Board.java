/**
 * Provides an object to represent the board, storing the location of mines and
 * printing the board.
 * 
 * @author Teagan Stewart
 */
public class Board {

    char[][] board;

    /**
     * 
     * @param size
     * @param noMines
     */
    Board(int size, int noMines) {

    }

    char[][] getBoard() {
        return board;
    }

    /**
     * 
     */
    void printBoard() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.println(board[row][col]);
            }
        }
    }

}
