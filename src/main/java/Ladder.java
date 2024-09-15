public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {

        this.rows = new int[row][numberOfPerson];

    }

    public void drawLine (Position position) {

        rows[position.getRow()][position.getColumn()] = position.getLadderNumber();

    }

    public int run (int arrivingLadder) {

        for(int i=0; i< rows[rows.length-1].length; i++) {
            if(rows[rows.length-1][i] == arrivingLadder) {
                return i;
            }
        }
        return -1;
    }
}
