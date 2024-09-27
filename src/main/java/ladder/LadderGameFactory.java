package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderManualCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderCreator randomCreator) {
        return new LadderGame((LadderRandomCreator) randomCreator);
    }

    public static LadderGame createManualLadderGame(LadderCreator manualCreator) {
        return new LadderGame((LadderManualCreator) manualCreator);
    }

    // todo trouble-shooting
//    public LadderGame createRandomLadderGame(LadderCreator randomCreator) {
//        return ladderGame.RandomGame((LadderRandomCreator) randomCreator);
//    }
//
//    public LadderGame createManualLadderGame(LadderCreator manualCreator) {
//        return ladderGame.ManualGame((LadderManualCreator) manualCreator);
//    }
}

