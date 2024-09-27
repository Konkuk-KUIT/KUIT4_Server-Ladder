package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderManualCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGame {

    LadderCreator ladderCreator;

    public LadderGame RandomGame(LadderRandomCreator ladderRandomCreator) {
        this.ladderCreator = ladderRandomCreator;
        return this;
    }

    public LadderGame ManualGame(LadderManualCreator ladderManualCreator) {
        this.ladderCreator = ladderManualCreator;
        return this;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}