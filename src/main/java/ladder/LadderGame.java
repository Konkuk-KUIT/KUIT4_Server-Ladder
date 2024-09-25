package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    private LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame from(LadderCreator ladderCreator){
        return new LadderGame(ladderCreator);
    }

    public int run(Position position) {
        LadderRunner ladderRunner = LadderRunner.from(ladderCreator.getLadderWrapper());
        ladderRunner.run(position);
        return position.getValue();
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }
}