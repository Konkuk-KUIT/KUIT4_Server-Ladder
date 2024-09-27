package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public interface LadderCreator {

    static LadderCreator autoCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        return new AutoLadderCreator(numberOfRow, numberOfPerson);
    }

    static LadderCreator defaultCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        return new DefaultLadderCreator(numberOfRow, numberOfPerson);
    }

    void drawLine(Position row, Position col);

    void drawLine();

    Row[] getRows();
}
