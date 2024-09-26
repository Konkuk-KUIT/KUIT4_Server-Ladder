package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderWrapper;

public interface LadderCreator {
    public void drawLine(LadderPosition ladderPosition);

    public LadderWrapper getLadderWrapper();
}
