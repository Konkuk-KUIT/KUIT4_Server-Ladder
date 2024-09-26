package ladder;

public class LadderPosition {
    private Position row;
    private Position col;

    public LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getCol() {
        return col;
    }
    public Position getRow() {
        return row;
    }

    public void moveDown() {
        row.next();
    }
}
