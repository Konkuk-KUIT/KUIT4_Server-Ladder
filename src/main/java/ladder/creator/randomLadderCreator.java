package ladder.creator;

import ladder.Line;
import ladder.constants.Direction;
import ladder.wrapper.unsignedInt;

import java.util.ArrayList;

public class randomLadderCreator extends LadderCreator {

    private randomLadderCreator(unsignedInt row, unsignedInt column) {
        super(row, column);
        drawRandomLines();
    }

    private void drawRandomLines() {

        int rowsLength = rows.length;
        int colLength = rows[0].LineLength();

        int numberOfRandomLines = (int)Math.floor(rowsLength * colLength * 0.3);
        boolean[][] overlapLine = new boolean[rowsLength][colLength];
        ArrayList<Line> lineList = new ArrayList<>();


        while(!isEnoughRandomLine(lineList, numberOfRandomLines)){

            int rowIndex = (int)Math.floor(Math.random()*rowsLength);
            int colIndex = (int)Math.floor(Math.random()*(colLength-1));

            if(isLineValid(colIndex, overlapLine[rowIndex])){
                lineList.add(Line.of(rowIndex, colIndex, Direction.RIGHT));

                overlapLine[rowIndex][colIndex] = true;
                overlapLine[rowIndex][colIndex+1] = true;
            }
        }

        drawLinesInList(lineList);

    }

    private static boolean isLineValid(int colIndex, boolean[] overlapLine) {
        return overlapLine[colIndex] == false && overlapLine[colIndex + 1] == false;
    }

    private void drawLinesInList(ArrayList<Line> lineList) {
        lineList.forEach(this::drawLine);
    }

    private static boolean isEnoughRandomLine(ArrayList<Line> lineList, int numberOfRandomLines) {
        return lineList.size() == numberOfRandomLines;
    }

    public static randomLadderCreator from(unsignedInt row, unsignedInt column) {
        return new randomLadderCreator(row,column);
    }



}
