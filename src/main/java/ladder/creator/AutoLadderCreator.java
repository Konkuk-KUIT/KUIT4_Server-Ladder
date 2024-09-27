package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;

public class AutoLadderCreator implements LadderCreatorIF{
    private final Row[] rows;
    public AutoLadderCreator(LadderSize size) {
        rows = new Row[size.getNumberOfRows()];
        for (int i = 0; i < size.getNumberOfRows(); i++) {
            rows[i] = new Row(new GreaterThanOne(size.getNumberOfPersons()));
        }
        autoCreateLines(size);
    }

    private void autoCreateLines(LadderSize size) {
        int totalLines = (int) (size.getNumberOfRows() * size.getNumberOfPersons() * 0.3);
        Random random = new Random();
        HashSet<Integer> drawnPositions = new HashSet<>();

        while (drawnPositions.size() < totalLines) {
            int y = random.nextInt(size.getNumberOfRows());
            int x = random.nextInt(size.getNumberOfPersons() - 1);

            try {
                LadderPosition start = LadderPosition.of(x, y);
                LadderPosition end = LadderPosition.of(x + 1, y);
                this.drawLine(start, end);
                drawnPositions.add(y * size.getNumberOfPersons() + x);  // Unique identifier for position
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override
    public void drawLine(LadderPosition start, LadderPosition end) {
        rows[start.getY()].drawLine(start);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
