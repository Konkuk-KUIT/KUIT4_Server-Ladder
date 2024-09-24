package ladder;

import ladder.creator.AutoLadderCreatorImpl;
import ladder.creator.BasicLadderCreatorImpl;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame() {
        return new LadderGame(new AutoLadderCreatorImpl());
    }

    public static LadderGame createBasicLadderGame() {
        return new LadderGame(new BasicLadderCreatorImpl());
    }
}

