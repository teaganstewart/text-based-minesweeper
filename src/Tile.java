/**
 * Allows for two types of tiles to occur on the board, alpha tiles which display coordinates 
 * (like battleships), and board tiles for the tiles part of the Minesweeper game.
 */
interface Tile {

    /**
     * Helper method to return the correct value for printing the board.
     * 
     * @return The corresponding character for the tile.
     */
    char printTile();
}