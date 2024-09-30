package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGameSize;
import ladder.Position;
import ladder.Row;

public class BasicLadderCreator implements LadderCreator {
    private final Row[] rows;

    public BasicLadderCreator(LadderGameSize ladderGameSize) {
        rows = new Row[ladderGameSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderGameSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderGameSize.getNumberOfPerson());
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}