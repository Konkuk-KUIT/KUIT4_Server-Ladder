package ladder;

import ladder.creator.LadderAutoCreator;
import ladder.creator.LadderCreatorImpl;


public class LadderGameFactory {

    public static LadderGame createLadderGame(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        return new LadderGame(new LadderCreatorImpl(row, numberOfPerson));
    }

    public static LadderGame createRandomLadderGame(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        return new LadderGame(new LadderAutoCreator(row, numberOfPerson));
    }
}
