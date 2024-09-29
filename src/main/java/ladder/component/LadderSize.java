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


}
