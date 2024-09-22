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
    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = RIGHT.getValue();
        row[startPosition + 1] = LEFT.getValue();
    }

//    자신의 상태가 무엇인지에 따라서 다음 좌표를 계산하고 반환을 함
    public int nextPosition(int position) {
        validatePosition(position);

        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == LEFT.getValue();
    }

    private boolean isRight(int position) {
        return row[position] == RIGHT.getValue();
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == -1 || row[startPosition + 1] == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }
}