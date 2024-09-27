package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator{

    private final Row[] rows;
    private final LadderSize ladderSize;

    public AutoLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        ladderSize = new LadderSize(numberOfRow, numberOfPerson);
    }

    @Override
    public void drawLine(Position row, Position col) {

        HashSet<Integer> lineIndex = new HashSet<>();
        boolean isAdded = true;
        double numberOfLine = ladderSize.getNumberOfPerson() * ladderSize.getNumberOfRow() * 0.3;

        while (lineIndex.size() < numberOfLine) { // 해시셋 원소개수가 그릴 수 있는 line 개수보다 작아야 함
            // 중복검사 해시셋
            Random random = new Random();
            int randomInt = random.nextInt(ladderSize.getNumberOfRow() * (ladderSize.getNumberOfPerson() - 1));
            isAdded = lineIndex.add(randomInt);
            if (!isAdded) {
                continue;
            }

            // 옆자리검증
            row = Position.from(randomInt / (ladderSize.getNumberOfPerson() - 1));
            col = Position.from(randomInt % (ladderSize.getNumberOfPerson() - 1));

            try {
                rows[row.getValue()].drawLine(col);
            } catch (IllegalArgumentException e) {
                lineIndex.remove(randomInt);
            }
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

}
