package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LadderAutoCreator implements LadderCreator {
    private  Row[] rows;

    public LadderAutoCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }
    public Row[] getRows() {return rows;}

    public void drawLine(Position row, Position col){
        Set<LadderPosition> lines = new HashSet<>();

        int numberOfLines = (int)(rows.length * rows[0].getNodeLength() * 0.3) - 1;

        while(lines.size() < numberOfLines){
            row = getRandomRow();
            col = getRandomCol();
            LadderPosition ladderPosition = new LadderPosition(row, col);
            if(!canDrawLine(row,col)){
                continue;
            }
            lines.add(ladderPosition);

        }

    }

    private Position getRandomCol() {
        Random r = new Random();
        Position col;
        col = Position.from(r.nextInt(rows[0].getNodeLength() - 1));
        return col;
    }

    private Position getRandomRow() {
        Random r = new Random();
        Position row;
        row = Position.from(r.nextInt(rows.length - 1));
        return row;
    }

    private boolean canDrawLine(Position row, Position col) {
        try {
            rows[row.getValue()].drawLine(col);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
