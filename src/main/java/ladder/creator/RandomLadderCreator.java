package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Row;

import java.util.HashSet;

public class RandomLadderCreator implements LadderCreatorIF{

    private final LadderCreator ladderCreator;
    private final LadderSize ladderSize;

    public RandomLadderCreator(LadderSize ladderSize) {
        ladderCreator = new LadderCreator(ladderSize);
        this.ladderSize = ladderSize;
        initLadder();
    }

    private void initLadder() {
        HashSet<LadderPosition> linePositionSet = new HashSet<>();
        int maxLineCount = ladderSize.getMaxLineCount();
        int maxRowNumber = ladderSize.getNumberOfRowValue();
        int maxNodeNumber = ladderSize.getNumberOfPersonValue() - 1;

        while (linePositionSet.size() < maxLineCount) {
            int x = (int)(Math.random() * maxRowNumber);
            int y = (int)(Math.random() * maxNodeNumber);
            LadderPosition ladderPosition = new LadderPosition(x, y);

            try {
                drawLine(ladderPosition);
                linePositionSet.add(ladderPosition);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        ladderCreator.drawLine(ladderPosition);
    }

    @Override
    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}
