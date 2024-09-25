package ladder.info;

import ladder.GreaterThanOne;

public class LadderSize {

    private final int row;
    private final int col;

    public LadderSize(GreaterThanOne row, GreaterThanOne col) {
        this.row = row.getNumber();
        this.col = col.getNumber();
    }

    public static LadderSize of(int row, int col){
        return new LadderSize(GreaterThanOne.from(row), GreaterThanOne.from(col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
