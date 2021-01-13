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

    /**
     * Creates the sections of the board array containing the alpha tiles - the coordinates.
     */
    private void setupCoords() {
        char curr = 'a';
        board[0][0] = new AlphaTile(" ");
        for (int col = 1; col < size; col++) {
            board[0][col] = new AlphaTile(curr + "");
            curr++;
        }

        for (int row = 1; row < size; row++) {
            board[row][0] = new AlphaTile(row + "");
        }
    }

    /**
     * Sets up the mines, randomising the positions. Also initalizes the numbers
     * that are shown when each tile is revealed by the player.
     * 
     * @param rate The rate of mines (how often they occur).
     */
    private void setupMines(double rate) {

        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {

                // should it theory create rate * 100 % mines on the board
                board[row][col] = (Math.random() <= rate) ? new BoardTile(true) : new BoardTile(false);
            }
        }

        // calculates the number of adjacent mines from each tile
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {

                if (((BoardTile) board[row][col]).isMine()) {
                    for (int i = Math.max(1, row - 1); i <= Math.min(size - 1, row + 1); i++) {
                        for (int j = Math.max(1, col - 1); j <= Math.min(size - 1, col + 1); j++) {
                            if (!(i == row && j == col)) {
                                ((BoardTile) board[i][j]).addMine();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the board so it can be used in the Game class.
     * 
     * @return The board.
     */
    Tile[][] getBoard() {
        return board;
    }

    /**
     * Prints the board, and the coordinates in a displayable form for the user.
     */
    void printBoard() {

        System.out.println();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] instanceof AlphaTile) {
                    System.out.printf("\033[0;1m%2s\033[0;0m |", board[row][col].printTile());
                } else {
                    System.out.printf("%2s |", board[row][col].printTile());

                }
            }

            System.out.println();
        }

        System.out.println();
    }

}
