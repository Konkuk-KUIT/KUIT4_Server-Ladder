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
    public void drawLine() {
        HashSet<Integer> lineIndexSet = new HashSet<>();
        double ladderDrawLimit = calculateLadderDrawLimit();
        GreaterThanOne availableSpaces = getAvailableSpaces();

        while (lineIndexSet.size() < (int) ladderDrawLimit) {
            int randomInt = getUniqeRandomIndex(lineIndexSet, availableSpaces); // 중복 제거

            if (tryToDrawLine(randomInt)) { // 인접 line 그리지 않도록
                lineIndexSet.add(randomInt);
            }
        }
    }

    private boolean tryToDrawLine(int randomInt) {
        Position row = Position.from(randomInt / (ladderSize.getNumberOfPerson() - 1));
        Position col = Position.from(randomInt % (ladderSize.getNumberOfPerson() - 1));

        try {
            rows[row.getValue()].drawLine(col);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private int getUniqeRandomIndex(HashSet<Integer> lineIndexSet, GreaterThanOne availableSpaces) {
        Random random = new Random();
        int randomInt;

        do {
            randomInt = random.nextInt(availableSpaces.getNumber());
        } while (lineIndexSet.contains(randomInt));

        return randomInt;
    }

    private GreaterThanOne getAvailableSpaces() {
        return GreaterThanOne.from(ladderSize.getNumberOfRow() * (ladderSize.getNumberOfPerson() - 1));
    }

    private double calculateLadderDrawLimit() {
        return ladderSize.getNumberOfPerson() * ladderSize.getNumberOfRow() * 0.3;
    }

    @Override
    public void drawLine(Position row, Position col) {
        throw new UnsupportedOperationException("AutoLadder은 row, col이 없는 drawLine()만을 지원합니다.");
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

}
