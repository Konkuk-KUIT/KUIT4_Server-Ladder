package ladder;

public class Row {
    private final int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = 1;
        row[startPosition + 1] = -1;
    }

    public int nextPosition(int position) {
        validatePosition(position);

        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("참여 인원은 1명 이상이어야 합니다.");
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == -1 || row[startPosition + 1] == 1) {
            throw new IllegalArgumentException("사다리를 그릴 수 없는 위치입니다.");
        }
    }
}