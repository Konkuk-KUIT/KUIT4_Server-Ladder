public class Ladder {

    private final int[][] rows;

    public Ladder(UnsignedInteger row, UnsignedInteger numberOfPerson) {
        rows = new int[row.getUnsignedInteger()][numberOfPerson.getUnsignedInteger()];
    }

    public void drawLine(Coordinate coordinate) {
        UnsignedInteger x = coordinate.getX();
        UnsignedInteger y = coordinate.getY();
        // check ladder index range
        if (y.getUnsignedInteger() + 1 >= rows[0].length || y.getUnsignedInteger() < 0
                || x.getUnsignedInteger() >= rows.length || x.getUnsignedInteger() < 0) {
            throw new IllegalArgumentException("Line cannot be drawn: index is out of bounds.");
        }

        rows[x.getUnsignedInteger()][y.getUnsignedInteger()] = 1;
        rows[x.getUnsignedInteger()][y.getUnsignedInteger() + 1] = -1;
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
