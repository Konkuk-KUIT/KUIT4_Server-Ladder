package ladder.creator;

import ladder.*;

import java.util.HashSet;

public class LadderRandomCreator implements LadderCreation {

    private final LadderCreator ladderCreator;
    private final LadderSize ladderSize;
    private final int lineNumber; // 몇개 생성할 건지 개수
    HashSet<LadderPosition> startPosition;

    // 우선 drawLine으로 x좌표 넘겨주고, 그 다음에 y좌표까지 같은지 반복문으로 판단
    public LadderRandomCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        ladderCreator = new LadderCreator(ladderSize.getRow(), ladderSize.getNumberOfPerson());
        this.lineNumber = ladderSize.getLadderLineNum();
    }

    public void makeRandomLine() {
        startPosition = new HashSet<>(); // HashSet<>초기화

        while (startPosition.size() < lineNumber) { // hashset 개수가 lineNumber 안 넘는 동안
            int xValue = (int) (Math.random() * (ladderSize.getIntNumberOfPerson() - 1)); // 제일 오른쪽은 그릴 수 없으므로
            int yValue = (int) (Math.random() * ladderSize.getIntRow());
            Position x = Position.from(xValue);
            Position y = Position.from(yValue);

            LadderPosition currentPosition = new LadderPosition(x,y); // 추가하려는 임시 LadderPosition 객체

            if (!startPosition.contains(currentPosition)) {
                startPosition.add(currentPosition);
                drawLine(currentPosition.getY(), currentPosition.getX());
            }
        }
    }

    public void drawLine(Position row, Position col) {
        ladderCreator.getRows()[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return ladderCreator.getRows();
    }
}
