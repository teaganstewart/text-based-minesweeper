/**
 * Provides an object to represent the board, storing the location of mines and
 * printing the board.
 * 
 * @author Teagan Stewart
 */
public class Board {

    Tile[][] board;
    int size;

    /**
     * Creates the Minesweeper Board.
     * 
     * @param size The width and height of the board.
     * @param rate The rate that mines spawn on the board.
     */
    Board(int size, double rate) {
        board = new Tile[size + 1][size + 1];
        this.size = size + 1;
        setupCoords();
        setupMines(rate);
    }

    private void setupCoords() {
        char curr = 'a';
        for (int col = 1; col < size; col++) {
            board[0][col] = new AlphaTile(curr);
            curr++;
        }

        for (int row = 0; row < size; row++) {
            board[row][0] = new AlphaTile((char) (row + '0'));
        }
    }

    private void setupMines(double rate) {
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {

                board[row][col] = (Math.random() <= rate) ? new BoardTile(true) : new BoardTile(false);
            }
        }
    }

    Tile[][] getBoard() {
        return board;
    }

    /**
     * 
     */
    void printBoard() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col].printTile() + "|");
            }

            System.out.println();
        }
    }

}
