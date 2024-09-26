package ladder.creator;

import ladder.component.LadderPosition;
import ladder.component.LadderSize;
import ladder.component.Position;
import ladder.component.Row;

import java.util.Random;

public class AutoLadderCreatorImpl implements LadderCreator {

    private Row[] rows;

    public AutoLadderCreatorImpl() {

    }

    public AutoLadderCreatorImpl(LadderSize ladderSize) {
        setRowsAndPersons(ladderSize);
    }

    // 빈 껍데기인 랜덤 사다리에서, 사다리의 높이와 게임에 참여하는 사람 수를 설정해주는 메소드
    public void setRowsAndPersons(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    // 사다리 자동 생성 - 인터페이스를 활용하기 위해 가장 처음 선을 그리고 싶은 위치는 입력 받을 수 있도록 함
    public void drawLine(LadderPosition ladderPosition) {

        rows[ladderPosition.getRow().getValue()].drawLine(ladderPosition.getCol());

        drawRandomLines(getNumberOfLines());

    }

    private void drawRandomLines(int numberOfLines) {
        LadderPosition ladderPosition;

        while (numberOfLines > 0) {

            ladderPosition = selectRandomPosition();

            // 사다리를 그릴 수 없다면 다시 반복
            if (!canDrawLineValidation(ladderPosition)) continue;

            rows[ladderPosition.getRow().getValue()].drawLine(ladderPosition.getCol());

            numberOfLines--;
        }
    }

    // 몇 개의 사다리를 자동으로 그릴지 결정. 우선 하나의 사다리를 그린 후 시작할 것이므로 계산 결과에서 1을 뺀 값을 반환함
    private int getNumberOfLines() {
        return (int) (rows.length * rows[0].getNodes().length * 0.3) - 1;
    }


    // 무작위로 사다리를 그릴 위치 선정
    private LadderPosition selectRandomPosition() {
        Random rand = new Random();

        Position row = Position.from(rand.nextInt(rows.length - 1));
        Position col = Position.from(rand.nextInt((rows[0].getNodes().length - 1)));

        return LadderPosition.from(row, col);
    }


    // 사다리를 그릴 수 있는지 검증
    private boolean canDrawLineValidation(LadderPosition ladderPosition) {
        try {
            rows[ladderPosition.getRow().getValue()].validateDrawLinePosition(ladderPosition.getCol());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }


    public Row[] getRows() {
        return rows;
    }
}
