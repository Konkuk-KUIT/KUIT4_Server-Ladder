package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createLadderGame(LadderSize ladderSize) {
        return new LadderGame(new LadderCreator(ladderSize));
    }

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        return new LadderGame(new RandomLadderCreator(ladderSize));
    }
}
