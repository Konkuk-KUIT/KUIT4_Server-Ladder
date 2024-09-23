package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderCreatorImpl implements LadderCreator {

    private final Row[] rows;

    public LadderCreatorImpl(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    // 원하는 좌표에 사다리를 그리는 메소드
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
