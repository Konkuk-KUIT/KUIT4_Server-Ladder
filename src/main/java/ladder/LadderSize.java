package ladder;

public class LadderSize {

    private GreaterThanOne numberOfRow, numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRandomLine() {
        return (int)Math.round(this.numberOfRow.getNumber() * this.numberOfPerson.getNumber() * 0.3);
    }
}
