package ladder.runner;

import ladder.*;
import ladder.constants.ExceptionMessage;
import ladder.printer.GameStatePrinter;
import ladder.constants.PrintTiming;
import ladder.wrapper.ArrayIndex;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(ArrayIndex startingLadderIndex) {

        validateLadderIndex(startingLadderIndex);

        Player player = Player.startingFrom(startingLadderIndex);

        GameStatePrinter gameStatePrinter = new GameStatePrinter(rows,player);

        while (!player.isAtBottom(rows.length)) {

            gameStatePrinter.print(PrintTiming.BEFORE);

            player.moveIfThereIsLineIn(rows[player.getCurrentDepth()]);

            gameStatePrinter.print(PrintTiming.AFTER);

            player.moveToBottom();
        }

        return player.getCurrentLadderIndex();
    }

    private void validateLadderIndex(ArrayIndex startingLadderIndex) {
        if(rows[0].LineLength() <= startingLadderIndex.getIndex()){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_STARTING_POSITION.getMessage());
        }
    }

}
