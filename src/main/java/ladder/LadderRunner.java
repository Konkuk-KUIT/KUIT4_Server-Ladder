package ladder;

import ladder.component.LadderPosition;
import ladder.component.Position;
import ladder.component.Row;
import ladder.printer.LadderPrinter;

import static ladder.constant.TimeLine.*;

public class LadderRunner {

    private final Row[] rows;
    private final LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrinter = LadderPrinter.from(rows);
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {

            System.out.println(BEFORE.getValue());
            ladderPrinter.printWholeLine(LadderPosition.from(Position.from(i), position));

            rows[i].nextPosition(position);

            System.out.println(AFTER.getValue());
            ladderPrinter.printWholeLine(LadderPosition.from(Position.from(i), position));

        }

        return position.getValue();
    }

}
