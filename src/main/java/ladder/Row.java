package ladder;

import static ladder.Direction.*;

public class Row {

//    todo Node 클래스 분리
    private final int[] row;


    public Row(GreaterThanOne numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
    }

//    사다리 가로줄을 그을 때 해당 좌표에는 1을 넣고 오른쪽 값은 -1을 해줘서
//    입력한 좌표의 오른쪽에 라인이 생기게끔 만듦
//    이런식으로 상수가 하드코딩이 돼있는건 좋지 않음
    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition.getPosition()] = RIGHT.getValue();
        row[startPosition.getPosition() + 1] = LEFT.getValue();
    }

//    자신의 상태가 무엇인지에 따라서 다음 좌표를 계산하고 반환을 함
    public void nextPosition(Position position) {
        validatePosition(position);

        if (isRight(position)) {
            position.next();
            return;
        }
        if (isLeft(position)) {
            position.prev();
            return;
        }
    }

    private boolean isLeft(Position position) {
        return row[position.getPosition()] == LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getPosition()] == RIGHT.getValue();
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(row.length - 1)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidPosition(startPosition) || isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position startPosition) {
        return startPosition.isBiggerThan(row.length - 1);
    }

    private boolean isLineAtPosition(Position startPosition) {
        return row[startPosition.getPosition()] == RIGHT.getValue() || row[startPosition.getPosition()] == LEFT.getValue();
    }

    private boolean isLineAtNextPosition(Position startPosition) {
        return row[startPosition.getPosition() + 1] == RIGHT.getValue() || row[startPosition.getPosition() + 1] == LEFT.getValue();
    }
}