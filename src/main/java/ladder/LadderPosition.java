package ladder;

public class LadderPosition {

    Position row, column;

    public LadderPosition(Position row, Position column) {
        this.row = row;
        this.column = column;
    }
    public Position getRow() {
        return row;
    }
    public Position getColumn() {
        return column;
    }
    public int getRowValue() {
        return row.getValue();
    }
    public int getColumnValue() {
        return column.getValue();
    }
}
