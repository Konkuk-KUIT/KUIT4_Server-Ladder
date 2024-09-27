package ladder.creator;

import ladder.*;


public class LadderCreator implements LadderCreatorIF {

    private final Row[] rows;

    public LadderCreator(LadderSize ladderSize) {
        int numberOfRow = ladderSize.getNumberOfRowValue();

        rows = new Row[numberOfRow];
        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        Position row = ladderPosition.getX();
        Position col = ladderPosition.getY();

        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
