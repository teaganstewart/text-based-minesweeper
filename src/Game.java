import java.io.*;
import java.util.Scanner;

/**
 * The base class of my text-based interpretation of the classic game
 * 'Minesweeper'.
 * 
 * @version 1.0
 * @author Teagan Stewart
 */
public class Game {

    final private int BOARD_SIZE = 10; // max is 26
    final private double MINE_RATE = 0.2; // max is 1

    Board board;

    /**
     * Sets up the board, including the positions of the mines.
     */
    private void setup() {

        setupInstructions();

        board = new Board(BOARD_SIZE, MINE_RATE);
        board.printBoard();

        runGame();
    }

    /**
     * Runs the game loop. Exits when the player wins or loses.
     */
    void runGame() {

        String input = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please make your move. Flag or Reveal a tile.");
            try {
                input = stdin.readLine();
                while (!checkMoveInput(input)) {
                    System.out.println("Please make your move. Flag or Reveal a tile.");
                    input = stdin.readLine();
                }

            } catch (IOException e) {
                System.out.println("Something went wrong with the input.");
                break;
            }

            if (!parseMove(input))
                break;

            board.printBoard();
        }
    }

    /**
     * Checks whether the players move input is valid.
     * 
     * @param input The players input.
     * @return Whether the input is valid or not.
     */
    private boolean checkMoveInput(String input) {

        if (input.charAt(1) >= ((char) (board.getBoard().length + 'a' - 1))) {
            System.out.println("Please enter a valid move location letter e.g. Ra3");
            return false;
        }

        int number;

        if (input.charAt(0) == 'F' || input.charAt(0) == 'R') {

            try {
                number = Integer.parseInt(input.substring(2));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid move location number e.g. Ra7");
                return false;
            }
        } else {
            System.out.println("Please enter a valid move type e.g. Fa3 or Ra3");
            return false;
        }

        return number > 0 && number < board.getBoard().length;
    }

    /**
     * 
     * @param input
     */
    private boolean parseMove(String input) {

        int row = Integer.parseInt(input.substring(2));
        int col = Character.getNumericValue(input.charAt(1)) - Character.getNumericValue('a') + 1;

        BoardTile currTile = ((BoardTile) board.getBoard()[row][col]);
        if (input.charAt(0) == 'F') {
            if (!currTile.isShown()) {
                currTile.flag();
            }
        } else if (input.charAt(0) == 'R') {
            if (!currTile.isShown()) {

                currTile.show();

                if (currTile.isMine()) {
                    board.printBoard();
                    System.out.println("you lose!");
                    return false;

                }
            }
        }

        return true;
    }

    /**
     * Reads the instructions file and displays it in the console.
     */
    private void setupInstructions() {

        System.out.printf("\n\033[0;1mRules/ Help\033[0;0m \n\n");

        try {
            Scanner sc = new Scanner(new File("rules.txt"));

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {

            System.out.println("Error: File doesn't exist");
        }
    }

    public static void main(String[] args) {
        new Game().setup();
    }
}
