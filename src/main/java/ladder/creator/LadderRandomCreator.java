package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class LadderRandomCreator implements LadderCreator {

    private final Row[] rows;
    LadderSize ladderSize;
    Random random = new Random();
    HashSet<LadderPosition> lineCount = new HashSet<>();

    public LadderRandomCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        makeLineSet(numberOfRow,numberOfPerson);
    }

    @Override
    public boolean drawLine(Position row, Position col) {
        return rows[row.getValue()].drawLine(col);
    }

//    public void makeLineSet(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
//
//        LadderPosition ladderPos;
//        while(lineCount.size() != ladderSize.getNumberOfRandomLine()) {
//            ladderPos = new LadderPosition(Position.from(random.nextInt(numberOfRow.getNumber())), Position.from(random.nextInt(numberOfPerson.getNumber())-1));
//
//            boolean validLine = drawLine(ladderPos.getRow(), ladderPos.getColumn());
//            if (validLine) {
//                lineCount.add(ladderPos);
//            }
//        }
//    }

    public void makeLineSet(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {

        LadderPosition ladderPos;
        while (lineCount.size() != ladderSize.getNumberOfRandomLine()) {

            int rowIndex = random.nextInt(numberOfRow.getNumber());
            int columnIndex = random.nextInt(numberOfPerson.getNumber() - 1);

            ladderPos = new LadderPosition(Position.from(rowIndex), Position.from(columnIndex));

            boolean validLine = drawLine(ladderPos.getRow(), ladderPos.getColumn());
            if (validLine) {
                lineCount.add(ladderPos);
            }
        }
    }



    @Override
    public Row[] getRows() {
        return rows;
    }
}
