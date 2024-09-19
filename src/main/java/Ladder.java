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

        // 각 줄을 내려가면서 이동
        for (int row = 0; row < rows.length; row++) {
            if (currentColumn > 0 && rows[row][currentColumn - 1] == 1) {
                currentColumn--; // 왼쪽으로 이동
            } else if (currentColumn < rows[0].length - 1 && rows[row][currentColumn] == 1) {
                currentColumn++; // 오른쪽으로 이동
            }
        }
        return currentColumn;
    }
}
