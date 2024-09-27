package ladder;

import ladder.creator.LadderAutoCreator;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderCreatorInterface ladderCreator = new LadderAutoCreator(numberOfRow, numberOfPerson);
        return new LadderGame(ladderCreator);
    }
}
