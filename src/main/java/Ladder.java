public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(Position start, Position end) {
        int startRow = start.getRow() - 1;
        int startCol = start.getCol() - 1;
        int endRow = end.getRow() - 1;
        int endCol = end.getCol() - 1;
        if (startRow != endRow || (startCol != endCol - 1 && startCol != endCol + 1)) {
            throw new IllegalArgumentException("row가 다르거나, col이 1 차이가 아니어서 가로줄을 그릴 수 없음");
        }

        rows[startRow][Math.min(startCol, endCol)] = 1;
    }

    public int run(int position) {

        // position이 유효한 범위 안에 있는지 확인 - 사다리 범위 벗어났을 때 테스트 실패하게
        if (position < 1 || position > rows[0].length) {
            throw new IllegalArgumentException("유효하지 않은 position : " + position);
        }

        position = position - 1;

        for (int i = 0; i < rows.length; i++) {
            if (position > 0 && rows[i][position - 1] == 1) {
                position--;
                continue;
            }
            if (position < rows[0].length - 1 && rows[i][position] == 1) {
                position++;
            }
        }

        return position + 1;
    }
}
