/**
 * Forms a single tile on the minesweeper board, keeps track of whether the tile
 * is a mine or not, and whether it has been shown.
 */
public class BoardTile implements Tile {

    private boolean mine;
    private boolean shown = false;
    private boolean flag = false;
    private int adjMines = 0;

    BoardTile(boolean mine) {
        this.mine = mine;
    }

    /**
     * Reveals the contents of the tile.
     */
    void show() {
        shown = true;
    }

    /**
     * Adds a flag to the tile, can be used to mark mines.
     */
    void flag() {
        flag = !flag;
    }

    /**
     * Adds a mine to the number of adjacent mines, used in the board setup method.
     */
    void addMine() {
        adjMines++;
    }

    /**
     * Gets the number of adjacent mines, shown when a tile is uncovered.
     * 
     * @return Returns the number of adjacent mines to the tile.
     */
    int getAdjMines() {
        return adjMines;
    }

    /**
     * Helper method for checking whether the splayer wins or loses.
     * 
     * @return Whether the tile contains a mine or not.
     */
    boolean isMine() {
        return mine;
    }

    /**
     * Helper method for checking whether the players wins or loses.
     * 
     * @return Whether the tile is shown or covered.
     */
    boolean isShown() {
        return shown;
    }

    /**
     * Helper method for displaying the players flagged tiles.
     * 
     * @return Whether the tile is flagged or not.
     */
    boolean isFlag() {
        return flag;
    }

    @Override
    public String printTile() {

        if (flag)
            return "F";
        else if (!shown)
            return "X";
        else if (mine)
            return "O";

        return (adjMines == 0) ? " " : adjMines + "";
    }

}
