package ladder;

public class LadderSize {
    private GreaterThanOne numberOfRow;
    private GreaterThanOne numberOfPerson;

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
}
