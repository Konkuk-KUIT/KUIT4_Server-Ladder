package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;

import ladder.LadderSize;
import ladder.Row;

public class LadderCreator implements LadderCreatorIF{

    private final Row[] rows;

    public LadderCreator(LadderSize size) {
        rows = new Row[size.getNumberOfRows()];
        for (int i = 0; i < size.getNumberOfRows(); i++) {
            rows[i] = new Row(new GreaterThanOne(size.getNumberOfPersons()));
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
