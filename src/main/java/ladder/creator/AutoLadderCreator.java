package ladder.creator;

import ladder.*;

import java.util.Random;

public class AutoLadderCreator implements LadderCreator {
    private final BasicLadderCreator basicCreator;  //조합 사용을 위한 private class
    private GreaterThanOne numberOfPerson;
    private GreaterThanOne numberOfRow;

    public AutoLadderCreator(LadderGameSize ladderGameSize) {
        this.numberOfRow = ladderGameSize.getNumberOfRow();
        this.numberOfPerson = ladderGameSize.getNumberOfPerson();

        this.basicCreator = new BasicLadderCreator(ladderGameSize);

        createLadder();
    }

    private void createLadder() {
        Random random = new Random();
        int LadderLineCount = (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3 + 1);

        while (LadderLineCount > 0) {
            try {
                int x = random.nextInt(numberOfRow.getNumber());
                int y = random.nextInt(numberOfPerson.getNumber() - 1);
                drawLine(Position.from(x), Position.from(y));
                LadderLineCount--;
            } catch (IllegalArgumentException e) {}
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        basicCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return basicCreator.getRows();
    }
}