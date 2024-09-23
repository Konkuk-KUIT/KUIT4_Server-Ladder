package ladder;

import ladder.creator.LadderCreatorIF;

public class LadderGame {

    private final LadderCreatorIF ladderCreatorIF;

    public LadderGame(LadderCreatorIF ladderCreatorIF) {
        this.ladderCreatorIF = ladderCreatorIF;
    }

    public int run(Position position) {
        LadderPosition ladderPosition = new LadderPosition(0, position.getValue());
        LadderRunner ladderRunner = new LadderRunner(ladderCreatorIF.getRows());
        return ladderRunner.run(ladderPosition);
    }
}
