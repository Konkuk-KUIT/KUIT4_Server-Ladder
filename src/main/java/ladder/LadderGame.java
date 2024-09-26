package ladder;

import ladder.creator.LadderCreator;
import ladder.runner.LadderRunner;
import ladder.wrapper.ArrayIndex;

public class LadderGame {

    private final LadderCreator ladderCreator;


    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run (ArrayIndex startingLadderIndex) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(startingLadderIndex);
    }

}

