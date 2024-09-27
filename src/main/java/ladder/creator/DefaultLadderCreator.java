package ladder.creator;

import ladder.Position;
import ladder.Row;

public class DefaultLadderCreator implements LadderCreator{

    private final Row[] rows;

    public DefaultLadderCreator(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];

        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);  // 특정 행에 특정 열에 라인 그리기
    }
}
