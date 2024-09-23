package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class AutoLadderCreatorImpl implements LadderCreator {

    private final Row[] rows;

    public AutoLadderCreatorImpl(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }


    // 사다리 자동 생성 - 인터페이스를 활용하기 위해 가장 처음 선을 그리고 싶은 위치는 입력받을 수 있도록 함
    public void drawLine(Position row, Position col) {

        rows[row.getValue()].drawLine(col);

        int numberOfLines = (int) (rows.length * rows[0].getNodes().length * 0.3) - 1;

        while (numberOfLines > 0) {

            row = selectRandomRow();
            col = selectRandomCol();

            // 사다리를 그릴 수 없다면 다시 반복
            if (!canDrawLineValidation(row, col)) continue;

            numberOfLines--;
        }

    }


    // 사다리를 그릴 수 있는지 검증
    private boolean canDrawLineValidation(Position row, Position col) {
        try {
            rows[row.getValue()].drawLine(col);
        } catch (IllegalArgumentException e) {  //예외 처리 로직은 이미 존재하니, 예외가 발생하면 다시 사다리 그리기
            return false;
        }
        return true;
    }

    // 사다리를 그릴 행 랜덤하게 선택
    private Position selectRandomRow() {
        Random rand = new Random();
        return Position.from(rand.nextInt(rows.length - 1));
    }

    // 사다리를 그릴 열 랜덤하게 선택
    private Position selectRandomCol() {
        Random rand = new Random();
        return Position.from(rand.nextInt((rows[0].getNodes().length - 1)));
    }

    public Row[] getRows() {
        return rows;
    }
}
