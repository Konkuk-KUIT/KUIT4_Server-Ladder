public class Position {
    private int row;
    private int column;
    private int ladderNumber;

    private Position(int row, int column, int ladderNumber) {
        this.row = row;
        this.column = column;
        this.ladderNumber = ladderNumber;
    }

    public static Position of(int row, int column, int ladderNumber) {
        return new Position(row, column, ladderNumber);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLadderNumber() {
        return this.ladderNumber;
    }
}
