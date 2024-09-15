public class Position {
    private int row;
    private int column;
    private Direction direction;

    private Position(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public static Position of(int row, int column, Direction direction) {
        return new Position(row, column, direction);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
