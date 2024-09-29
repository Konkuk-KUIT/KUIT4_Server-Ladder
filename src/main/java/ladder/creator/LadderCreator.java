package ladder.creator;

import ladder.component.LadderPosition;
import ladder.component.LadderSize;
import ladder.component.Row;

public interface LadderCreator {

    // 사다리를 그리는 메소드
    void drawLine(LadderPosition ladderPosition);

    // 사다리의 높이(행의 개수)를 받아오는 메소드
    Row[] getRows();

}
