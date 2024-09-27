package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderCreatorIF;

public class LadderGame {

    //private final LadderCreator ladderCreator;
    private final LadderCreatorIF ladderCreator;


    public LadderGame(LadderCreatorIF ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame of(LadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }

    public int run(LadderPosition position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getX();
    }
}
