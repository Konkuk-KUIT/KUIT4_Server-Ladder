public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public int[] getLadderLength() {
        return new int[]{rows.length, rows[0].length};
    }

    public void drawLine(PositionOfLine position) {
        position.canDrawLine(rows);
        position.makeLine(rows);
    }

    public boolean isLine(PositionOfLine position) {
        return position.checkLine(rows);
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
