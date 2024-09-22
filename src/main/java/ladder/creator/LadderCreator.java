package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class LadderCreator {

    private final Row[] rows; // 사다리의 한 행을 빼놓았다.

    // todo 생성자 wrapper 클래스 필요 ㅇㅋ (-> GreaterThanOne)
    // Greaterthanone 클래스 필요 : 사다리 게임을 1명이서 하지는 않으니
    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    // 사다리의 가로 줄 긋기
    // todo LadderCreator로 분리 (Ladder 클래스 책임분산)
    // todo 파라미터 Position wrapper 클래스 (0부터 입력가능한)
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
