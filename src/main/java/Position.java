public class Position {
    private int row;
    private int col;
    public Position(NaturalNumber row, NaturalNumber col) {
        this.row = row.getNaturalNumber();
        this.col = col.getNaturalNumber();
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
