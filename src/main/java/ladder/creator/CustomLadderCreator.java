package ladder.creator;

import ladder.*;

public class CustomLadderCreator implements LadderCreator {
    private final LadderWrapper ladderWrapper;

    private CustomLadderCreator(LadderWrapper ladderWrapper) {
        this.ladderWrapper = ladderWrapper;
    }

    public static CustomLadderCreator from(LadderSize ladderSize){
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();

        Row[] rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = Row.from(numberOfPerson);
        }
        LadderWrapper ladderWrapper = LadderWrapper.from(rows);
        return new CustomLadderCreator(ladderWrapper);
    }

    public void drawLine(LadderPosition ladderPosition) {
        ladderWrapper.drawLine(ladderPosition);
    }

    public LadderWrapper getLadderWrapper() {
        return ladderWrapper;
    }
}
