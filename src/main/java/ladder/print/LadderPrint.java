package ladder.print;

import ladder.info.Ladder;
import ladder.Position;
import ladder.info.Row;

public class LadderPrint {

    private final Ladder ladder;
    private final StringBuilder line = new StringBuilder();

    private LadderPrint(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderPrint of(Ladder ladder){
        return new LadderPrint(ladder);
    }

    public void printLadderState(Position position,PrintState state) {

        updateLine(state.getState()+"\n");
        //행 반복
        for (int row = 0; row < ladder.getLadderSize().getRow(); row++) {
            printStateUpdate(position, row ,ladder.getRows()[row]);
        }
        System.out.println(line.toString());
        setLine();
    }

    private void printStateUpdate(Position position, int currentRow, Row rows) {

        //열 반복
        for (int col = 0; col < ladder.getLadderSize().getCol(); col++) {

            updateLine(rows.getNodes()[col].getDirection().getValue());
            if (position.isCurrentPosition(currentRow, col))
                updateLine("*");
            updateLine(" ");
        }
        line.append("\n");
    }

    private void setLine() {
        line.setLength(0);
    }

    private void updateLine(int ladderState){
        line.append(ladderState);
    }

    private void updateLine(String printString){
        line.append(printString);
    }


}
