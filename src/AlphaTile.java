public class AlphaTile implements Tile {

    String letter;

    AlphaTile(String letter) {
        this.letter = letter;
    }

    @Override
    public String printTile() {
        return letter;
    }

}
