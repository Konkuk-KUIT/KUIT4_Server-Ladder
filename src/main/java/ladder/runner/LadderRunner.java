package ladder.runner;

import ladder.Position;
import ladder.Row;
import ladder.nodeState;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(int startingLadderIndex) {
        int currentDepth = 0;
        int currentLadderIndex = startingLadderIndex;

        while (currentDepth < rows.length) {

            printLadder(currentDepth,currentLadderIndex,"Before");

            if (rows[currentDepth].currentState(currentLadderIndex).hasLine()) {
                //옆으로 향하는 다리가 있을 경우 양 옆을 탐색함

                //오른쪽에 있을 경우
                if(rows[currentDepth].rightSideOfCurrentState(currentLadderIndex) == nodeState.RIGHT) {
                    currentLadderIndex++;
                } else if (rows[currentDepth].leftSideOfCurrentState(currentLadderIndex) == nodeState.LEFT){
                    currentLadderIndex--;
                }

            }

            printLadder(currentDepth,currentLadderIndex,"After");

            currentDepth++;
        }

        return currentLadderIndex;
    }

    public void printLadder (int currentDepth, int currentLadderIndex, String Title) {
        System.out.println(Title);
        for(int i=0;i<rows.length; i++){
            for(int j = 0; j < rows[0].LineLength(); j++){
                String currentState = rows[i].currentState(j).getState();
                System.out.print(currentState);
                if(i == currentDepth && j == currentLadderIndex){
                    System.out.print("*");
                }
                if(currentState == "L"){
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
        System.out.println();

    }
}
