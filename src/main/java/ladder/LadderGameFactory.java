package ladder;

import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int numberOfRows, int numberOfPersons) {
        LadderSize ladderSize = LadderSize.of(numberOfRows, numberOfPersons);
        RandomLadderCreator ladderCreator = new RandomLadderCreator(ladderSize);
        ladderCreator.generateLadderLine();
        return new LadderGame(ladderCreator);
    }
}
