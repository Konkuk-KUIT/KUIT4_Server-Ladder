package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreation {
    void drawLine(Position row, Position col);

    Row[] getRows();
}
