package ladder;

import ladder.component.GreaterThanOne;
import ladder.component.LadderSize;
import ladder.creator.AutoLadderCreatorImpl;
import ladder.creator.BasicLadderCreatorImpl;
import ladder.creator.LadderCreator;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        return new LadderGame(new AutoLadderCreatorImpl(ladderSize));
    }

    public static LadderGame createBasicLadderGame(LadderSize ladderSize) {
        return new LadderGame(new BasicLadderCreatorImpl(ladderSize));
    }
}

