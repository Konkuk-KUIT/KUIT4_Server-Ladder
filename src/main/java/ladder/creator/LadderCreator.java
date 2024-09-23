package ladder.creator;

import ladder.Position;
import ladder.Row;

public class LadderCreator {

    private Row[] rows;

    private LadderCreator(int row, int column) {
        this.rows = new Row[row];

        for(int i=0;i<row;i++){
            rows[i] = new Row(column);
        }
    }

    public static LadderCreator from(int row, int column){
        return new LadderCreator(row, column);
    }

    public void drawLine (Position position) {
        //이미 가로줄이 있을 경우
//        if(rows[position.getRow()].currentState(position.getColumn()) == hasLine) {
//            throw new IllegalArgumentException();
//        }

        rows[position.getRow()].drawLineAt(position.getColumn(), position.getDirection());

    }

    public Row[] getRows() {
        return rows;
    }
}
