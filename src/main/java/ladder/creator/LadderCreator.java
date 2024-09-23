package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public interface LadderCreator {

    // 사다리를 그리는 메소드
    void drawLine(Position row, Position col);

    // 사다리의 높이(행의 개수)를 받아오는 메소드
    Row[] getRows();

    void setRowsAndPersons(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson);

}
