package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame createAutoLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderCreator ladderCreator = LadderCreator.autoCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine();
        return new LadderGame(ladderCreator);
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
