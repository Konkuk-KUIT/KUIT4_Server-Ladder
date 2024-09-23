import ladder.Direction;
import ladder.LadderGame;
import ladder.Position;
import ladder.Row;
import ladder.creator.LadderCreator;

import java.util.ArrayList;

public class LadderGameFactory {

    private static LadderCreator ladderCreator = LadderCreator.from(2,2);


    static void setLadderCreator(LadderCreator ladderCreator) {
        LadderGameFactory.ladderCreator = ladderCreator;
    }

    public static LadderGame createLadderGame() {
        return new LadderGame(ladderCreator);
    }

    public static LadderGame createRandomLadderGame() {
        Row[] rows = ladderCreator.getRows();

        int rowsLength = rows.length;
        int colLength = rows[0].LineLength();

        int numberOfRandomLines = (int)Math.floor(rowsLength * colLength * 0.3);
        boolean[][] overlapLine = new boolean[rowsLength][colLength];
        ArrayList<Position> positionList = new ArrayList<>();


        while(positionList.size() != numberOfRandomLines){
            int rowIndex = (int)Math.floor(Math.random()*rowsLength);
            int colIndex = (int)Math.floor(Math.random()*(colLength-1));

            if(overlapLine[rowIndex][colIndex] != true && overlapLine[rowIndex][colIndex+1] != true){
                positionList.add(Position.of(rowIndex, colIndex, Direction.RIGHT));

                overlapLine[rowIndex][colIndex] = true;
                overlapLine[rowIndex][colIndex+1] = true;
            }
        }

        positionList.forEach(position -> {
           ladderCreator.drawLine(position);
        });

        return new LadderGame(ladderCreator);
    }
}
