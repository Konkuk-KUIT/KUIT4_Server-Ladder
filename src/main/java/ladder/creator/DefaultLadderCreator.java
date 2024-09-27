package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class DefaultLadderCreator implements LadderCreator{

    private final Row[] rows;

    public DefaultLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public void drawLine() {
        throw new UnsupportedOperationException("DefaultLadder은 row, col이 없는 drawLine()을 지원하지 않습니다.");
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
