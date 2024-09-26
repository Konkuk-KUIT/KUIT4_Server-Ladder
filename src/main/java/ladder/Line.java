package ladder;

import ladder.constants.Direction;
import ladder.wrapper.unsignedInt;

public class Line {
    private unsignedInt row;
    private unsignedInt col;
    private Direction direction;

    private Line(int row, int col, Direction direction) {
        this.row = unsignedInt.from(row);
        this.col = unsignedInt.from(col);
        this.direction = direction;
    }

    public static Line of(int row, int column, Direction direction) {
        return new Line(row ,column ,direction);
    }

    public int getRow() { return this.row.getValue(); }

    public int getColumn() {
        return this.col.getValue();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
