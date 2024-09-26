package ladder.creator;

import ladder.Line;
import ladder.Row;
import ladder.wrapper.unsignedInt;

public abstract class LadderCreator {
    Row[] rows;

    LadderCreator(unsignedInt row, unsignedInt column) {
        this.rows = new Row[row.getValue()];

        for(int i=0;i<row.getValue();i++){
            rows[i] = new Row(column.getValue());
        }
    }

    public void drawLine (Line line) {
        rows[line.getRow()].drawLineAt(line.getColumn(), line.getDirection());
    }

    public Row[] getRows() {
        return rows;
    }

}
