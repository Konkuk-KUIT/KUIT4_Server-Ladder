package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {
    private final Row[] rows;
    private int numberOfLines;
    private int numberOfPerson;

    public RandomLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        this.numberOfPerson = numberOfPerson.getNumber();
        numberOfLines = numberOfRow.getNumber() * numberOfPerson.getNumber() * 3 / 10;
    }

    public void drawRandomLines(){
        Set<LadderPosition> drawnLines = new HashSet<LadderPosition>();
        while (drawnLines.size() < numberOfLines) {
            Random random = new Random();
            int randomRow = random.nextInt(rows.length);
            int randomCol = random.nextInt(numberOfPerson);
            LadderPosition ladderPosition = new LadderPosition(Position.from(randomRow),Position.from(randomCol));
            try {
                drawLine(ladderPosition.getRow(), ladderPosition.getCol());
            } catch (Exception e){
                continue;
            }
            drawnLines.add(ladderPosition);
        }
    }


    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
