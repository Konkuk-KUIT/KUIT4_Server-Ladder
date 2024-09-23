package ladder;

import ladder.creator.AutoLadderCreatorImpl;
import ladder.creator.LadderCreator;
import ladder.creator.LadderCreatorImpl;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame() {
        return new LadderGame(new AutoLadderCreatorImpl());
    }

    public static LadderGame createLadderGame() {
        return new LadderGame(new LadderCreatorImpl());
    }
}

