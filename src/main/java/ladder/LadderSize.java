package ladder;

public class LadderSize {
    private GreaterThanOne numberOfRow;
    private GreaterThanOne numberOfPerson;

    private LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson){
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize of(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson){
        return new LadderSize(numberOfRow, numberOfPerson);
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}
