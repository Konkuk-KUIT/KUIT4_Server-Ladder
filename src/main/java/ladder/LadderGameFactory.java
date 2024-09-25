package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(LadderSize ladderSize){
        LadderCreator randomLadderCreator = RandomLadderCreator.from(ladderSize);
        return LadderGame.from(randomLadderCreator);
    }

    public static LadderGame createCustomLadderGame(LadderSize ladderSize){
        LadderCreator customLadderCreator = CustomLadderCreator.from(ladderSize);
        return LadderGame.from(customLadderCreator);
    }
}
