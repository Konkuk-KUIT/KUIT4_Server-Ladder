public class Ladder {

    private final Row[] rows;

    public Ladder(int rowCount, int personCount) {

        validateLadderSize(rowCount, personCount);

        rows = new Row[rowCount];

        for(int i = 0; i < rowCount; i++) {
            rows[i] = new Row(personCount);
        }
    }

    public void drawLine(int rowNumber ,int columnNumber) {

        validateRowNumber(rowNumber);

        rows[rowNumber].drawLine(columnNumber);
    }

    public int run(int ladderNumber) {

        int currentLadderNumber = ladderNumber;

        for (Row row : rows) {
            currentLadderNumber = row.nextLadderNumber(currentLadderNumber);
        }

        return currentLadderNumber;
    }

    private void validateLadderSize(int rowCount, int personCount) {

        if(rowCount < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }

        if(personCount < 1) {
            throw new IllegalArgumentException("참여 인원 수는 1 이상이어야 합니다.");
        }
    }

    private void validateRowNumber(int rowNumber) {

        if(rowNumber < 0 || rowNumber > rows.length - 1) {
            throw new IllegalArgumentException("라인을 생성할 수 없는 위치입니다.");
        }
    }
}
