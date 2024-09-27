package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class LadderRandomCreator {

    private final Row[] rows;
    LadderSize ladderSize;
    Random random = new Random();
    HashSet<LadderPosition> lineCount;

    public LadderRandomCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        ladderSize = new LadderSize(numberOfRow, numberOfPerson);
    }

    public void drawLine(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {

        LadderPosition ladderPos;
        while(lineCount.size() != ladderSize.getNumberOfRandomLine()) {
            ladderPos = new LadderPosition(Position.from(random.nextInt(numberOfRow.getNumber())), Position.from(random.nextInt(numberOfPerson.getNumber())));

            if (rows[ladderPos.getRowValue()].drawLine(ladderPos.getColumn())) {
                lineCount.add(ladderPos);
            }
        }
    }

    public Row[] getRows() {
        return rows;
    }
}
