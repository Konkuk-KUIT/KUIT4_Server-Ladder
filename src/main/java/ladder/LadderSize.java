package ladder;

public class LadderSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;
    private static final double LINE_PROBABILITY = 0.3;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    public int calculateNumberOfLines() {
        // 사다리 행 * 열 * 0.3에 해당하는 라인의 수 계산
        return (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * LINE_PROBABILITY);
    }
}
