package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class AutoLadderCreatorImpl implements LadderCreator {

    private Row[] rows;

    public AutoLadderCreatorImpl() {

    }

    public AutoLadderCreatorImpl(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }


    // 빈 껍데기인 랜덤 사다리에서, 사다리의 높이와 게임에 참여하는 사람 수를 설정해주는 메소드
    public void setRowsAndPersons(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    // 사다리 자동 생성 - 인터페이스를 활용하기 위해 가장 처음 선을 그리고 싶은 위치는 입력 받을 수 있도록 함
    public void drawLine(Position row, Position col) {

        rows[row.getValue()].drawLine(col);

        int numberOfLines = getNumberOfLines();

        while (numberOfLines > 0) {

            row = selectRandomRow();
            col = selectRandomCol();

            // 사다리를 그릴 수 없다면 다시 반복
            if (!canDrawLineValidation(row, col)) continue;

            numberOfLines--;
        }

    }

    // 몇 개의 사다리를 자동으로 그릴지 결정
    private int getNumberOfLines() {
        return (int) (rows.length * rows[0].getNodes().length * 0.3) - 1;
    }


    // 사다리를 그릴 수 있는지 검증
    private boolean canDrawLineValidation(Position row, Position col) {
        try {
            rows[row.getValue()].drawLine(col);
        } catch (IllegalArgumentException e) {  //예외 처리 로직은 이미 존재하니, 예외가 발생하면 다시 사다리 그리기
            return false;
        }
        return true;
    }

    // 사다리를 그릴 행 랜덤하게 선택
    private Position selectRandomRow() {
        Random rand = new Random();
        return Position.from(rand.nextInt(rows.length - 1));
    }

    // 사다리를 그릴 열 랜덤하게 선택
    private Position selectRandomCol() {
        Random rand = new Random();
        return Position.from(rand.nextInt((rows[0].getNodes().length - 1)));
    }

    public Row[] getRows() {
        return rows;
    }
}
