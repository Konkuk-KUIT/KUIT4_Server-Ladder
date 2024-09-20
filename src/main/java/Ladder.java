public class Ladder {
    private final int[][] rows;
    private final int row;
    private final int col;
    private final Draw draw;

    public Ladder(int row, int numberOfPerson) {
        this.row = row;
        this.col = numberOfPerson;
        this.rows = new int[row][col-1];
        this.draw = new Draw(this.rows, row, col);
    }

    public void drawLine(int row, int position) {
        if (!this.draw.canDrawLine(row, position)) {
            throw new IllegalArgumentException("Cannot Draw Line");
        }
        rows[row][position] = 1;
    }

    public int run(int startPosition) {
        if (startPosition < 1 || startPosition > col) {
            throw new IllegalArgumentException("Invalid Position");
        }

        int position = startPosition - 1;

        for (int i = 0; i < row; i++) {
            //오른쪽으로
            if (position < col - 1 && rows[i][position] == 1) {
                position++;
            }
            //왼쪽으로
            else if (position > 0 && rows[i][position - 1] == 1) {
                position--;
            }
        }
        return position + 1;
    }

    public void printLadder() {
        draw.printLadder();
    }
}