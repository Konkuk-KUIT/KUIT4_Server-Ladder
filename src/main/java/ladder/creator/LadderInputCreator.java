package ladder.creator;

import ladder.exception.ExceptionMessage;
import ladder.info.Ladder;
import ladder.info.LadderSize;
import ladder.Position;

public class LadderInputCreator implements LadderCreator {

    private final Ladder ladder;

    private LadderInputCreator(LadderSize ladderSize) {
        this.ladder = Ladder.create(ladderSize);
    }

    @Override
    public void drawLine(Position position) {
        ladder.getRows()[position.getRow()].drawLine(position);
    }

    @Override
    public void drawLine(LadderSize ladderSize) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_DRAW_INPUT.getMessage());
    }

    public static LadderInputCreator of(LadderSize ladderSize) {
        return new LadderInputCreator(ladderSize);
    }

    @Override
    public Ladder getLadder() {
        return this.ladder;
    }


}
