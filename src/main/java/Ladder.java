public class Ladder {

    private final int[][] rows;
    private final int numberOfPersons;
    private final int height;

    public Ladder(int height, int numberOfPersons) {
        this.height = height;
        this.numberOfPersons = numberOfPersons;
        this.rows = new int[height][numberOfPersons - 1];
    }


    public void drawLine(int height, int position) {
        if (height < 0 || height >= this.height) {
            throw new IllegalArgumentException("잘못된 줄 번호입니다.");
        }
        if (position < 0 || position >= this.numberOfPersons - 1) {
            throw new IllegalArgumentException("잘못된 위치입니다.");
        }
        rows[height][position] = 1;
    }


    public int run(int startPosition) {
        if (startPosition < 0 || startPosition >= numberOfPersons) {
            throw new IllegalArgumentException("잘못된 시작 위치입니다.");
        }

        int currentPosition = startPosition;
        for (int i = 0; i < height; i++) {
            currentPosition = move(currentPosition, i);
        }
        return currentPosition;
    }


    private int move(int currentPosition, int rowIndex) {
        if (currentPosition > 0 && rows[rowIndex][currentPosition - 1] == 1) {
            return currentPosition - 1;
        }
        if (currentPosition < numberOfPersons - 1 && rows[rowIndex][currentPosition] == 1) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
