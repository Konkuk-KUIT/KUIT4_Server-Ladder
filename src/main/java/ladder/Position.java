package ladder;

public class Position {
    private unsignedInteger row;
    private unsignedInteger col;
    private Direction direction;

    private Position(int row, int col, Direction direction) {
        this.row = unsignedInteger.from(row);
        this.col = unsignedInteger.from(col);
        this.direction = direction;
    }

    public static Position of(int row, int column, Direction direction) {
        return new Position(row ,column ,direction);
    }

    public int getRow() { return this.row.getValue(); }

    public int getColumn() {
        return this.col.getValue();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
