package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    Row[] getRows();
    void drawLine(Position row, Position col);
}
