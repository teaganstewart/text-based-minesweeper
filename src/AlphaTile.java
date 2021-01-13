public class AlphaTile implements Tile {

    char letter;

    AlphaTile(char letter) {
        this.letter = letter;
    }

    @Override
    public char printTile() {
        return letter;
    }

}
