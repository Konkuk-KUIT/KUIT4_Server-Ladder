package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator {

    private final Row[] rows;
    private Random random = new Random();

    public AutoLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawRandomLines(LadderSize ladderSize, GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        int linesToCreate = ladderSize.calculateNumberOfLines();

        HashSet<LadderPosition> positions = new HashSet<>();


        while (positions.size() < linesToCreate) {
            int row = random.nextInt(numberOfRow.getNumber());
            int col = random.nextInt(numberOfPerson.getNumber() - 1); // 선이 열 사이에 있으므로 열 크기보다 1 작게 선택

            LadderPosition newPosition = new LadderPosition(row, col);

            // 해당 위치에 선을 그릴 수 있는지 확인
            if (positions.contains(newPosition) || !canDrawLine(Position.from(row), Position.from(col))) {
                continue;
            }

            this.drawLine(Position.from(row), Position.from(col));
            positions.add(newPosition);
        }
    }

    // 선을 그릴 수 있는지 확인하는 메소드
    private boolean canDrawLine(Position row, Position col) {
        return rows[row.getPosition()].canDrawLineAtPosition(col);  // 유효성 검사 메소드를 호출
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
