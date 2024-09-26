package ladder.component;

public class LadderSize {

    GreaterThanOne numberOfRow;
    GreaterThanOne numberOfPerson;

    private LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize from(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        return new LadderSize(numberOfRow, numberOfPerson);
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    // 몇 개의 사다리를 자동으로 그릴지 결정. 우선 하나의 사다리를 그린 후 시작할 것이므로 계산 결과에서 1을 뺀 값을 반환함
    public int getNumberOfLines() {
        return (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3) - 1;
    }
}
