package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {
    private final LadderCreator ladderCreator;

    LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}