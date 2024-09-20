public class Ladder {

    private final int[][] rows; // 사다리를 나타내는 2차원 배열

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    // 특정 위치에 가로선을 그리기
    public void drawLine(Position position) {
        position.createLine(rows);
    }

    // 몇 번째 사람이 사다리를 타고 도착하는 위치를 반환
    public int run(int startColumn) {
        int currentColumn = startColumn;

        for (int row = 0; row < rows.length; row++) {
            currentColumn = moveLeftOrRight(row, currentColumn);
        }
        return currentColumn;
    }

    private int moveLeftOrRight(int row, int currentColumn) {
        if (canMoveLeft(row, currentColumn)) {
            return currentColumn - 1;
        } else if (canMoveRight(row, currentColumn)) {
            return currentColumn + 1;
        }
        return currentColumn;
    }

    private boolean canMoveLeft(int row, int currentColumn) {
        return currentColumn > 0 && rows[row][currentColumn - 1] == 1;
    }

    private boolean canMoveRight(int row, int currentColumn) {
        return currentColumn < rows[0].length - 1 && rows[row][currentColumn] == 1;
    }
}
