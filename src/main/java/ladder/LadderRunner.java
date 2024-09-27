package ladder;

import ladder.info.Ladder;
import ladder.print.LadderPrint;

import static ladder.print.PrintState.AFTER;
import static ladder.print.PrintState.BEFORE;

public class LadderRunner {

    private final Ladder ladder;
    private final LadderPrint ladderPrint ;

    private LadderRunner(Ladder ladder) {
        this.ladder = ladder;
        this.ladderPrint = LadderPrint.of(ladder);
    }

    public static LadderRunner of(Ladder ladder){
        return new LadderRunner(ladder);
    }

    public int run(Position position) {

        for (int i = 0; i < ladder.getLadderSize().getRow(); i++) {

            ladderPrint.printLadderState(position,BEFORE);
            ladder.getRows()[i].nextPosition(position);
            ladderPrint.printLadderState(position,AFTER);
            ladder.getRows()[i].moveRow(position);
        }
        return position.getCol();
    }
}
