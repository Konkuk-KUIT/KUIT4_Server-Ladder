package ladder;

import ladder.creator.*;

public class LadderGameFactory {
    public static LadderGame createBasicLadderGame(LadderGameSize ladderGameSize) {
        LadderCreator creator = new BasicLadderCreator(ladderGameSize);
        return new LadderGame(creator);
    }

    public static LadderGame createRandomLadderGame(LadderGameSize ladderGameSize) {
        LadderCreator creator = new AutoLadderCreator(ladderGameSize);
        return new LadderGame(creator);
    }
}
