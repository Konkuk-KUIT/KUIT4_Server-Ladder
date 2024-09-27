package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderCreatorInterface;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderAutoCreator implements LadderCreatorInterface {

    private final Row[] rows;
    private final int numberOfLines;
    private final Random random = new Random();

    public LadderAutoCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];

        numberOfLines = (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3);

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }

        createRandomLines(numberOfPerson);
    }

    private void createRandomLines(GreaterThanOne numberOfPerson) {
        int linesDrawn = 0;
        while (linesDrawn < numberOfLines) {
            int randomRow = random.nextInt(rows.length);
            int randomCol = random.nextInt(numberOfPerson.getNumber() - 1);

            Position position = Position.from(randomCol);

            if (rows[randomRow].canDrawLineAt(position.getPosition())) {
                rows[randomRow].drawLine(position);
                linesDrawn++;
            }
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
