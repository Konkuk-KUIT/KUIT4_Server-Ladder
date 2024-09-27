package ladder;

import ladder.creator.LadderAutoCreator;
import ladder.creator.LadderInputCreator;
import ladder.info.LadderSize;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        LadderAutoCreator ladderAutoCreator = LadderAutoCreator.of(ladderSize);
        return LadderGame.of(ladderAutoCreator);
    }

    public static LadderGame createInputLadderGame(LadderSize ladderSize) {
        LadderInputCreator ladderInputCreator = LadderInputCreator.of(ladderSize);
        return LadderGame.of(ladderInputCreator);
    }

}
