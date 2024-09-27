package ladder;

public class LadderSize {
    GreaterThanOne row, numberOfPerson;

    public LadderSize(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }

    public GreaterThanOne getRow() {
        return row;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getIntRow() {
        return row.getNumber();
    }

    public int getIntNumberOfPerson() {
        return numberOfPerson.getNumber();
    }

    // 생성해야 할 라인 개수 반환
    public int getLadderLineNum() {
        return (int) Math.floor(numberOfPerson.getNumber() * row.getNumber() * 0.3);
    }

}
