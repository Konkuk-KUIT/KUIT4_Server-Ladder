public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    // 가로줄 그리기
    public void drawLine(Position start, Position end) {
        int startRow = setIndexToZeroBased(start.getRow());
        int startCol = setIndexToZeroBased(start.getCol());
        int endRow = setIndexToZeroBased(end.getRow());
        int endCol = setIndexToZeroBased(end.getCol());

        checkContinuousLines(startRow, startCol);

        if (startRow != endRow || (startCol != endCol - 1 && startCol != endCol + 1)) {
            throw new IllegalArgumentException("row가 서로 다르거나, col이 1 차이가 아니어서 가로줄을 그릴 수 없음");
        }

        rows[startRow][Math.min(startCol, endCol)] = 1;
    }

    // 사다리 타기 실행
    public int run(int position) {
        checkPositionValidation(position);
        position = setIndexToZeroBased(position);

        for (int i = 0; i < rows.length; i++) {
            position = move(position, i);
        }

        return setIndexToOneBased(position);
    }

    // 위치 이동 처리
    private int move(int position, int row) {
        if (position > 0 && rows[row][position - 1] == 1) {
            return setIndexToZeroBased(position);
        }
        if (position < rows[0].length - 1 && rows[row][position] == 1) {
            return setIndexToOneBased(position);
        }

        return position;
    }

    // 가로줄이 가로 연속으로 그려질 수 없게 처리
    private void checkContinuousLines(int row, int position) {
        if (position > 0 && rows[row][position - 1] == 1) {
            throw new IllegalArgumentException("왼쪽에 이미 가로줄이 있어서 이어지는 가로줄을 그릴 수 없음");
        }
        if (position < rows[0].length - 1 && rows[row][position + 1] == 1) {
            throw new IllegalArgumentException("오른쪽에 이미 가로줄이 있어서 이어지는 가로줄을 그릴 수 없음");
        }
    }

    // position이 유효한 범위 안에 있는지 확인 -> 사다리 범위 벗어났을 때 테스트 실패
    private void checkPositionValidation(int position) {
        if (position < 1 || position > rows[0].length) {
            throw new IllegalArgumentException("유효하지 않은 position : " + position);
        }
    }

    private int setIndexToZeroBased(int index) {
        return index - 1;
    }

    private int setIndexToOneBased(int index) {
        return index + 1;
    }
}
