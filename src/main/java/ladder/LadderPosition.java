package ladder;

public class LadderPosition {
    private Position rowPos;
    private Position colPos;

    private LadderPosition(Position rowPos, Position colPos) {
        this.rowPos = rowPos;
        this.colPos = colPos;
    }

    public static LadderPosition of(Position rowPos, Position colPos){
        return new LadderPosition(rowPos, colPos);
    }

    public Position getRowPos() {
        return rowPos;
    }

    public Position getColPos() {
        return colPos;
    }
}
