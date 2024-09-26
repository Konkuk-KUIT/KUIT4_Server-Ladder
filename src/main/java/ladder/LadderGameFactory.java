package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.LadderCreator;

public class LadderGameFactory {

    private static LadderCreator ladderCreator;

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        AutoLadderCreator autoLadderCreator = new AutoLadderCreator(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());
        return new LadderGame(autoLadderCreator);
    }
}
