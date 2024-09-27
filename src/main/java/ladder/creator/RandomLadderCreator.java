package ladder.creator;

import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;
    private final Set<String> addedLines;
    private final LadderSize ladderSize;

    public RandomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        this.rows = new Row[ladderSize.getNumberOfRows()];
        this.addedLines = new HashSet<>();
        for (int i = 0; i < ladderSize.getNumberOfRows(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPersons());
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public void generateLadderLine() {
        Random random = new Random();
        int totalLines = ladderSize.calculateTotalLines();
        int linesAdded = 0;

        while (linesAdded < totalLines) {
            int rowIndex = random.nextInt(ladderSize.getNumberOfRows());
            int colIndex = random.nextInt(ladderSize.getNumberOfPersons() - 1);

            String lineKey = rowIndex + "-" + colIndex;

            if (!addedLines.contains(lineKey)) {
                try {
                    drawLine(Position.from(rowIndex), Position.from(colIndex));
                    addedLines.add(lineKey);
                    linesAdded++;
                } catch (IllegalArgumentException e) {
                    // 겹치는 라인이 있을 경우 예외 발생
                }
            }
        }
    }
}