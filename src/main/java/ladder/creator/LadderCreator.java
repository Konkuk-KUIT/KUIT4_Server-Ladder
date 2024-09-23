package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }


    // 사다리 자동 생성
    public void autoDrawLine() {
        int numberOfLines = (int) (rows.length * rows[0].getNodes().length * 0.3);

        while (numberOfLines > 0) {

            Position row = selectRandomRow();
            Position col = selectRandomCol();

            try {
                rows[row.getValue()].drawLine(col);
            } catch (IllegalArgumentException e) {  //예외 처리 로직은 이미 존재하니, 예외가 발생하면 다시 사다리 그리기
                continue;
            }

            numberOfLines--;
        }

    }

    private Position selectRandomRow() {
        Random rand = new Random();
        return Position.from(rand.nextInt(rows.length - 1));
    }

    private Position selectRandomCol() {
        Random rand = new Random();
        return Position.from(rand.nextInt((rows[0].getNodes().length - 1)));
    }

    public Row[] getRows() {
        return rows;
    }
}
