package ladder.creator;

import ladder.LadderGame;
import ladder.wrapper.unsignedInt;

public class LadderGameFactory {

    public static LadderGame createPureLadderGame(int row, int column) {
        return new LadderGame(pureLadderCreator.from(unsignedInt.from(row), unsignedInt.from(column)));
    }

    public static LadderGame createRandomLadderGame(int row, int column) {
        return new LadderGame(randomLadderCreator.from(unsignedInt.from(row), unsignedInt.from(column)));
    }
}
