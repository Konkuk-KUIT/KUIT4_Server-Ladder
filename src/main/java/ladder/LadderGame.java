package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderCreatorImpl;

public class LadderGame {

    private final LadderCreator ladderCreator;
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }
}
