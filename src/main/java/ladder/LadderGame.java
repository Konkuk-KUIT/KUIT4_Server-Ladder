package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    private LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame of(LadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }

    public int run(Position position) {
        LadderRunner ladderRunner = LadderRunner.of(ladderCreator.getLadder());
        ladderRunner.run(position);
        return position.getCol();
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }
}
