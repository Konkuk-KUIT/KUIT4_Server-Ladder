package ladder;

public class Ladder {

    private Row[] rows;

    static final int hasLine = 1;

    private Ladder(int row, int column) {
        this.rows = new Row[row];

        for(int i=0;i<row;i++){
            rows[i] = new Row(column);
        }
    }

    public static Ladder of(int row, int column) {
        return new Ladder(row, column);
    }

    public void drawLine (Position position) {
        //이미 가로줄이 있을 경우
//        if(rows[position.getRow()].currentState(position.getColumn()) == hasLine) {
//            throw new IllegalArgumentException();
//        }

        rows[position.getRow()].drawLineAt(position.getColumn(), position.getDirection());

    }

    public int run (int startingLadderIndex) {

        int currentDepth = 0;
        int currentLadderIndex = startingLadderIndex;
        
        while (currentDepth < rows.length) {

            printLadder(currentDepth,currentLadderIndex,"Before");

            if (rows[currentDepth].currentState(currentLadderIndex) == nodeState.hasLine) {
                //옆으로 향하는 다리가 있을 경우 양 옆을 탐색함
                
                //오른쪽에 있을 경우
                if(rows[currentDepth].rightSideOfCurrentState(currentLadderIndex) == nodeState.hasLine) {
                    currentLadderIndex++;
                } else if (rows[currentDepth].leftSideOfCurrentState(currentLadderIndex) == nodeState.hasLine){
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
                System.out.print(rows[i].currentState(j));
                if(i == currentDepth && j == currentLadderIndex){
                    System.out.print("*");
                }
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();

    }

}

