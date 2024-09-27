package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;

import ladder.Row;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(LadderPosition start, LadderPosition end) {
        if (start.getY() != end.getY()) {
            throw new IllegalArgumentException("가로선은 같은 행에서만 그릴 수 있습니다.");
        }
        if (Math.abs(start.getX() - end.getX()) != 1) {
            throw new IllegalArgumentException("가로선은 인접한 열 사이에만 그릴 수 있습니다.");
        }

        rows[start.getY()].drawLine(start);
    }


    public Row[] getRows() {
        return rows;
    }
}
