package ladder;

import ladder.creator.LadderCreator;
import ladder.runner.LadderRunner;

public class Ladder {

    private final LadderCreator ladderCreator;

    static final int hasLine = 1;

    public Ladder(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run (int startingLadderIndex) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(startingLadderIndex);
    }

}

