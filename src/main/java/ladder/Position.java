package ladder;

public class Position {
    private gameEntry entry;
    private Direction direction;

    private Position(gameEntry entry, Direction direction) {
        this.entry = entry;
        this.direction = direction;
    }

    public static Position of(int row, int column, Direction direction) {
        return new Position(gameEntry.from(row,column), direction);
    }

    public int getRow() {
        return this.entry.getRow();
    }

    public int getColumn() {
        return this.entry.getColumn();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
