public class Ladder {

    private final int[][] rows;
    private final int numberOfPerson;
    private final DrawConfirm drawConfirm;

    //NaturalNumber를 사용해서 0이상의 값이 입력되도록 설정
    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.numberOfPerson = numberOfPerson.getNaturalNumber();
        rows = new int[row.getNaturalNumber()][numberOfPerson.getNaturalNumber() - 1];

        this.drawConfirm = new DrawConfirm(rows, row.getNaturalNumber(), numberOfPerson.getNaturalNumber());
    }

    public void drawLine(int row, int position) {
        if (!this.drawConfirm.confirm(row, position)) {
            throw new IllegalArgumentException("Cannot Draw Line");
        }

        rows[row][position] = 1;
    }

    /*private void drawLine(int position) {
        boolean prevLine = false;

        for (int i = 0; i < numberOfPerson - 1; i++) {
            if (!prevLine && (Math.random() < 0.5 || i == numberOfPerson - 2)) {
                rows[position][i] = 1;
                prevLine = true;
            } else {
                rows[position][i] = 0;
                prevLine = false;
            }
        }
    }*/

    public int run(int startPosition) {
        StartPositionConfirm(startPosition);
        int currentPosition = startPosition - 1;

        for (int[] row : rows) {
            currentPosition = movePosition(currentPosition, row);
        }

        return currentPosition + 1;
    }

    private void StartPositionConfirm(int startPosition) {
        if (startPosition < 1 || startPosition > numberOfPerson) {
            throw new IllegalArgumentException("Invalid start position");
        }
    }

    private int movePosition(int currentPosition, int[] row) {
        if (currentPosition > 0 && row[currentPosition - 1] == 1) {
            return currentPosition - 1;
        }
        if (currentPosition < numberOfPerson - 1 && row[currentPosition] == 1) {
            return currentPosition + 1;
        }
        return currentPosition;
    }

}
