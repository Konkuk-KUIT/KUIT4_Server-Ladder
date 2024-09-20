public class Ladder {

    private Rows rows;

    static final int hasLine = 1;

    private Ladder(gameEntry entry) {
        this.rows = Rows.of(entry.getRow(),entry.getColumn());
    }

    public static Ladder of(int row, int column) {
        return new Ladder(gameEntry.from(row,column));
    }

    public void drawLine (Position position) {
        //이미 가로줄이 있을 경우
        if(rows.currentState(position) == hasLine) {
            throw new IllegalArgumentException();
        }

        rows.drawLineAt(position);

    }

    public int run (int startingLadderIndex) {

        int currentDepth = 0;
        int currentLadderIndex = startingLadderIndex;
        
        while (currentDepth < rows.maxLadderDepth()) {

            if (rows.currentState(currentDepth,currentLadderIndex) == hasLine) {
                //옆으로 향하는 다리가 있을 경우 양 옆을 탐색함
                
                //오른쪽에 있을 경우
                if(rows.rightSideOfCurrentState(currentDepth,currentLadderIndex) == hasLine) {
                    currentLadderIndex++;
                } else if (rows.leftSideOfCurrentState(currentDepth,currentLadderIndex) == hasLine){
                    currentLadderIndex--;
                }
            }

            currentDepth++;
        }
        
        return currentLadderIndex;
    }

}

class Rows {
    private int[][] rows;
    public Rows(int row, int column) {
        rows = new int[row][column];
    }
    public static Rows of(int row, int column) {
        return new Rows(row, column);
    }

    public int currentState(Position position) {
        return rows[position.getRow()][position.getColumn()];
    }

    public int currentState(int row, int column) {
        return rows[row][column];
    }

    public int rightSideOfCurrentState(int row, int column) {
        return rows[row][column+1];
    }

    public int leftSideOfCurrentState(int row, int column) {
        return rows[row][column-1];
    }

    public void drawLineAt(Position position) {

        rows[position.getRow()][position.getColumn()] = Ladder.hasLine;

        if(position.getDirection() == Direction.LEFT){
            rows[position.getRow()][position.getColumn()-1] = Ladder.hasLine;
        }

        if(position.getDirection() == Direction.RIGHT){
            rows[position.getRow()][position.getColumn()+1] = Ladder.hasLine;
        }
    }

    public int maxLadderDepth() {
        return rows.length;
    }
}