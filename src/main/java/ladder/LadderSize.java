package ladder;

public class LadderSize {

    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRow() { return numberOfRow.getNumber(); }

    public int getNumberOfPerson() { return numberOfPerson.getNumber(); }
}
