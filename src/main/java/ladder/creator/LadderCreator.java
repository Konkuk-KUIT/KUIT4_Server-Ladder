package ladder.creator;

import ladder.*;
import ladder.info.Ladder;
import ladder.info.LadderSize;

public interface LadderCreator {

    void drawLine(Position position);
    void drawLine(LadderSize ladderSize);
    Ladder getLadder();

}
