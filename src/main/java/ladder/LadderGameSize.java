package ladder;

public class LadderGameSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public LadderGameSize(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = new GreaterThanOne(numberOfRow);
        this.numberOfPerson = new GreaterThanOne(numberOfPerson);
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}
