package ladder.creator;

import ladder.LadderPosition;
import ladder.Row;

public interface LadderCreatorIF {
    void drawLine(LadderPosition start, LadderPosition end);
    Row[] getRows();
}
