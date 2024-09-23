package ladder.creator;

import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

public interface LadderCreatorIF {
    public abstract void drawLine(LadderPosition ladderPosition);

    public abstract Row[] getRows();
}
