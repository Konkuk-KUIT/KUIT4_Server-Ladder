package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class LadderCreatorImpl implements LadderCreator {

    private Row[] rows;

    public LadderCreatorImpl() {
    }

    public LadderCreatorImpl(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
