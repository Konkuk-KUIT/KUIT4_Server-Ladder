package ladder;

import ladder.creator.LadderManualCreator;

public class LadderGame {

    private final LadderManualCreator ladderManualCreator;

    public LadderGame(LadderManualCreator ladderManualCreator) {
        this.ladderManualCreator = ladderManualCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderManualCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
