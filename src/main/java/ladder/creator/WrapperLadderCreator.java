package ladder.creator;

import ladder.*;

public abstract class WrapperLadderCreator implements LadderCreator {
    protected final LadderWrapper ladderWrapper;

    protected WrapperLadderCreator(LadderWrapper ladderWrapper) {
        this.ladderWrapper = ladderWrapper;
    }

    public LadderWrapper getLadderWrapper() {
        return ladderWrapper;
    }

    public void drawLine(LadderPosition ladderPosition) {
        ladderWrapper.drawLine(ladderPosition);
    }

    protected static LadderWrapper createLadderWrapper(LadderSize ladderSize) {
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();
        Row[] rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = Row.from(numberOfPerson);
        }
        return LadderWrapper.from(rows);
    }
}
