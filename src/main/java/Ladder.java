public class Ladder {

    private final int[][] rows;
    //private PositionOfRows position;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public int[] getLadderLength() {
        int[] ladderLength = {rows.length, rows[0].length};
        return ladderLength;
    }

    public void drawLine(int x, int y) {
        rows[x][y] = 1;
        rows[x][y+1] = -1;
    }

    public boolean isLine(int x, int y) {
        if ((rows[x][y] == 1) && (rows[x][y+1] == -1)) { return true;}
        return false;
    }

    public int run(int startLine) {
        int col = startLine;
        for (int row = 0; row < rows.length; row++) {
            if (rows[row][col] == 0) { continue; }
            col += rows[row][col];
        }
        return col;
    }

}
