public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {

        this.rows = new int[row][numberOfPerson];

    }

    public void drawLine (Position position) {
        //이미 가로줄이 있을 경우
        if(rows[position.getRow()][position.getColumn()] == 1) {
            throw new IllegalArgumentException();
        }

        rows[position.getRow()][position.getColumn()] = 1;

        if(position.getDirection() == Direction.LEFT){
            rows[position.getRow()][position.getColumn()-1] = 1;
        }

        if(position.getDirection() == Direction.RIGHT){
            rows[position.getRow()][position.getColumn()+1] = 1;
        }

    }

    public int run (int startingLadder) {

        int rowCount = 0;
        int currentLadder = startingLadder;
        
        while (rowCount < rows.length) {

            if (rows[rowCount][currentLadder] == 1) {
                //옆으로 향하는 다리가 있을 경우 양 옆을 탐색함
                
                //오른쪽에 있을 경우
                if(rows[rowCount][currentLadder + 1] == 1) {
                    currentLadder++;
                } else {
                    currentLadder--;
                }
            }

            rowCount++;
        }
        
        return currentLadder;
    }
}
