package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {

    boolean drawLine(Position row, Position col);

    Row[] getRows();
}
