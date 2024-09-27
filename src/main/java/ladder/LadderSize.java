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

    public int getNumberOfRowValue() {
        return numberOfRow.getNumber();
    }

    public int getNumberOfPersonValue() {
        return numberOfPerson.getNumber();
    }

    public int getMaxLineCount() {
        return (int)(numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3);
    }
}
