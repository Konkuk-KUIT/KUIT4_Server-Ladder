public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int x, int y) {
        // check ladder index range
        if (y + 1 >= rows[0].length || y < 0 || x >= rows.length || x < 0) {
            throw new IllegalArgumentException("Line cannot be drawn: index is out of bounds.");
        }

        rows[x][y] = 1;
        rows[x][y + 1] = -1;
    }

    public void printLadder() {
        for (int i = 0; i < rows.length; i++) {
            printRow(rows[i]);
        }
    }

    private void printRow(int[] row) {
        for (int j = 0; j < row.length; j++) {
            System.out.print(row[j] + " ");
        }
        System.out.println();
    }

    public int run(int startLadder) {
        int moveResult = startLadder;
        for (int i = 0; i < rows.length; i++) {
            switch (rows[i][moveResult]) {
                case 0:
                    break;
                case 1:
                    moveResult++;
                    break;
                case -1:
                    moveResult--;
                    break;
            }
        }
        return moveResult;
    }
}
