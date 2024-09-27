package ladder;

public class LadderSize {
    private final int numberOfRows;
    private final int numberOfPersons;

    private LadderSize(int numberOfRows, int numberOfPersons) {
        if (numberOfRows <= 0 || numberOfPersons <= 0) {
            throw new IllegalArgumentException("Rows and persons must be greater than 0.");
        }
        this.numberOfRows = numberOfRows;
        this.numberOfPersons = numberOfPersons;
    }

    // 정적 팩토리 메서드를 통해 객체 생성
    public static LadderSize of(int numberOfRows, int numberOfPersons) {
        return new LadderSize(numberOfRows, numberOfPersons);
    }

    // 행 수 반환
    public int getNumberOfRows() {
        return numberOfRows;
    }

    // 사람 수 반환
    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    // 총 라인의 개수 계산 (정책: 사다리 행 * 열 * 0.3)
    public int calculateTotalLines() {
        return (int) (numberOfRows * numberOfPersons * 0.3);
    }
}