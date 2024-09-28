package ladder;

public class LadderSize {

    private GreaterThanOne numberOfPerson;
    private GreaterThanOne numberOfRow;

    public LadderSize(GreaterThanOne numberOfPerson, GreaterThanOne numberOfRow) {
        this.numberOfPerson = numberOfPerson;
        this.numberOfRow = numberOfRow;
    }
    public static LadderSize from(GreaterThanOne numberOfPerson, GreaterThanOne numberOfRow) {
        return new LadderSize(numberOfPerson, numberOfRow);
    }
    public GreaterThanOne getNumberOfPerson(){
        return numberOfPerson;
    }

    public GreaterThanOne getNumberOfRow(){
        return numberOfRow;
    }
}
