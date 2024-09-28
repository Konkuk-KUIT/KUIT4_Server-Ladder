package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderUserCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;


    // Interface로 넘겨서 하는 방법 좋은...?
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }


}
