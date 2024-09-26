package ladder.creator;

import ladder.*;

public class CustomLadderCreator extends WrapperLadderCreator {

    private CustomLadderCreator(LadderWrapper ladderWrapper) {
        super(ladderWrapper);
    }

    public static CustomLadderCreator from(LadderSize ladderSize) {
        LadderWrapper ladderWrapper = createLadderWrapper(ladderSize);
        return new CustomLadderCreator(ladderWrapper);
    }
}
