public class Row {

    private int[] row;

    public Row(int personCount) {

        row = new int[personCount];
    }

    public void drawLine(int columnNumber) {

        validateColumnNumber(columnNumber);

        row[columnNumber] = 1;
        row[columnNumber + 1] = -1;
    }

    public int nextLadderNumber(int currentLadderNumber) {

        validateLadderNumber(currentLadderNumber);

        return currentLadderNumber + row[currentLadderNumber];
    }

    private void validateColumnNumber(int columnNumber) {

        if(columnNumber < 0 || columnNumber > row.length - 2) {
            throw new IllegalArgumentException("라인을 생성할 수 없는 위치입니다.");
        }

        if(!(row[columnNumber] == 0 && row[columnNumber + 1] == 0)) {
            throw new IllegalArgumentException("이미 라인이 그려져 있는 위치입니다.");
        }
    }

    private void validateLadderNumber(int ladderNumber) {

        if(ladderNumber < 0 || ladderNumber > row.length - 1) {
            throw new IllegalArgumentException("존재하지 않는 사다리 번호입니다.");
        }
    }
}
