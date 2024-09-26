package ladder.creator;

import ladder.Line;
import ladder.Row;
import ladder.constants.ExceptionMessage;
import ladder.wrapper.unsignedInt;

public abstract class LadderCreator {
    Row[] rows;

    LadderCreator(unsignedInt row, unsignedInt column) {
        validateLadder(row, column);

        this.rows = new Row[row.getValue()];

        for(int i=0;i<row.getValue();i++){
            rows[i] = new Row(column.getValue());
        }
    }

    private void validateLadder(unsignedInt row, unsignedInt column) {
        if(row.getValue() <= 2 || column.getValue() <= 2){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER.getMessage());
        }
    }

    public void drawLine (Line line) {

        validateLineInformation(line);

        rows[line.getRow()].drawLineAt(unsignedInt.from(line.getColumn()), line.getDirection());
    }

    private void validateLineInformation(Line line) {
        if(invalidLine(line)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean invalidLine(Line line) {
        if(isInvalidRow(line) || isInvalidColumn(line)){
            return true;
        } else {
            return false;
        }
    }

    private boolean isInvalidColumn(Line line) {
        return (line.getColumn() >= rows[0].LineLength());
    }

    private boolean isInvalidRow(Line line) {
        return (line.getRow() >= rows.length);
    }

    public Row[] getRows() {
        return rows;
    }

}
