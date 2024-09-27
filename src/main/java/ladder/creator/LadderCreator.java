package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class LadderCreator implements LadderCreation{

    private final Row[] rows; // 사다리의 한 행을 빼놓았다.

    // todo 생성자 wrapper 클래스 필요 ㅇㅋ (-> GreaterThanOne)
    // Greaterthanone 클래스 필요 : 사다리 게임을 1명이서 하지는 않으니 (사다리 높이 및 인원수는 최소 1이상)
    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()]; // 가로줄 몇개 만들건지
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson); // 하나의 가로줄에 실제 세로줄 개수 할당
        }
    }

    // 사다리의 가로 줄 긋기
    // todo LadderCreator로 분리 (Ladder 클래스 책임분산)
    // todo 파라미터 Position wrapper 클래스 (0부터 입력가능한)
    // Position으로 인덱스 접근하여 rows에 실제 사다리 방향(선)을 그린다
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
