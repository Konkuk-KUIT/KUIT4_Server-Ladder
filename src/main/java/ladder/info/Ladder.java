package ladder.info;

import ladder.GreaterThanOne;

public class Ladder {

    private final Row[] rows;
    private final LadderSize ladderSize;

    private Ladder(LadderSize ladderSize) {
        rows = new Row[ladderSize.getRow()];
        for (int i = 0; i < ladderSize.getRow(); i++) {
            rows[i] = new Row(GreaterThanOne.from(ladderSize.getCol()));
        }
        this.ladderSize = ladderSize;
    }

    public Row[] getRows() {
        return rows;
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }

    public static Ladder create(LadderSize ladderSize) {
        return new Ladder(ladderSize);
    }
}
